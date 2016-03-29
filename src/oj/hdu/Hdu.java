package oj.hdu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Hdu {
	static int times;
	static long l;
	static int numSmall;
	static int numBig;
	public static void main (String[] args) {
		Problem4.main(null);
	}
	static class Problem1 {
		public static void main (String[] args) {
			Scanner in = new Scanner (System.in);
			while (in.hasNext()) {
				times = in.nextInt();
				while (times -- > 0) {
					l = (long)in.nextInt();
					System.out.println((l*l)%10000);
				}
			}
			in.close();
		}
	}
	static class Problem2 {
		static HashMap<Integer, HashSet<Integer>> hm = new 
				HashMap<Integer, HashSet<Integer>>();
		public static void main (String[] args) {
			Scanner in = new Scanner (System.in);
			while (in.hasNext()) {
				times = in.nextInt();
				while(times -- > 0) {
					numSmall = in.nextInt();
					numBig = in.nextInt();
					for (int index = numSmall; index <= numBig; index ++) {
						getAll(index);
					}
					int max = Integer.MIN_VALUE;
					int size;
					int index = -1;
					for (int s = numSmall; s <= numBig; s ++) {
						size = hm.get(s).size();
						if (size > max) {
							max = size;
							index = s;
						}
					}
					System.out.println(index);
				}
			}
			in.close();
		}
		private static void getAll (int data) {
			if (hm.containsKey(data))
				return;
			HashSet<Integer> hs = new HashSet<Integer>();
			hs.add(1);
			hs.add(data);
			int pre = 0;
			for (pre = 2; pre < data; pre ++) {
				if (data%pre == 0) {
					if (! hm.containsKey(pre)) {
						getAll(pre);
					}
					hs.addAll(hm.get(pre));
				}
			}
			hm.put(data, hs);
		}
	}
	static class Problem3 {
		public static void main (String[] args) {
			Scanner in = new Scanner(System.in);
			while(in.hasNext()) {
				times = in.nextInt();
				while(times -- > 0) {
					print(in.nextInt());
				}
			}
			in.close();
		}
		private static void print(int data) {
			long l = Long.MAX_VALUE;
			System.out.println(l);
			double adata = (double)1/(double)data;
			String sdata = String.valueOf(adata);
			System.out.println(sdata);
		}
	}
	static class Problem3Ans {
		// 应该是完全相同的计算过程，c++
		// 完全没有问题，但是java却总是TLE
		// 问题完全未知。
		static boolean[] hash = new boolean[100005];
		static int num;
		public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			
				times = in.nextInt();
				while(times-- > 0) {
					num = in.nextInt();
					if (num != 1) {					
						System.out.print("0.");
						myPrint();
						System.out.println();
					} else {
						System.out.println(1);
					}
				}
			
			in.close();	
		}
		private static void myPrint() {
			int l = 1;
			Arrays.fill(hash, false);
			hash[l] = true;
			while(l > 0) {
				l *= 10;
				System.out.printf("%d",l/num);
				l %= num;
				if (hash[l]) {
					break;
				}
				hash[l] = true;
			}
		}
	}
	static class Problem4 {
		public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			while(in.hasNext()) {
				times = in.nextInt();
				while (times -- > 0) {
					int len = in.nextInt();
					int K = in.nextInt();
					int arr[] = new int[len];
					while( --len >= 0) {
						int k = in.nextInt();
						arr[len] = k;
					}
					if (arr.length == 1) {
						System.out.println(arr[0]);
						continue;
					}
					HashSet<Integer> hs = new HashSet<Integer>();
					int index1 = 0, index2 = 1;
					for(; index2 < arr.length; index2 ++) {
						for (index1 = 0 ; index1 < index2; index1 ++) {
							hs.add(Math.abs(arr[index1] - arr[index2]));
						}
					}
					Iterator<Integer> it = hs.iterator();
					int itIndex = 0;
					int count = 0;
					while(it.hasNext()) {
						if (itIndex == K - 1) {
							count = it.next();
						} else {
							it.next();
						}
						itIndex ++;
					}
					System.out.println(count);
				}
			}
			in.close();
		}
	}
}
