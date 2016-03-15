package oj.nowCoder;

import java.util.Scanner;

/*
 * 输入一个int型数据，计算出该int型数据在内存中存储时1的个数。

输入描述:
 输入一个整数（int类型）


输出描述:
 这个数转换成2进制后，输出1的个数

输入例子:
5

输出例子:
2
 */
public class 华为求int型数据在内存中存储时1的个数 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int data = sc.nextInt();
			System.out.println(getNumOfOne(data));
			System.out.println(getNumOfOne2(data));
		}
		sc.close();
	}
	private static int getNumOfOne(int data) {
		int count = 0;
		while (data != 0) {
			count ++;
			data = data & (data-1);
		}
		return count;
	}
	private static int getNumOfOne2 (int data) {
		int count = 0;
		while (data != 0) {
			if ( (data & 0x1) == 1 )
				count ++;
			data = data >>> 1;
		}
		return count;
	}
}
