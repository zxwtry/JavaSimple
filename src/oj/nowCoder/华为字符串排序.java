/*


��дһ�����򣬽������ַ����е��ַ������¹�������
����1��Ӣ����ĸ��A��Z���У������ִ�Сд��
      �磬���룺Type �����epTy
����2��ͬһ��Ӣ����ĸ�Ĵ�Сдͬʱ����ʱ����������˳�����С�
    �磬���룺BabA �����aABb
����3����Ӣ����ĸ�������ַ�����ԭ����λ�á�
    �磬���룺By?e �����Be?y
������
    ���룺
   A Famous Saying: Much Ado About Nothing(2012/8).
    �����
   A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).


��������:



�������:


��������:
A Famous Saying: Much Ado About Nothing (2012/8).

�������:
A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).



 */


package oj.nowCoder;

import java.util.Scanner;

public class ��Ϊ�ַ������� {
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
