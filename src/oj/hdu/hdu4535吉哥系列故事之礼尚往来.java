package oj.hdu;

import java.util.Scanner;

/*


���绹���Ǹ�����
�����Ǹ������˳ơ�ߴߴ�硱�Ļ���
����
����ÿ���������٣�Ů���ڶ��ߴߴ�������ܴ�ȫ�����ص�Ů�������յ��������
�����������յ���Ȼֵ�ø��ˣ�������ȷ�Ǽ��鷳���£�
�������۶��鷳���ܲ�����˼�������������Ҳ����ߴߴ��ķ��
����
�������ڣ����������ֿ��ŵ�ߴߴ�������һ������ĺð취��
��׼��������Ů�����������������䣬�ٻ��Ͳ�ͬŮ�ѣ������Ͳ����ٻ�Ǯ�������ˣ�
����
��������ߴߴ���n��Ů��ÿ������һ�����ÿ�����͵����ﶼ����ͬ����
��������Ҫ�����ţ��ٻ���ÿ��Ů��һ������ص��ǣ�
���͵����ﲻ�������Ů��֮ǰ�������Ǹ������Ȼ��ߴߴ��ɾ�̯�����ˣ�̯�ϴ�����......
����
�������ڣ�ߴߴ����֪���ܹ��ж��������������Ļ������﷽���أ�


 */
public class hdu4535����ϵ�й���֮�������� {
	static final long l = 1000000007l;
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int times = -1;
//		while(in.hasNext()) {
			times = in.nextInt();
			for (int i = 0; i < times; i ++) {
				System.out.println(getAns(in.nextInt())%l);
			}
//		}
		in.close();
	}
	private static long getAns(int num) {
		if (num == 1) {
			return 0l;
		} else if (num == 2) {
			return 1l;
		} else if (num == 3) {
			return 2l;
		}
		long n2 = 2l, n1 = 9l, ans = 9l;
		for (int i = 4; i < num; i ++) {
			ans = (i) * (n2 + n1) % l;
			n2 = n1;
			n1 = ans;
		}
		return ans;
	}
}
