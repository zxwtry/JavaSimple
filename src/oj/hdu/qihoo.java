package oj.hdu;

import java.util.Scanner;

public class qihoo {
	public static void main(String[] args) {
//		System.out.println(Integer.MAX_VALUE);
		Scanner in = new Scanner(System.in);
		int n, a, b;
		while(in.hasNext()) {
			n = in.nextInt();
			b = in.nextInt();
			if (b > n / 2) {
//				a = n - b + 1;
//				if ( (b - a)%2 == 0) {
//					a ++;
//				}
				a = b - 1;
			} else {
//				a = n - b;
//				if ((a - b)% 2 == 0) {
//					a --;
//				}
				a = b + 1;
			}
			System.out.println(a);
		}
		in.close();
	}
}
