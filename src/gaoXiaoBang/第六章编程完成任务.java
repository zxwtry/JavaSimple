/*
�ڶ������˻�����ҪȨ�����������ʱ�����ǳ������������ķ��գ�
���Ϊ�˺ü������հɣ����ױ��ƽ⣬����ȫ��������ò��üǵ����룬
�ֵ����Լ�Ҳ�����ǣ����д��ֽ�ϣ�����ֽ�ű����˷��ֻ�Ū����...

��������������ǰ�һ��ƴ����ĸת��Ϊ6λ���֣����룩��
���ǿ���ʹ���κκüǵ�ƴ����(�������֣���ϲ������д��wangximing)
��Ϊ���룬�������6λ���֡�

�任�Ĺ������£�

��һ��. ���ַ���6��һ���۵�����������wangximing���Ϊ��
wangxi
ming

�ڶ���. �����д�ֱ��ͬһ��λ�õ��ַ���ASCII��ֵ��ӣ�
�ó�6�����֣�����������ӣ���ó���
228 202 220 206 120 105

������. �ٰ�ÿ�����֡���λ���������ǰ�ÿ��λ��������ӣ�
�ó��������������һλ���֣�������λ��ֱ�����һλ����Ϊֹ��
����: 228 => 2+2+8=12 => 1+2=3

�����������λ���Ϊ��344836, ����ǳ������յ���������

Ҫ�����ӱ�׼����������ݣ��ڱ�׼�������������

�����ʽΪ����һ����һ������n��<100������ʾ�±��ж��������У�
��������n���ַ��������ǵȴ��任���ַ�����
�����ʽΪ��n�б任���6λ���롣

���磬���룺
5
zhangfeng
wangximing
jiujingfazi
woaibeijingtiananmen
haohaoxuexi

�������
772243
344836
297332
716652
875843
 */

package gaoXiaoBang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class �����±��������� {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine().trim());
		for(int i = 0; i < num; ++ i) {
			solve( br.readLine().trim() );
		}
		br.close();
	}

	private static void solve(String str) {
		char[] c = str.toCharArray();
		int[] map = new int[6];
		Arrays.fill(map, 0);
		for (int i = 0; i < c.length; ++ i) {
			map[i%6] += (int)c[i];
		}
		for (int i = 0; i < 6; ++ i) {
			divide(map[i]);
		}
		System.out.println();
	}

	private static void divide(int i) {
		if (i < 10 && i > 0) {
			System.out.print(i);
			return;
		}
		int temp = 0;
		while (i > 0) {
			temp += i%10;
			i = i/10;
		}
		divide(temp);
	}
}
