package oj.nowCoder;

import java.util.Scanner;

/*
 *

小v今年有n门课，每门都有考试，为了拿到奖学金，小v必须让自己的平均成绩至少为avg。
每门课由平时成绩和考试成绩组成，满分为r。现在他知道每门课的平时成绩为ai ,
若想让这门课的考试成绩多拿一分的话，小v要花bi 的时间复习，不复习的话当然就是0分。
同时我们显然可以发现复习得再多也不会拿到超过满分的分数。为了拿到奖学金，小v至少要花多少时间复习。

输入描述:
第一行三个整数n,r,avg(n大于等于1小于等于1e5，r大于等于1小于等于1e9,avg大于等于1小于等于1e6)，
接下来n行，每行两个整数ai和bi，均小于等于1e6大于等于1


输出描述:
一行输出答案。

输入例子:
5 10 9
0 5
9 1
8 1
0 1
9 100

输出例子:
43


 * 
 */
public class 网易奖学金 {
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























