package gaoXiaoBang;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*


����
��Ƴ���
������Windows�����£�����̨������Ҳ�������������ƴ��Ư���ı������
���磺
�����Щ���
��   ��  ��
�����੤��
��   ��  ��
�����ة���
��ʵ�����������µķ���ƴ�ӵģ�
���� = ��
�� = ��
���� = ��
�� = ��
���� = ��
�� = ��
����= ��
�� = ��
���� = ��
��ֱ = ��
ˮƽ = ��
����ĿҪ���дһ�����򣬸����û�������С�����������Ӧ�ı������
�����û����룺
3 2
����������
�����Щ���
��   ��  ��
�����੤��
��   ��  ��
�����੤��
��   ��  ��
�����ة���
�û����룺
2 3
����������
�����Щ��Щ���
��   ��  ��  ��
�����੤�੤��
��   ��  ��  ��
�����ة��ة���

 */


public class �㷨21�Զ����·��_��� {
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
						forOut[i][j] = '��';
					} else {
						forOut[i][j] = '��';
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
		forOut[0][0] = '��';   forOut[0][2*b] = '��';
		forOut[2*a][0] = '��';   forOut[2*a][2*b] = '��';
		for (int i = 2; i < 2*b; ++ i) {
			if ((i&0x1) == 0) {
				forOut[0][i] = '��';
				forOut[2*a][i] = '��';
			}
		}
		for (int i = 2; i < 2*a; ++ i) {
			if ((i&0x1) == 0) {
				forOut[i][0] = '��';
				forOut[i][2*b] = '��';
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
