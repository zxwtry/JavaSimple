package oj.nowCoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class 华为数据分类处理 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int ic, rc;
		long i[], r[];
		while(in.hasNext()) {
			ic = in.nextInt();
			i = new long[ic];
			for (int index = 0; index < ic; index ++) {
				i[index] = in.nextInt();
			}
			rc = in.nextInt();
			r = new long[rc];
			for(int index = 0; index < rc; index ++) {
				r[index] = in.nextInt();
			}
			Arrays.sort(r);
			HashMap<Long, ArrayList<Integer>> hm = new
					HashMap<Long, ArrayList<Integer>>();
			for(int indexI = 0; indexI < ic; indexI ++) {
				long pre = Long.MIN_VALUE;
				for (int index = 0; index < rc; index ++) {
					if (pre != r[index]) {
						if(isHas(r[index],i[indexI])) {
							ArrayList<Integer> al;
							if(!hm.containsKey(r[index])) {
								al = new ArrayList<Integer>();
							} else {
								al = hm.get(r[index]);
							}
							al.add(indexI);
							hm.put(r[index], al);
						}
						pre = r[index];
					}
				}
			}
			ArrayList<Integer> all;
			Iterator<Integer> it;
			Set<Long> ks = hm.keySet();
			ANS[] arrans = new ANS[ks.size()];
			int arransIndex = 0;
			int count = 0;
			for(long k : ks) {
				StringBuilder st = new StringBuilder();
				st.append(k+" ");
				count += 2;
				all = hm.get(k);
				st.append(all.size()+" ");
				it = all.iterator();
				while(it.hasNext()) {
					int index = it.next();
					st.append(index+" "+i[index]+" ");
					count += 2;
				}
				arrans[arransIndex] = new ANS();
				arrans[arransIndex].l = k;
				arrans[arransIndex].str = st.toString();
				arransIndex ++;
			}
			Arrays.sort(arrans);
			System.out.print(count+" ");
			for(int index = 0; index < arrans.length - 1; index ++) {
				System.out.print(arrans[index].str);
			}
			String tmp = arrans[arrans.length - 1].str;
			System.out.println(tmp.substring(0, tmp.length()-1));
		}
		in.close();
	}
	private static boolean isHas(long r, long i) {
		char[] sr = String.valueOf(r).toCharArray();
		char[] si = String.valueOf(i).toCharArray();
		final int rlen = sr.length, ilen = si.length;
		final int indexEnd = ilen - rlen;
		boolean isM = true, isAM = false;
		for (int index = 0; index <= indexEnd; index ++) {
			isM = true;
			for (int indexR = 0; indexR < rlen; indexR ++) {
				if (isM && sr[indexR] != si[index+indexR]) {
					isM = false;
				}
			}
			if(isM) {
				isAM = true;
			}
		}
		return isAM;
	}
	static class ANS implements Comparable<ANS>{
		long l;
		String str;
		@Override
		public int compareTo(ANS o) {
			return (int)(this.l - o.l);
		}
	}
}