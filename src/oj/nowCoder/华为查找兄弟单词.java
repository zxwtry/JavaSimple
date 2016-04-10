package oj.nowCoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 华为查找兄弟单词 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int num = scan.nextInt();
			String[] str = new String[num];
			ArrayList<MyObj> myAl = new ArrayList<MyObj>();
			if (myAl != null) {
				System.out.println();
			}
			for (int i = 0; i < num; i ++) {
				str[i] = scan.next();
				int[] map = new int[26];
				Arrays.fill(map, 0);
				char[] c = str[i].toCharArray();
				for (int j = 0; j < c.length; j ++) {
//					map[c[j]]
				}
			}
			String key = scan.next();
			int index = scan.nextInt();
			if (key.equals("") && index == 0) {
				System.out.println();
			}
		}
		scan.close();
	}
	static class MyObj {
		String val;
		ArrayList<Integer> al = new ArrayList<Integer>();
	}
}