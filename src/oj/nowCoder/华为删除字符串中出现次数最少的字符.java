package oj.nowCoder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/*

ʵ��ɾ���ַ����г��ִ������ٵ��ַ���
������ַ����ִ���һ������ɾ����
���ɾ����Щ���ʺ���ַ������ַ����������ַ�����ԭ����˳��

 */
public class ��Ϊɾ���ַ����г��ִ������ٵ��ַ� {
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
