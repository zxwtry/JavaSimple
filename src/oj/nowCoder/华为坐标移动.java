package oj.nowCoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。
 * 从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
 
输入：
 
合法坐标为A(或者D或者W或者S) + 数字（两位以内）
 
坐标之间以;分隔。
 
非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
 
下面是一个简单的例子 如：
 
A10;S20;W10;D30;X;A1A;B10A11;;A10;
 
处理过程：
 
起点（0,0）
 
+   A10   =  （-10,0）
 
+   S20   =  (-10,-20)
 
+   W10  =  (-10,-10)
 
+   D30  =  (20,-10)
 
+   x    =  无效
 
+   A1A   =  无效
 
+   B10A11   =  无效
 
+  一个空 不影响
 
+   A10  =  (10,-10)
 
 
 
结果 （10， -10）


输入描述:
一行字符串


输出描述:
最终坐标，以,分隔

输入例子:
A10;S20;W10;D30;X;A1A;B10A11;;A10;

输出例子:
10,-10
 */
public class 华为坐标移动 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s ;
		while ((s = br.readLine()) != null) {
			LOC location = new LOC();
			String[] split = s.split(";");
			for (String tmp : split) {
				if (tmp != null && tmp.length() > 1) {
					getThisMove (location, tmp);
				}
			}
			System.out.printf("%d,%d\n",location.loc1, location.loc2);		
		}
		br.close();
	}
	private static void getThisMove (LOC position, String tmp) {
		char[] tmpChar = tmp.toCharArray();
		for (int i = 1; i < tmpChar.length; i ++) {
			if (!(tmpChar[i] >= '0' && tmpChar[i] <= '9') )
				return;
		}
		int length = Integer.parseInt(tmp.substring(1));
		switch (tmpChar[0]) {
		case 'A':
		case 'a':
			position.loc1 -= length;
			break;
		case 'S':
		case 's':
			position.loc2 -= length;
			break;
		case 'D':
		case 'd':
			position.loc1 += length;
			break;
		case 'W':
		case 'w':
			position.loc2 += length;
			break;
		default:
			break;
		}
		
	}
	static class LOC {
		int loc1, loc2;
		public LOC () {
			this(0, 0);
		}
		public LOC (int loc1, int loc2) {
			this.loc1 = loc1;
			this.loc2 = loc2;
		}
	}
}
