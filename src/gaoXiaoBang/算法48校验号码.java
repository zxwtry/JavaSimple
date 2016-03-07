package gaoXiaoBang;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*


问题
校验号码
如果让你设计个程序，用什么变量保存身份证号码呢？长
整数可以吗？不可以！
因为有人的身份证最后一位是"X"
实际上，除了最后一位的X，不会出现其它字母！
身份证号码18位 = 17位 + 校验码
校验码的计算过程：
例如：身份证前17位 = ABCDEFGHIJKLMNOPQ
A~Q 每位数字乘以权值求和（每位数字和它对应的“权”相乘后累加）
17位对应的权值分别是：
7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2
求出的总和再对11求模
然后按下表映射：
余数 0 1 2 3 4 5 6 7 8 9 10
校验码： 1 0 X 9 8 7 6 5 4 3 2
请编写程序校验一个给定的身份证号码是否合格。

 */


public class 算法48校验号码 {
	private static int[] val = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
	private static char[] ch = {1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(isOk(br.readLine().trim().toCharArray()));
		br.close();
	}
	private static boolean isOk(char[] c) {
		int value = 0;
		for (int i = 0; i < 17; ++ i) {
			value += (c[i]-'0')*val[i];
		}
		if (c[17] == ch[value%11]) {
			return true;
		}
		return false;
	}
}
