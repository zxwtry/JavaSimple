package oj.nowCoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * ����һ��������㹤�ߣ� A��ʾ�����ƶ���D��ʾ�����ƶ���W��ʾ�����ƶ���S��ʾ�����ƶ���
 * �ӣ�0,0���㿪ʼ�ƶ����������ַ��������ȡһЩ���꣬�����������������������ļ����档
 
���룺
 
�Ϸ�����ΪA(����D����W����S) + ���֣���λ���ڣ�
 
����֮����;�ָ���
 
�Ƿ��������Ҫ���ж�������AA10;  A1A;  $%$;  YAD; �ȡ�
 
������һ���򵥵����� �磺
 
A10;S20;W10;D30;X;A1A;B10A11;;A10;
 
������̣�
 
��㣨0,0��
 
+   A10   =  ��-10,0��
 
+   S20   =  (-10,-20)
 
+   W10  =  (-10,-10)
 
+   D30  =  (20,-10)
 
+   x    =  ��Ч
 
+   A1A   =  ��Ч
 
+   B10A11   =  ��Ч
 
+  һ���� ��Ӱ��
 
+   A10  =  (10,-10)
 
 
 
��� ��10�� -10��


��������:
һ���ַ���


�������:
�������꣬��,�ָ�

��������:
A10;S20;W10;D30;X;A1A;B10A11;;A10;

�������:
10,-10
 */
public class ��Ϊ�����ƶ� {
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
