/*
����һ���ݺ������Ϸ����ͼ����3x4�ĸ����У���Ϸ��˫���������û�����������ǣ�

1. ���ܷ������Ѿ����û����ĵط�����ֻ���ڿո��з��ã���

2. �����ķ���ֻ������ֱ��ˮƽ���á�

3. �������������������еĻ����ͨ������ν��ͨ��ָ����������������һ��ֱ�ߣ����м�û��������ͬ����Ļ����������

���磺ͼ��ʾ�ľ����£�������C2λ����ֱ���ã�Ϊ�˷�����������λ�ã�ͼ�����¶�����˱�ǣ���������ˮƽ���ã���Ϊ����A2��ͨ��ͬ������B2��B3��D2��ʱ���ַ��򶼲����Է��á������C2��ֱ���ú�D2�Ϳ���ˮƽ�����ˣ���Ϊ���ٻ���A2��ͨ���ܵ���C2���赲����

4. ��Ϸ˫���������û�񣬲�������Ȩ��Ҳ�����ԷŶ����ֱ��ĳһ���޷��������ã���÷�Ϊ�������һ������

��Ϸ��ʼʱ�����Ѿ������˶�����

��������ǣ���д���򣬶����ʼ״̬����������Լ��������ķ��÷����������

��ͼ�ľ����ʾΪ��

00-1

-000

0100

���á�0����ʾ����λ�ã��á�1����ʾ��ֱ���ã��á�-����ʾˮƽ���á�

�����롢�����ʽҪ��

�û����������� n��n<100���� ��ʾ������������ n �ֳ�ʼ���棬ÿ�־���ռ3��(��������û�пհ���)��

�����������ÿ�ֳ�ʼ��������¼���ó�����ѷ��÷����к�+�к�+���÷�ʽ����

���磺�û����룺

2
0111
-000
-000
1111
----
0010

�������������

00-

211

���Ѳ³����������ĺ���Ϊ��

�Ե�һ�����棬�ڵ�0�е�0��ˮƽ����

�Եڶ������棬�ڵ�2�е�1�д�ֱ����

ע�⣺

�кš��кŶ��Ǵ�0��ʼ�����ġ�

��ÿ�־�������ж����ѷ��÷������ⲻΨһ����ֻ���һ�ּ��ɡ�

���磬�Ե�һ�����棬001 Ҳ�����⣻�Եڶ������棬201Ҳ�����⡣

1
1011
-000
-000

 */
package gaoXiaoBang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class �����²�����_������Ϸ��ʵ�� {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i< num; ++ i) {
			solve(changeToInt(br.readLine().trim()), 
					changeToInt(br.readLine().trim()), 
					changeToInt(br.readLine().trim()));
		}
		br.close();
	}
	
	private static void solve(int[] c1, int[] c2, int[] c3) {
		for (int i = 0; i < c1.length; ++ i) {
			if (c1[i] != 0)
				continue;
			int index1 = i, index2 = i;
			int state1 = 0, state2 = 0;
			if (i != 0) {
				while (index1>=0 && c1[index1] == 0) {
					index1 --;
				}
				state1 = c1[index1];
			}
			if (i != c1.length-1) {
				while (index2<c1.length && c1[index2] == 0) {
					index2 ++;
				}
				state2 = index2==c1.length ? 0 :c1[index2];
			}
			int state3 = 0, state4 = c2[i] != 0 ? c2[i] : (c3[i] != 0 ? c3[i] : 0);
			if (state3 == 1 || state4 == 1) {
				if (state1 == -1 || state2 == -1) {
					continue;
				} else {
					System.out.println(0+""+i+"-");
					return;
				}
			} else {
				System.out.println(0+""+i+"1");
				return;
			}
		}
		for (int i = 0; i < c2.length; ++ i) {
			if (c2[i] != 0)
				continue;
			int index1 = i, index2 = i;
			int state1 = 0, state2 = 0;
			if (i != 0) {
				while (index1>=0 && c2[index1] == 0) {
					index1 --;
				}
				state1 = c2[index1];
			}
			if (i != c2.length-1) {
				while (index2<c2.length && c2[index2] == 0) {
					index2 ++;
				}
				state2 = index2==c2.length ? 0 :c2[index2];
			}
			int state3 = c1[i], state4 = c3[i];
			if (state3 == 1 || state4 == 1) {
				if (state1 == -1 || state2 == -1) {
					continue;
				} else {
					System.out.println(1+""+i+"-");
					return;
				}
			} else {
				System.out.println(1+""+i+"1");
				return;
			}
		}
		for (int i = 0; i < c3.length; ++ i) {
			if (c3[i] != 0)
				continue;
			int index1 = i, index2 = i;
			int state1 = 0, state2 = 0;
			if (i != 0) {
				while (index1>=0 && c3[index1] == 0) {
					index1 --;
				}
				state1 = c3[index1];
			}
			if (i != c3.length-1) {
				while (index2<c3.length && c3[index2] == 0) {
					index2 ++;
				}
				state2 = index2==c3.length ? 0 :c3[index2];
			}
			int state4 = 0, state3 = c2[i] != 0 ? c2[i] : (c1[i] != 0 ? c1[i] : 0);
			if (state3 == 1 || state4 == 1) {
				if (state1 == -1 || state2 == -1) {
					continue;
				} else {
					System.out.println(2+""+i+"-");
					return;
				}
			} else {
				System.out.println(2+""+i+"1");
				return;
			}
		}
	}	
	private static int[] changeToInt(String str) {
		int[] re = new int[str.length()];
		char[] c = str.toCharArray();
		for (int i = 0; i < c.length; ++ i) {
			switch(c[i]) {
			case '0':
				re[i] = 0;
				break;
			case '1':
				re[i] = 1;
				break;
			case '-':
				re[i] = -1;
				break;
			}
		}
		return re;
	}
}
