package oj.nowCoder;

import java.util.Arrays;
import java.util.Scanner;

/*
һ����l�ı�ֱ�Ľֵ�����n��·�ƣ��������ֵ����Ϊ0���յ�Ϊl��
��i��·������Ϊai��ÿյ�ƿ��Ը��ǵ�����Զ����Ϊd��
Ϊ�������������еƵĵƹ���븲�������֣�����Ϊ��ʡ�磬
Ҫ�����d��С�����ҵ������С��d��

��������:
ÿ�����ݵ�һ����������n��l
��n����0С�ڵ���1000��lС�ڵ���1000000000����0����
�ڶ�����n������(�����ڵ���0С�ڵ���l)��Ϊÿյ�Ƶ����꣬���·�ƿ�����ͬһ�㡣


�������:
����𰸣�������λС����

��������:
7 15
15 5 3 7 9 14 0

�������:
2.5
 */
public class ����·�� {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		int n, l, a[];
		while (in.hasNext()) {
			n = in.nextInt();
			l = in.nextInt();
			a = new int[n];
			for (int i = 0; i < n; i ++) {
				a[i] = in.nextInt();
			}
			Arrays.sort(a);
			int max = Integer.MIN_VALUE;
			int maxT;
			for (int i = 0; i < a.length - 1; i ++) {
				maxT = a[i+1]-a[i];
				if (maxT > max) {
					max = maxT;
				}
			}
			int l1 = a[0] - 0, l2 = l - a[a.length - 1];
			l1 = Math.max(l1, l2);
			if (max > l1 * 2) {
				if ((max & 0x1) == 1)
				System.out.printf("%d.%d0\n", max/2, 5);
				else
					System.out.printf("%d.00\n", max/2);
			} else {
				System.out.println(l1+".00");
			}
		}
		in.close();
	}
}