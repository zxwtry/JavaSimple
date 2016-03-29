package oj.nowCoder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/*

实现删除字符串中出现次数最少的字符，
若多个字符出现次数一样，则都删除。
输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序

 */
public class 华为删除字符串中出现次数最少的字符 {
	static int[] map = new int[26];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char[] c = null;
		while(in.hasNext()) {
			Arrays.fill(map, 0);
			c = in.nextLine().trim().toCharArray();
			for(int index = 0; index < c.length; index ++){
				map[c[index]-'a'] ++;
			}
			int min = Integer.MAX_VALUE;
			for(int mapIndex = 0; mapIndex < 26; mapIndex ++) {
				if (min > map[mapIndex] && map[mapIndex] != 0) {
					min = map[mapIndex];
				}
			}
			for (int index = 0; index < c.length; index ++) {
				int mapCount = map[c[index] - 'a'];
				if (mapCount != 0 && mapCount != min) {
					System.out.printf("%c", c[index]);
				}
			}
			System.out.println();
		}
		in.close();
	}
}
