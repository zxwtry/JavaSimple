package oj.nowCoder;

import java.util.Arrays;
import java.util.Scanner;

/*
一条长l的笔直的街道上有n个路灯，若这条街的起点为0，终点为l，
第i个路灯坐标为ai，每盏灯可以覆盖到的最远距离为d，
为了照明需求，所有灯的灯光必须覆盖整条街，但是为了省电，
要是这个d最小，请找到这个最小的d。

输入描述:
每组数据第一行两个整数n和l
（n大于0小于等于1000，l小于等于1000000000大于0）。
第二行有n个整数(均大于等于0小于等于l)，为每盏灯的坐标，多个路灯可以在同一点。


输出描述:
输出答案，保留两位小数。

输入例子:
7 15
15 5 3 7 9 14 0

输出例子:
2.5
 */
public class 网易路灯 {
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