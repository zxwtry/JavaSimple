/*
�Ӽ��̶���һ������ĸ���ɵĴ���������30���ַ�����

�Ӹô���ȡ��3�����ظ����ַ��������е�ȡ����

ȡ�����ַ���Ҫ����ĸ�������г�һ������

��ͬ��ȡ�����˳����Բ����ǡ�

���磺
���룺
abc
�������
abc

���룺
abcd
�������
abc
abd
acd
bcd

���룺
abcaa
�������
abc

 */

package gaoXiaoBang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class �����°�Ҫ����� {
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
