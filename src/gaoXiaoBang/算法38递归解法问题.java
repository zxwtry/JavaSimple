package gaoXiaoBang;

import java.util.Scanner;

/*

递归解法问题
从键盘输入一个整数（1~20）
则以该数字为矩阵的大小，把1,2,3…n*n 的数字按照顺时针螺旋的形式填入其中。例如：
输入数字2，则程序输出：
1 2
4 3
输入数字3，则程序输出：
1 2 3
8 9 4
7 6 5
输入数字4， 则程序输出：
1  2  3  4
12 13 14 5
11 16 15 6
10  9  8 7
请使用递归解法解决该问题

 */

public class 算法38递归解法问题 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		scan.close();
		int[][]show = getCircle(num);
		for (int i = 0; i < show.length; ++ i) {
			for (int j = 0; j < show[i].length; ++ j) {
				System.out.println(show[i][j]+" ");
			}
			System.out.println();
		}
	}
	private static int[][] getCircle(int num) {
		int[][] re = new int[num][num];
		travel(re, 0, 0, 1, re.length-1, re.length-1);
		return re;
	}
	private static void travel (int[][] re, int i, int j,
			int count, int icount, int jcount) {
		if ( (re.length & 0x1) == 1 ) {
			if (i == j && i == re.length>>1) {
				return;
			}
		} else {
			if (i == re.length/2 && j == (re.length/2-1)) {
				return;
			}
		}
		re[i][j] = count;
		travel(re, i, j, ++ count, icount, jcount);
	}
}
