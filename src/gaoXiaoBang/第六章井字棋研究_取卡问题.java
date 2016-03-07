/*
��Ͼʱ������Ħ˹�ͻ�����һ����Ϸ��

��N�ſ�Ƭ��д��N��������������������һ�ſ�Ƭ��
Ҫ����һ�����õ�����һ����ǰһ�����õ����ֵ�Լ��������
���磬ĳ�θ���Ħ˹���ߵĿ�Ƭ��д�����֡�6��������������������õ����ְ�����

1��2��3, 6��12��18��24 ....

���ֵ�ĳһ���ÿ�Ƭʱ��û������Ҫ��Ŀ�Ƭ��ѡ����÷�Ϊ�䷽��

�������ü���������Ƽ���һ�£�����֪���п�Ƭ�ϵ����ֺͿ�ѡ��Щ���ֵ������£�����ѡ����ܱ�֤��ʤ��

��ѡ������ֶ����Ա�ʤʱ�����������С�����֡����������ζ����䣬�����-1��

��������Ϊ2�С���һ�������ɿո�ֿ���������ÿ����������1~50�䣩����ʾ��ǰʣ������п�Ƭ��

�ڶ���Ҳ�����ɿո�ֿ�����������ʾ����ѡ�����֡���Ȼ���ڶ��е����ֱ�����ȫ�����ڵ�һ�е������С�

�����������ʤ���з�����

���磺

�û����룺

2 3 6
3 6

�����Ӧ�������

3

���磺

�û����룺

1 2 2 3 3 4 5
3 4 5

�����Ӧ�������

4
 */

package gaoXiaoBang;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;

public class �����¾������о�_ȡ������ {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader
				(new FileInputStream("c:\\data\\1.txt")));
		int[] a = getInt(br.readLine().trim());
		int[] b = getInt(br.readLine().trim());
		boolean[] isUsedA = new boolean[a.length];
		Vector<Integer> v = new Vector<Integer>();
		for (int i = 0; i < b.length; ++ i) {
			Arrays.fill(isUsedA, false);
			for (int j = 0; j < a.length; ++ j) {
				if (a[j] == b[i]) {
					isUsedA[j] = true;
					break;
				}
			}
			if (solve(a, isUsedA, b[i], 0)){
				v.add(b[i]);
			}
		}
		if (v.size() == 0) {
			System.out.println(-1);
		} else {
			int min = Integer.MAX_VALUE;
			Iterator<Integer> it = v.iterator();
			int temp;
			while (it.hasNext()) {
				temp = it.next();
				if (min > temp) {
					min = temp;
				}
			}
			System.out.println(min);
		}
		br.close();
	}
	
	private static boolean solve(int[] a, boolean[] isUsedA, int val, int times) {
		if (times+1 == a.length) {
			if ((times & 0x1) == 0) {
				//������ָ�Ҷ��ϴ��޸ĵ��жϣ��Ƿ�����ȷ
				return true;
			} else {
				return false;
			}
		}
		boolean canItPlay = false;
		for (int i = 0; i < a.length; ++ i) {
			if (isUsedA[i])
				continue;
			if (judge(a[i], val))
				canItPlay ^= true;
			if (canItPlay)
				break;
		}
		if (!canItPlay) {
			if ((times & 0x1) == 0) {
				//����ָ�����Ƕ��ֽ�û���κο���ѡ��
				return true;
			} else {
				return false;
			}
		}
		
		if ((times & 0x1) == 0) {
			//�������Ƕ��ֵ�ѡ��
			//���ֵ��κ�ѡ�����ն�Ҫ����ʧ��
			//����Ļ����ҵ�ѡ�����ʧ�ܵġ�
			boolean isItWin = true;
			for (int i = 0; i < a.length; ++ i) {
				
				if (isUsedA[i] || !judge(a[i], val))    continue;
				isUsedA[i] = true;
				times ++;
					isItWin &= solve(a, isUsedA, a[i], times);
//					if (!isItWin) 
//						return false;
				times --;
				isUsedA[i] = false;
			}
			if (isItWin){
				return true;
			} else {
				return false;
			}
		} else {
			//���������ҵ�ѡ��
			//�ҵ�ѡ���У��϶�Ҫ��һ��·�ǿ�������Ӯ��
			boolean isMyWin = false;
			for (int i = 0; i < a.length; ++ i) {
				
				if (isUsedA[i] || !judge(a[i], val))    continue;
				isUsedA[i] = true;
				times ++;
					isMyWin |= solve(a, isUsedA, a[i], times);
//					if (isMyWin)
//						return true;
				times --;
				isUsedA[i] = false;
			}
			if (isMyWin){
				return true;
			} else {
				return false;
			}
		}
	}

	private static boolean judge(int index, int val) {
		if (val % index == 0 || index % val == 0)
			return true;
		else 
			return false;
	}

	private static int[] getInt(String trim) {
		String[] spilt = trim.split(" ");
		int[] re = new int[spilt.length];
		for (int i = 0 ; i < spilt.length; ++ i) {
			re[i] = Integer.parseInt(spilt[i]);
		}
		return re;
	}
}
