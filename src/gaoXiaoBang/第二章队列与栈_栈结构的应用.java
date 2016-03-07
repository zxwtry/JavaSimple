/*
ջ�ṹ�����ô�����ʱͨ�����������ɻ���һЩ���⡣
���������⣺
...(.[...)...]...(..(.)..)..{..}.[.]...[[...(.).]..].
���ж�һ�����е������Ƿ�ƥ��
ע�����в�ƥ��������
������̫��
������̫��
���������������ų��� ..)...(...
������ ....[...(....]....)....
������ջ
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
 * ������ֻ���ؿ���С���ŵ����
 */
package gaoXiaoBang;

import java.util.Stack;

public class �ڶ��¶�����ջ_ջ�ṹ��Ӧ�� {
	public static void main(String[] args) {
		final String[]  out = {"������̫��","������̫��","���������������ų���","������","С����ƥ��"};
		final int X_Z = 1,  Z_Z = 4,  D_Z = 16;

		String s = "...(.[...)...]...(u..(.)..)..{..}.[.]...[[...(.).]..]."; //������
//		String s = "..(..(..)..(..).."; //������̫��
//		String s = "....(..)..(..)).."; //������̫��
//		String s = "..{...[...]..}..)...("; //���������������ų��� 
//		String s = "...(...)..[..]...(u..(.)..)..{..}.[.]...[[...(.).]..]."; //С����ƥ��
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
