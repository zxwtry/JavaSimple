package oj.nowCoder;

import java.util.Scanner;

/*
 *

Сv������n�ſΣ�ÿ�Ŷ��п��ԣ�Ϊ���õ���ѧ��Сv�������Լ���ƽ���ɼ�����Ϊavg��
ÿ�ſ���ƽʱ�ɼ��Ϳ��Գɼ���ɣ�����Ϊr��������֪��ÿ�ſε�ƽʱ�ɼ�Ϊai ,
���������ſεĿ��Գɼ�����һ�ֵĻ���СvҪ��bi ��ʱ�临ϰ������ϰ�Ļ���Ȼ����0�֡�
ͬʱ������Ȼ���Է��ָ�ϰ���ٶ�Ҳ�����õ��������ֵķ�����Ϊ���õ���ѧ��Сv����Ҫ������ʱ�临ϰ��

��������:
��һ����������n,r,avg(n���ڵ���1С�ڵ���1e5��r���ڵ���1С�ڵ���1e9,avg���ڵ���1С�ڵ���1e6)��
������n�У�ÿ����������ai��bi����С�ڵ���1e6���ڵ���1


�������:
һ������𰸡�

��������:
5 10 9
0 5
9 1
8 1
0 1
9 100

�������:
43


 * 
 */
public class ���׽�ѧ�� {
	private static int cou = Integer.MAX_VALUE, n, r, all, a[], b[];
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		while (in.hasNext()) {
			n = in.nextInt();
			r = in.nextInt();
			all = in.nextInt() * n;
			a = new int[n];
			b = new int[n];
			for (int i = 0 ;i < n; i ++) {
				a[i] = in.nextInt();
				b[i] = in.nextInt();
				all -= a[i];
			}
			search(0);
			System.out.println(cou);
		}
		in.close();
	}
	
	
	static void search (int count) {
		if (all <= 0) {
			if (cou > count)
				cou = count;
			return;
		}
		int maxSelect, j;
		for (int i = 0; i < n; i ++) {
			maxSelect = all / b[i];
			if (maxSelect + a[i] > r)
				maxSelect = r - a[i];
			for (j = maxSelect ; j > 0; j --) {
				all -= j;
				search (count + j * b[i]);
				all += j;
			}
		}
	}
	
}























