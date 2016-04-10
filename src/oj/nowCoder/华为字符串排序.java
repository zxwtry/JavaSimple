/*


编写一个程序，将输入字符串中的字符按如下规则排序。
规则1：英文字母从A到Z排列，不区分大小写。
      如，输入：Type 输出：epTy
规则2：同一个英文字母的大小写同时存在时，按照输入顺序排列。
    如，输入：BabA 输出：aABb
规则3：非英文字母的其它字符保持原来的位置。
    如，输入：By?e 输出：Be?y
样例：
    输入：
   A Famous Saying: Much Ado About Nothing(2012/8).
    输出：
   A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).


输入描述:



输出描述:


输入例子:
A Famous Saying: Much Ado About Nothing (2012/8).

输出例子:
A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).



 */


package oj.nowCoder;

import java.util.Scanner;

public class 华为字符串排序 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String line = scan.nextLine();
			char[] c = line.toCharArray();
			final int len = c.length;
			for (int i = 0; i < len; i ++) {
				int ic;
				if (c[i] >= 'A' && c[i] <= 'Z') {
					ic = c[i] - 'A';
				} else if (c[i] >= 'a' && c[i] <= 'z') {
					ic = c[i] - 'a';
				} else {
					continue;
				}
				for (int j = 0; j < i; j ++) {
					int jc;
					if (c[j] >= 'A' && c[j] <= 'Z') {
						jc = c[j] - 'A';
					} else if (c[j] >= 'a' && c[j] <= 'z') {
						jc = c[j] - 'a';
					} else {
						continue;
					}
					if (ic < jc) {
						char exchange = c[i];
						c[i] = c[j];
						c[j] = exchange;
					}
				}
			}
			System.out.println(String.valueOf(c));
		}
		scan.close();
	}
	static boolean isNum (char c) {
		if ( (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') ) {
			return true;
		}
		return false;
	}
}
