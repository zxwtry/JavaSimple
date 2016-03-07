package gaoXiaoBang;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*


问题
设计程序
在中文Windows环境下，控制台窗口中也可以用特殊符号拼出漂亮的表格来。
比如：
┌─┬─┐
│   │  │
├─┼─┤
│   │  │
└─┴─┘
其实，它是由如下的符号拼接的：
左上 = ┌
上 = ┬
右上 = ┐
左 = ├
中心 = ┼
右 = ┤
左下= └
下 = ┴
右下 = ┘
垂直 = │
水平 = ─
本题目要求编写一个程序，根据用户输入的行、列数画出相应的表格来。
例如用户输入：
3 2
则程序输出：
┌─┬─┐
│   │  │
├─┼─┤
│   │  │
├─┼─┤
│   │  │
└─┴─┘
用户输入：
2 3
则程序输出：
┌─┬─┬─┐
│   │  │  │
├─┼─┼─┤
│   │  │  │
└─┴─┴─┘

 */


public class 算法21自顶向下风格_编程 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().trim().split(" ");
		int a = Integer.parseInt(split[0]);
		int b = Integer.parseInt(split[1]);
		char[][] forOut = new char[2*a+1][];
		for (int i = 0; i < 2*a+1; ++ i) {
			if ((i&0x1) == 1) {
				forOut[i] = new char[3*b+1];
			} else {
				forOut[i] = new char[2*b+1];
			}
		}
		for (int i = 0; i < 2*a+1; i ++) {
			for (int j = 0; j < forOut[i].length; j ++ ) {
				if ((i & 0x1) == 0) {
					if ((j & 0x1) == 0) {
						forOut[i][j] = '┼';
					} else {
						forOut[i][j] = '─';
					}
				} else {
					if ((j % 3) == 0) {
						forOut[i][j] = '|';
					} else {
						forOut[i][j] = ' ';
					}
				}
			}
		}
		forOut[0][0] = '┌';   forOut[0][2*b] = '┐';
		forOut[2*a][0] = '└';   forOut[2*a][2*b] = '┘';
		for (int i = 2; i < 2*b; ++ i) {
			if ((i&0x1) == 0) {
				forOut[0][i] = '┬';
				forOut[2*a][i] = '┴';
			}
		}
		for (int i = 2; i < 2*a; ++ i) {
			if ((i&0x1) == 0) {
				forOut[i][0] = '├';
				forOut[i][2*b] = '┤';
			}
		}
		for (int i = 0; i < 2*a+1; ++ i) {
			for (int j = 0; j < forOut[i].length; ++ j) {
				System.out.printf("%c",forOut[i][j]);
			}
			System.out.println();
		}
	}
}
