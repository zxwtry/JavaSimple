/*
从键盘读入一个由字母构成的串（不大于30个字符）。

从该串中取出3个不重复的字符，求所有的取法。

取出的字符，要求按字母升序排列成一个串。

不同的取法输出顺序可以不考虑。

例如：
输入：
abc
则输出：
abc

输入：
abcd
则输出：
abc
abd
acd
bcd

输入：
abcaa
则输出：
abc

 */

package gaoXiaoBang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 第四章按要求操作 {
	public static void main(String[] args) throws IOException {
		byte[] map = new byte[26];
		Arrays.fill(map, (byte)0);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char c[] = br.readLine().toCharArray();
		for (int i = 0; i < c.length; ++ i) {
			map[c[i]-'a'] ++;
		}
		for (int i = 0; i < 26; ++ i) {
			if (map[i] == 0) continue;
			for (int j = i+1; j < 26; ++ j) {
				if (map[j] == 0)   continue;
				for (int k = j+1; k < 26; ++ k) {
					if (map[k] == 0) continue;
					System.out.printf("%c%c%c\n",(char)('a'+i),(char)('a'+j),(char)('a'+k));
				}
			}
		}
		br.close();
	}
}
