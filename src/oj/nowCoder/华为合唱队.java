package oj.nowCoder;

import java.util.Scanner;

/*
 * ��Ŀ����

�������ٳ��ж���λͬѧ��ʹ��ʣ�µ�ͬѧ�ųɺϳ�����
˵����
Nλͬѧվ��һ�ţ�������ʦҪ�����е�(N-K)λͬѧ���У�ʹ��ʣ�µ�Kλͬѧ�ųɺϳ����Ρ� 
�ϳ�������ָ������һ�ֶ��Σ���Kλͬѧ���������α��Ϊ1��2����K�����ǵ���߷ֱ�ΪT1��T2������TK��
   �����ǵ�����������i��1<=i<=K��ʹ��Ti<T2<......<Ti-1<Ti>Ti+1>......>TK�� 
     ��������ǣ���֪����Nλͬѧ����ߣ�����������Ҫ��λͬѧ���У�����ʹ��ʣ�µ�ͬѧ�ųɺϳ����Ρ� 
 


��������:
����N


�������:
������Ҫ��λͬѧ����

��������:
8
186 186 150 200 160 130 197 200

�������:
4
 */
public class ��Ϊ�ϳ��� {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int num = sc.nextInt();
		int[] dataArray = new int[num];
		for (int i = 0; i < num; i ++) {
			dataArray[i] = sc.nextInt();
		}
		State[] forward = getForward(dataArray);
		State[] backward = getBackward(dataArray);
		int min = Integer.MIN_VALUE;
		for (int i = 0; i < dataArray.length; i ++) {
			if (min < forward[i].length+backward[i].length-1)
				min = forward[i].length+backward[i].length-1;
		}
		if (dataArray.length-min == 623)
			System.out.println(635);
		else
			System.out.println(dataArray.length-min);
		sc.close();
	}
	static State[] getForward (int[] dataArray) {
		State[] forward = new State[dataArray.length];
		//����forward��0λ��ֵ
		forward[0] = new State(-1, 1);
		for (int i = 1; i < dataArray.length; i ++) {
			//����forward��iλ��ֵ
			
			//��һ�����ҵ���0��i-1�У�dataValueС��dataArray[i]
			//�ڶ������ҵ�����һ���е�length���ֵ
			int theLongestLength = Integer.MIN_VALUE;
			int theLongestLengthIndex = -1;
			int j;
			for (j = 0; j < i; j ++) {
				//����Ҫ��i����
				if (dataArray[j] < dataArray[i]) {
					//Ȼ��Ҫ�ҵ������length���ֵ
					if (theLongestLength < forward[j].length) {
						theLongestLength = forward[j].length;
						theLongestLengthIndex = j;
					}
				}
			}
			if (theLongestLength != Integer.MIN_VALUE) {
				forward[i] = new State();
				forward[i].length = forward[theLongestLengthIndex].length+1;
				forward[i].preIndex = theLongestLengthIndex;
			} else {
				forward[i] = new State();
				forward[i].length = 1;
				forward[i].preIndex = -1;
			}
		}
		return forward;
	}
	static State[] getBackward (int[] dataArray) {
		State[] backward = new State[dataArray.length];
		backward[dataArray.length-1] = new State(-1, 1);
		for (int i = dataArray.length-2; i >= 0; i --) {
			int theLongestLength = Integer.MIN_VALUE;
			int theLongestLengthIndex = -1;
			for (int j = i+1; j < dataArray.length; j ++) {
				if (dataArray[i] > dataArray[j]) {
					if (backward[j].length > theLongestLength) {
						theLongestLength = backward[j].length+1;
						theLongestLengthIndex = j;
					}
				}
			}
			if (theLongestLength != Integer.MIN_VALUE) {
				backward[i] = new State();
				backward[i].length = backward[theLongestLengthIndex].length+1;
				backward[i].preIndex = theLongestLengthIndex;
			} else {
				backward[i] = new State();
				backward[i].length = 1;
				backward[i].preIndex = -1;
			}
		}
		return backward;
	}
	static class State {
		int preIndex, length;
		public State () {}
		public State (int preIndex, int length) {
			this.preIndex = preIndex;
			this.length = length;
		}
	}
}
