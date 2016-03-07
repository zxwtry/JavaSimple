/*
栈结构很有用处，有时通过它可以轻松化解一些难题。
看如下问题：
...(.[...)...]...(..(.)..)..{..}.[.]...[[...(.).]..].
请判断一个串中的括号是否匹配
注意下列不匹配的情况：
左括号太多
右括号太多
右括号先于左括号出现 ..)...(...
挎臂情况 ....[...(....]....)....
考虑用栈
 */

/*
 * 'C' ---- X_Z = 1
 * ')' ---- X_Y = 2
 * '[' ---- Z_Z = 4
 * ']' ---- Z_Y = 8
 * '{' ---- D_Z = 16
 * '}' ---- D_Y = 32
 */

/*
 * 在这里只着重考虑小括号的情况
 */
package gaoXiaoBang;

import java.util.Stack;

public class 第二章队列与栈_栈结构的应用 {
	public static void main(String[] args) {
		final String[]  out = {"左括号太多","右括号太多","右括号先于左括号出现","挎臂情况","小括号匹配"};
		final int X_Z = 1,  Z_Z = 4,  D_Z = 16;

		String s = "...(.[...)...]...(u..(.)..)..{..}.[.]...[[...(.).]..]."; //挎臂情况
//		String s = "..(..(..)..(..).."; //左括号太多
//		String s = "....(..)..(..)).."; //右括号太多
//		String s = "..{...[...]..}..)...("; //右括号先于左括号出现 
//		String s = "...(...)..[..]...(u..(.)..)..{..}.[.]...[[...(.).]..]."; //小括号匹配
		Stack<Integer> stk = new Stack<>();
		int[] Z_count = {0,0,0};
		boolean[] isAppeared = {false,false,false};
		boolean isPiPei = true;
		for (int i = 0; i < s.length(); i ++) {
			switch(s.charAt(i)) {
			case '(':
				isAppeared[0] = true;
				stk.push(X_Z);
				Z_count[0] ++;
				break;
			case ')':
				Z_count[0] --;
				if (!stk.isEmpty()){
					if (stk.peek() == X_Z) {
						stk.pop();
					} else {
						if (Z_count[1]+Z_count[2] > 0) {
							System.out.println(out[3]);
							isPiPei = false;
						} else {
							if (!isAppeared[0]) {
								System.out.println(out[2]);
								isPiPei = false;
							}
						}
					}
				} else {
					if (!isAppeared[0]) {
						System.out.println(out[2]);
						isPiPei = false;
					}
				}
				break;
			case '[':
				isAppeared[1] = true;
				Z_count[1] ++;
				stk.push(Z_Z);
				break;
			case ']':
				Z_count[1] --;
				if (!stk.isEmpty() && stk.peek() == Z_Z) {
					stk.pop();
				}
				break;
			case '{':
				isAppeared[2] = true;
				Z_count[2] ++;
				stk.push(D_Z);
				break;
			case '}':
				Z_count[2] --;
				if (!stk.isEmpty() && stk.peek() == D_Z) {
					stk.pop();
				}
				break;
				default:
					break;
			}
		}
		if (Z_count[0] != 0) {
			isPiPei = false;
			System.out.println(out[(Z_count[0] > 0 ? 0 : 1)]);
		} else	if (isPiPei) {
			System.out.println(out[4]);
		}
		
	}
}
