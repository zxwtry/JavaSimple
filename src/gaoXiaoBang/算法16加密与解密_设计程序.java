package gaoXiaoBang;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*

����
��Ƴ���
һ��Playfair������ּ��ܷ������£�
����ѡ��һ����Կ���ʣ���Ϊpair������ĸ���ظ����Ҷ�ΪСд��ĸ��
��Ȼ������ĸ����������ĸһ��������һ��5x5�ķ����У����뷽�����£�
1.���Ȱ���������Կ����
2.������󣬰���ĸ�������벻����Կ���е���ĸ��
3.���ڷ�����ֻ��25��λ�ã����ʣ�µ��Ǹ���ĸ����任��
�����ԿΪyouandme����÷������£�
y o u a n
d m e b c
f g h i j
k l p q r
s t v w x
�ڼ���һ����ĸʱ����am���ڷ������ҵ�����������ĸΪ����ľ��Σ���ɫ���壩��
y o u a n
d m e b c
f g h i j
k l p q r
s t v w x
�����ĸ�ļ�����ĸΪ�þ��ε���һ�Զ��㣬�籾����Ϊob��
����Ƴ���ʹ���������������봮���м��ܣ���������ܺ�Ĵ���
���������¹涨��
1��һ��һ��ȡ��ĸ��������ֻʣ��һ����ĸ���򲻱任��ֱ�ӷ�����ܴ��У�
2�����һ����ĸ�е�������ĸ��ͬ���򲻱任��ֱ�ӷ�����ܴ��У�
3�����һ����ĸ����һ����ĸ�����������У��򲻱任��ֱ�ӷ�����ܴ��У�
4�������ĸ�Գ����ڷ����е�ͬһ�л�ͬһ�У���df��hi��
��ֻ��򵥶Ե���������ĸ�����任Ϊfd��ih��
5����������������ܹ��ҵ�����ĸ��Ϊ����ľ��Σ�������ĸ��Ϊam��
��þ��ε���һ�Զ�����ĸ�У���aͬ�е���ĸӦ��ǰ�棬��������Ӧ��ob��
ͬ�������任����ĸ��Ϊta����任�����ĸ��ӦΪwo��
6�������������봮��ΪСд��ĸ����������㡢�ո�������ַ���
���ܷ����������ͬ�����Լ��ܺ���ַ����ټ��ܣ����õ�ԭʼ����
Ҫ��������ʽ���£�
�ӿ���̨���������ַ�������һ��Ϊ��Կ���ʣ�����С�ڵ���25����
�ڶ���Ϊ�������ַ���������С�ڵ���50����
�����ַ���ĩβ����һ���س����з������������ַ�����ΪСд��ĸ��
���������ַ���

�ڱ�׼�����������ܺ���ַ�����
���磬�����룺
youandme
welcometohangzhou
���ʾ�������Կ����Ϊyouandme��
�γɵ�������������ʾ���������ַ���Ϊwelcometohangzhou��
���������п����ҵ��Ե�һ����ĸweΪ����ľ��Σ�
��Ӧ��һ�Զ�����ĸΪvb����˼��ܺ�Ϊvb��
ͬ����ҵ�����ĸ��lc,et,oh,ho��Ӧ�Ķ�����ĸ�ԡ�
����ĸ��omλ�������������е�ͬһ�У�
����ֱ���Եߵ���������ĸ�����ܣ���Ϊmo����ĸ��anͬ��
��ĸ��gz�е�z���������������У����ԭ���ŵ����ܴ��С�
���ʣһ����ĸuҲԭ�������

�������Ľ��Ϊ��
vbrmmomvugnagzguu
 */


public class �㷨16���������_��Ƴ��� {
	private static char cUnUsed;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String pair = br.readLine().trim();
		String secrectString = br.readLine().trim();
		char[] pairChar = pair.toCharArray();
		char[] strChar  = secrectString.toCharArray();
		char[][] matrix = new char[5][5];
		boolean[] isExists = new boolean[26];
		Arrays.fill(isExists, false);
		for (int i = pairChar.length-1; i >=0; -- i) {
			isExists[pairChar[i]-'a'] = true;
		}
		for (int i = 0; i < pairChar.length/5; ++ i) {
			System.arraycopy(pairChar, i*5, matrix[i], 0, 5);
		}
		System.arraycopy(pairChar, (pairChar.length/5)*5, matrix[pairChar.length/5], 0, pairChar.length-(pairChar.length/5)*5);
		int index = pairChar.length;
		for (int i = 0;i < 26; ++ i) {
			if (!isExists[i] && index<25) {
				matrix[index/5][index%5] = (char)('a'+i);
				isExists[i] = true;
				index ++;
			}
		}
		for (int i = 0; i < 26; ++ i) {
			if (!isExists[i]) {
				cUnUsed = (char)('a'+i);
			}
		}
//		System.out.println(cUnUsed);
		for (int i = 0; i < strChar.length-1; i+=2) {
			getTheEncrypt(strChar,i,matrix);
		}
		for (int i = 0; i < 5; i ++) {
			for (int j = 0; j < 5; j ++) {
//				System.out.printf("%c ",matrix[i][j]);
			}
//			System.out.println();
		}
		br.close();
		System.out.println(String.valueOf(strChar));
	}
	private static void getTheEncrypt(char[] strChar, int i, char[][] matrix) {
		char c3 = strChar[i], c4 = strChar[i+1];
		if (c3 == c4) {
			return;
		}
		if (c3 == cUnUsed || c4 == cUnUsed) {
			return;
		}
		Point p1 = getPoint(c3,matrix);
		Point p2 = getPoint(c4,matrix);
		if (p1.x == p2.x || p1.y == p2.y) {
			strChar[i] = c4;
			strChar[i+1] = c3;
			return;
		}
		strChar[i] = matrix[p1.x][p2.y];
		strChar[i+1] = matrix[p2.x][p1.y];
	}
	private static Point getPoint (char c, char[][] matrix) {
		Point re = new Point();
		for (int i = 0; i < 5; i ++) {
			for (int j = 0; j < 5; ++ j) {
				if (matrix[i][j] == c) {
					re.x = i;
					re.y = j;
				}
			}
		}
		return re;
	}
	static class Point {
		int x,y;
	}
}
