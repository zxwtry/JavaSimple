/*



��Ŀ����

��ǿ����ܿ��ģ���˾����NԪ�����ս���
��ǿ���������ս����ڹ�������������Ʒ��Ϊ���ࣺ
�����븽���������Ǵ�����ĳ�������ģ��±����һЩ�����븽�������ӣ�

����	����
����	��ӡ����ɨ����
���	ͼ��
����	̨�ƣ��ľ�
������	��
���Ҫ�����Ϊ��������Ʒ����������ø���������������
ÿ������������ 0 ���� 1 ���� 2 ��������
���������д������Լ��ĸ�����
��ǿ����Ķ����ܶ࣬Ϊ�˲�����Ԥ�㣬
����ÿ����Ʒ�涨��һ����Ҫ�ȣ���Ϊ 5 �ȣ�
������ 1 ~ 5 ��ʾ���� 5 ������Ҫ��
�������������ϲ鵽��ÿ����Ʒ�ļ۸񣨶��� 10 Ԫ������������
��ϣ���ڲ����� N Ԫ�����Ե��� N Ԫ����ǰ���£�
ʹÿ����Ʒ�ļ۸�����Ҫ�ȵĳ˻����ܺ����

    ��� j ����Ʒ�ļ۸�Ϊ v[j] ����Ҫ��Ϊ w[j] ��
    ��ѡ���� k ����Ʒ���������Ϊ j 1 �� j 2 �������� j k ����������ܺ�Ϊ��
v[j 1 ]*w[j 1 ]+v[j 2 ]*w[j 2 ]+ �� +v[j k ]*w[j k ] �������� * Ϊ�˺ţ�
    ���������ǿ���һ������Ҫ��Ĺ��ﵥ��
 


��������:
����ĵ� 1 �У�Ϊ��������������һ���ո������N m
������ N �� <32000 ����ʾ��Ǯ���� m �� <60 ��Ϊϣ��������Ʒ�ĸ�������

�ӵ� 2 �е��� m+1 �У��� j �и����˱��Ϊ j-1 ����Ʒ�Ļ������ݣ�
ÿ���� 3 ���Ǹ����� v p q

������ v ��ʾ����Ʒ�ļ۸� v<10000 ���� p ��ʾ����Ʒ����Ҫ�ȣ� 1 ~ 5 ���� q
 ��ʾ����Ʒ���������Ǹ�������� q=0 ����ʾ����ƷΪ��������� q>0 ��
 ��ʾ����ƷΪ������ q �����������ı�ţ�
 



�������:
 ����ļ�ֻ��һ����������Ϊ��������Ǯ������Ʒ�ļ۸�����Ҫ�ȳ˻����ܺ͵����ֵ
 �� <200000 ����

��������:
1000 5
800 2 0
400 5 1
300 5 1
400 3 0
500 2 0

�������:
2200



 */



package oj.nowCoder;

import java.util.Arrays;
import java.util.Scanner;

public class ��Ϊ���ﵥ160408 {
	static int [][]v = new int[70][3];
	static int [][]dp = new int[70][32000];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			final int N = scan.nextInt();
			final int m = scan.nextInt();
			for (int i = 1; i <= m; i ++) {
				v[i][0] = scan.nextInt();
				v[i][1] = v[i][0] * scan.nextInt();
				v[i][2] = scan.nextInt();
			}
			Arrays.fill(v[0], 0);
			Arrays.fill(dp[0], 0);
			for (int ni = 1; ni <= N; ni ++) {
				for (int mi = 1; mi <= m; mi ++) {
					if (v[mi][2] > 0) {
						if (ni > v[mi][0] + v[v[mi][2]][0]) {
							final int thisdp = dp[mi-1][ni];
							final int newdp = dp[mi-1][ni-v[mi][0]]+v[mi][1];
							if (newdp > thisdp) {
								dp[mi][ni] = newdp;
							} else {
								dp[mi][ni] = thisdp;
							}
						}
					} else {
						if (ni > v[mi][0]) {
							final int thisdp = dp[mi-1][ni];
							final int newdp = dp[mi-1][ni-v[mi][0]]+v[mi][1];
							if (newdp > thisdp) {
								dp[mi][ni] = newdp;
							} else {
								dp[mi][ni] = thisdp;
							}
						}
					}
				}
			}
			System.out.println(dp[m][N]);
		}
		scan.close();
	}
}
