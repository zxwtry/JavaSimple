package oj.nowCoder;

import java.util.Scanner;

/*
 * ����һ��int�����ݣ��������int���������ڴ��д洢ʱ1�ĸ�����

��������:
 ����һ��������int���ͣ�


�������:
 �����ת����2���ƺ����1�ĸ���

��������:
5

�������:
2
 */
public class ��Ϊ��int���������ڴ��д洢ʱ1�ĸ��� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int data = sc.nextInt();
			System.out.println(getNumOfOne(data));
			System.out.println(getNumOfOne2(data));
		}
		sc.close();
	}
	private static int getNumOfOne(int data) {
		int count = 0;
		while (data != 0) {
			count ++;
			data = data & (data-1);
		}
		return count;
	}
	private static int getNumOfOne2 (int data) {
		int count = 0;
		while (data != 0) {
			if ( (data & 0x1) == 1 )
				count ++;
			data = data >>> 1;
		}
		return count;
	}
}
