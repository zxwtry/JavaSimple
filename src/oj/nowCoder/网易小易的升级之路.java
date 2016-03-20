package oj.nowCoder;

import java.util.Scanner;

/*



С�׾���������������Ϸ.��һ��,������һ�������������Ϸ,���Ľ�ɫ�ĳ�ʼ����ֵΪ a.
�ڽ�������һ��ʱ����,��������������n������,ÿ������ķ�����Ϊb1,b2,b3...bn. 
��������Ĺ��������biС�ڵ���С�׵ĵ�ǰ����ֵc,��ô���������ɴ�ܹ���,�� ��ʹ���Լ�������ֵ����bi;
���bi����c,����Ҳ�ܴ�ܹ���,����������ֵֻ������bi ��c�����Լ��.��ô��������,��һϵ�еĶ�����,С�׵���������ֵΪ����?

��������:
����ÿ������,��һ������������n(1��n<100000)��ʾ�����������a��ʾС�׵ĳ�ʼ����ֵ.
�ڶ���n������,b1,b2...bn(1��bi��n)��ʾÿ������ķ�����


�������:
����ÿ������,���һ��.ÿ�н�����һ������,��ʾС�׵���������ֵ

��������:
3 50
50 105 200
5 20
30 20 15 40 100

�������:
110
205


 */

public class ����С�׵�����֮· {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int num, yi, index;
		int[] deva;
		while (in.hasNext()) {
			num = in.nextInt();
			yi = in.nextInt();
			deva = new int[num];
			for (index = 0; index < num; index ++) {
				deva[index] = in.nextInt();
			}
			System.out.println(getAns(yi, deva));
		}
		
		in.close();
	}
	
	static int getAns (int yi, int[] deva) {
		final int len = deva.length;
		for (int index = 0; index < len; index ++) {
			if (deva[index] <= yi)
				yi += deva[index];
			else
				yi += getGY(yi, deva[index]);
		}
		return yi;
	}
	
	static int getGY (int num1, int num2) {
		
		
		int small = Math.min(num1, num2);
		int big = Math.max(num1,  num2);
		if (small < 1) {
			System.out.println("input is wrong " + small);
			return 0;
		}
		if (small == 1) {
			return small;
		} else if (small == 2) {
			if ( (big & 0x1) == 1 )
				return 1;
			else
				return 2;
		}
		if (num1 == num2)
			return num1;
		
		return getGY(big - small, small);
	}
	
}