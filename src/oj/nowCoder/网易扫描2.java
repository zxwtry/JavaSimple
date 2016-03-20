package oj.nowCoder;

import java.util.HashSet;
import java.util.Scanner;


//题目见上面，注意一个点可能有非常多个蘑菇

public class 网易扫描2 {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		int N, M, K;
		P[][] a;
		P[] b;
		while (in.hasNext()) {
			N = in.nextInt();
			M = in.nextInt();
			K = in.nextInt();
			if (N < 3)
				N = 3;
			if (M < 3)
				M = 3;
			a = new P[N+2][M+2];
			b = new P[K];
			int x, y;
			while (--K >= 0) {
				x = in.nextInt();
				y = in.nextInt();
				if (a[x][y] == null) {
					a[x][y] = new P(x, y);
				} else {
					a[x][y].num ++;
				}
				b[K] = new P(x, y);
			}
			print(a);
			int finalOut = -1, count = 0;
			for (int i = 1; i <= N; i ++) {
				for (int j = 1; j <= M; j ++) {
					count = 0;
					HashSet<P> hashSet = new HashSet<P>();
					HashSet<P> hashSet2 = new HashSet<P> ();
					for (int nx = -1; nx < 2; nx ++) {
						for (int ny = -1; ny < 2; ny ++) {
							if (a[i+nx][j+ny] != null) {
								count += 1;
								a[i+nx][j+ny].num --;
								hashSet.add(a[i+nx][j+ny]);
							}
						}
					}
					int anotherFinal = 0, acount = 0;
					for (int u = 1; u <= N; u ++) {
						for (int v = 1; v <= M; v ++) {
							acount = 0;
							for (int nx = -1; nx < 2; nx ++) {
								for (int ny = -1; ny < 2; ny ++) {
									if (a[u+nx][v+ny] != null && a[u+nx][v+ny].num > 0) {
										hashSet2.add(a[u+nx][v+ny]);
											acount ++;
									}
								}
							}
							if (anotherFinal < acount)
								anotherFinal = acount;
							else
								hashSet2.clear();
						}
					}
					count += anotherFinal;
					for (int nx = -1; nx < 2; nx ++) {
						for (int ny = -1; ny < 2; ny ++) {
							if (a[i+nx][j+ny] != null) {
								a[i+nx][j+ny].num ++;
							}
						}
					}
					if (finalOut < count)
						finalOut = count;
				}
			}
			
				System.out.println(finalOut);
		}
		in.close();
	}
	
	static class P {
		int x,y,num;
		public P (int x, int y) {
			this.x = x;
			this.y = y;
			num = 1;
		}

		public String toString () {
			return String.format("x:%d y:%d num:%d", x, y, num);
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
			return x * 10000 + y;
		}
	}
	
	public static  void print (P[][] a) {
		final int len1 = a.length;
		final int len2 = a[0].length;
		for (int i = -1; i < len2; i ++) {
			System.out.printf("%d\t", i);
		}
		System.out.println("\n");
		for (int i = 0; i < len1; i ++) {
			System.out.printf("%d\t", i);
			for (int j = 0; j < len2; j ++) {
				int out = 0;
				if (a[i][j] != null)
					out = a[i][j].num;
				System.out.printf("%d\t", out);
			}
			System.out.println("\n");
		}
	}
	
	
}
