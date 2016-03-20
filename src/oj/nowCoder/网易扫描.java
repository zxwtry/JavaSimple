package oj.nowCoder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * 
 * 
 * ��N*M�Ĳݵ���,��Ī����K��Ģ��,Ģ����ը����������,��������óȻȥ��,����Ģ�������ε�.
 * ֻ ��һ�ֽ���ɨ��͸������Ʒ����ɨ������ε�Ģ��,����������һ��ս��ѧԺ,����2��ɨ��͸��,
 * һ�� ɨ��͸������ɨ���(3*3)���������е�Ģ��,Ȼ�������Ϳ��������һЩ���ε�Ģ��. 
 * ��:����������������ٸ�Ģ��?

��������:
��һ����������:N,M,K,(1��N,M��20,K��100),N,M�����˲ݵصĴ�С;
������K��,ÿ����������x,y(1��x��N,1��y��M).����(x,y)����Ī����һ��Ģ��.
һ����������������Ģ��.


�������:
���һ��,����һ�����һ������,��������������������ٸ�Ģ��
 * 
 * 
 */
public class ����ɨ�� {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
	
		int N, M ,K;
		P[] a;
		Set<P> set = new HashSet<P> ();
		while (in.hasNext()) {
			N = in.nextInt();
			M = in.nextInt();
			K = in.nextInt();
			a = new P[K];
			while (-- K >= 0) {
				a[K] = new P(in.nextInt(), in.nextInt());
				set.add(a[K]);
			}
			
			System.out.println(getAns(N, M, a));
			
		}
		
		in.close();
	}
	
	static int getAns (int N, int M, P[] a) {
		//û�����
//		final int len = a.length;
//		int ans = -1;
//		int index;
//		for (index = 0; index < len; index ++) {
//			ArrayList<P> al = getAround(N, M ,a[index]);
//			HashSet<P> t = new HashSet<P> ();
//		}
		return 0;
	}
	
	static ArrayList<P> getAround (int N, int M, P p) {
		ArrayList<P> re = new ArrayList < P> ();
		
		
		if (p.x == 1 || p.x == N || p.y == 1 || p.y == M) {
			int xx = p.x, yy = p.y;
			if (p.x == 1) {
				xx ++;
			} else if (p.x == N) {
				xx --;
			}
			if (p.y == 1)
				yy ++;
			else if (p.y == M)
				yy --;
			re = getAround(N, M ,new P (xx, yy));
		} else {
			re.add(new P(p.x - 1, p.y -1));
			re.add(new P(p.x, p.y -1));
			re.add(new P(p.x + 1, p.y -1));
			re.add(new P(p.x - 1, p.y));
			re.add(new P(p.x, p.y));
			re.add(new P(p.x + 1, p.y));
			re.add(new P(p.x - 1, p.y +1));
			re.add(new P(p.x, p.y +1));
			re.add(new P(p.x + 1, p.y +1));
		}
		
		return re;
		
		
		
	}
	
	static class P {
		int x, y;
		public P (int x, int y) {
			this.x= x;
			this.y = y;
		}
		public String toString () {
			return String.format("%d %d", x, y);
		}
		
		@Override
		public boolean equals (Object x) {
			if (!( x instanceof P) )
				return false;
			P p = (P) x;
			return p.x == this.x && p.y == this.y;
		}
		
		@Override
		public int hashCode () {
			return x * 1000 + y;
		}
	}
}
