package oj.nowCoder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//题目意思如上题所示
public class 网易奖学金2 {
	private static int num, full, need;
	private static A[] a;
	static class A implements Comparable <A>{
		int ava, pay;
		public A (int ava, int pay) {
			this.ava = ava;
			this.pay = pay;
		}
		public String toString () {
			return String.format("%d %d\t", ava, pay);
		}
		@Override
		public int compareTo(A o) {
			return pay - o.pay;
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		while (in.hasNext()) {
			num = in.nextInt();
			full = in.nextInt();
			need = in.nextInt() * num;
			a = new A[num];
			for (int i = 0; i < num; i ++) {
				a[i] = new A (full - in.nextInt(), in.nextInt());
				need  -= full - a[i].ava;
			}
			Arrays.sort(a);
//			sort(0 , num- 1);
			print();
			System.out.println(select(0));
		}
		in.close();
	}
	
	
	
	static class AA  implements Comparator <A>{

		@Override
		public int compare(A a0, A a1) {	
			return a0.pay - a1.pay;
		}
		
	}
	static long select (long c) {
		for (int i = 0 ; i < num; i ++) {
			int se = a[i].ava;
			if (se > need)
				se = need;
			need -= se;
			c += se * a[i].pay;
			if (need <= 0)
				break;
		}
		return c;
	}
	static void sort (int b, int e) {
		if (b >= e)
			return;
		int p = pa (b, e);
		sort (b,p-1);
		sort (p+1, e);
	}
	static int pa (int b, int e) {
		
		A as = a[b];
		while (b < e) {
			while (b < e && a[e].pay >= as.pay)   --e;
			a[b] = a[e];
			while (b < e && a[b].pay <= as.pay)   ++b;
			a[e] = a[b];
		}
		a[b] = as;
		return b;
	}
	static void print () {
		for (int i = 0; i < a.length; i ++)
			System.out.print(a[i]);
	}
	
}
