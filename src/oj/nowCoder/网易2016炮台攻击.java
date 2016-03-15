package oj.nowCoder;

import java.util.Scanner;

/*
������ѵ��Ī֮��,Ȼ�����Ī������Լ�¶���,
̸��Լ�¶���,��Ȼ�ٲ���һ����,�� ���Ǻ�Ĭ����------
Լ�¶�����ʷ����ΰ��Ŀ�ѧ��. ��Ī˵,��Ĭ���������˼��һ������:
��Ĭ������������̨,��̨�ܹ�����������R�ĵ��� (����֮��ľ���Ϊ���������ľ���,����(3,0),(0,4)֮��ľ�����5),
���һ����̨�ܹ��� ������,��ô�ͻ�Ե������1�����˺�.��Ĭ����������̨����N*M�����еĵ���,���Ҹ������� ������. 
��:��ô�����ܵ��˺����Ƕ��?

��������:
��һ��9������,R,x1,y1,x2,y2,x3,y3,x0,y0.R������̨������������,(x1,y1),(x2,y2),
(x3,y3)����������̨������.(x0,y0)������˵�����.


�������:
���һ��,��һ�д�����˳��ܵ�����˺�,(���ÿ����̨�����ܹ���������,���0��)

��������:
1 1 1 2 2 3 3 1 2

�������:
2x
 */
public class ����2016��̨���� {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int r;P p1, p2, p3, p0;
		while (sc.hasNext()) {
			r = sc.nextInt();
			p1 = new P(sc.nextInt(), sc.nextInt());
			p2 = new P(sc.nextInt(), sc.nextInt());
			p3 = new P(sc.nextInt(), sc.nextInt());
			p0 = new P(sc.nextInt(), sc.nextInt());
			int times = 0; double dis ;
			dis = getDis(p1, p0);
			if (dis < r)  times ++;
//			else if ((dis - (int)dis) < 0.0000001 )
//				times ++;
			dis = getDis(p2, p0);
			if (dis < r)  times ++;
//			else if ((dis - (int)dis) < 0.0000001)
//				times ++;
			dis = getDis(p3, p0);
			if (dis < r)  times ++;
//			else if ((dis - (int)dis) < 0.0000001)
//				times ++;
			System.out.printf("%dx\n",times);
		}
		sc.close();
	}
	static class P {
		int x,y;
		public P(){}
		public P(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	private static double getDis (P p1, P p2) {
		return Math.sqrt( (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y) );
	}
}
