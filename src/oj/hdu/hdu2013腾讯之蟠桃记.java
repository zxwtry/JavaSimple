package oj.hdu;

import java.util.Scanner;

/*

ϲ�����μǵ�ͬѧ�϶���֪�����͵����ҵĹ��£�
����һ�������������̫�����ˣ���ʵ������������֪��
��������о�һ����ѧ���⣡
ʲô���⣿���о������������һ���ж��ٸ���
�����������������û�ܽ��������⣬�Ǻ�^-^
��ʱ������������ģ�
��һ����ճԵ���������һ���һ����
�ڶ����ֽ�ʣ�µ����ӳԵ�һ���һ����
�Ժ�ÿ��Ե�ǰһ��ʣ�µ�һ���һ����
����n��׼���Ե�ʱ��ֻʣ��һ�����ӡ�
�������㣬��������һ�£�����һ�쿪ʼ�Ե�ʱ������һ���ж��ٸ��أ�

 */
public class hdu2013��Ѷ֮��Ҽ� {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int days = -1;
		while(in.hasNext()) {
			days = in.nextInt();
			System.out.println(getAll(days));
		}
		in.close();
	}
	private static int getAll(int days) {
		int all = 1;
		for (int i = 1; i < days; i ++) {
			all = (all + 1) << 1;
		}
		return all;
	}
}
