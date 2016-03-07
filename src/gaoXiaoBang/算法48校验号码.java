package gaoXiaoBang;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*


����
У�����
���������Ƹ�������ʲô�����������֤�����أ���
���������𣿲����ԣ�
��Ϊ���˵����֤���һλ��"X"
ʵ���ϣ��������һλ��X���������������ĸ��
���֤����18λ = 17λ + У����
У����ļ�����̣�
���磺���֤ǰ17λ = ABCDEFGHIJKLMNOPQ
A~Q ÿλ���ֳ���Ȩֵ��ͣ�ÿλ���ֺ�����Ӧ�ġ�Ȩ����˺��ۼӣ�
17λ��Ӧ��Ȩֵ�ֱ��ǣ�
7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2
������ܺ��ٶ�11��ģ
Ȼ���±�ӳ�䣺
���� 0 1 2 3 4 5 6 7 8 9 10
У���룺 1 0 X 9 8 7 6 5 4 3 2
���д����У��һ�����������֤�����Ƿ�ϸ�

 */


public class �㷨48У����� {
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
