package oj.nowCoder;

import java.util.Scanner;

public class 华为简单密码破解 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char[] c = null;
		while(in.hasNext()){
			c = in.nextLine().trim().toCharArray();
			for(int index = 0; index < c.length; index ++) {
				if (c[index] >= 'A' && c[index] <= 'Z') {
					c[index] =(char) ('a' + (c[index] - 'A' + 1) % 26);
				} else if (c[index] >= 'a' && c[index] <= 'z') {
					switch(c[index]) {
					case 'a':
					case 'b':
					case 'c':
						c[index] = '2';
						break;
					case 'd':
					case 'e':
					case 'f':
						c[index] = '3';
						break;
					case 'g':
					case 'h':
					case 'i':
						c[index] = '4';
						break;
					case 'j':
					case 'k':
					case 'l':
						c[index] = '5';
						break;
					case 'm':
					case 'n':
					case 'o':
						c[index] = '6';
						break;
					case 'p':
					case 'q':
					case 'r':
					case 's':
						c[index] = '7';
						break;
					case 't':
					case 'u':
					case 'v':
						c[index] = '8';
						break;
					case 'w':
					case 'x':
					case 'y':
					case 'z':
						c[index] = '9';
						break;
					}
				}
			}
			System.out.println(String.valueOf(c));
			
		}
		in.close();
	}
	
}
