package oj.nowCoder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * 
 * 
 * 在N*M的草地上,提莫种了K个蘑菇,蘑菇爆炸的威力极大,兰博不想贸然去闯,而且蘑菇是隐形的.
 * 只 有一种叫做扫描透镜的物品可以扫描出隐形的蘑菇,于是他回了一趟战争学院,买了2个扫描透镜,
 * 一个 扫描透镜可以扫描出(3*3)方格中所有的蘑菇,然后兰博就可以清理掉一些隐形的蘑菇. 
 * 问:兰博最多可以清理多少个蘑菇?

输入描述:
第一行三个整数:N,M,K,(1≤N,M≤20,K≤100),N,M代表了草地的大小;
接下来K行,每行两个整数x,y(1≤x≤N,1≤y≤M).代表(x,y)处提莫种了一个蘑菇.
一个方格可以种无穷个蘑菇.


输出描述:
输出一行,在这一行输出一个整数,代表兰博最多可以清理多少个蘑菇
 * 
 * 
 */
public class 网易扫描 {
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
		//没有完成
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
