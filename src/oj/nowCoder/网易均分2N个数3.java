package oj.nowCoder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

//题目不赘述，看前面
//这样的做法有明显缺陷，不能对大数进行处理，大数小数并存的情况更是无法操作
public class 网易均分2N个数3 {
	public static void main(String[] args) {
		
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		
//		int[] data = {999100, 999100, 999200, 999300, 999400, 999500, 999600, 999700, 9999800, 9999900};
		int[] data = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int sum = getSum (data);
		int prolen = sum/2 + 1;
		Node[] na = new Node[prolen];
		for (int i = 0; i < prolen; i ++) {
			na[i] = new Node();
		}
		for (int i = 0; i < data.length; i ++) {
			int value = data[i];
			HashSet<Integer> lli = new HashSet<Integer>();
			lli.add(i);
			na[value].ll.add(lli);
		}
		for (int i = 1; i < na.length; i ++) {
			for (int j = 0; j < i; j ++) {
				int asum = i, a1 = j, a2 = i - j;
				final int len1 = na[a1].ll.size();
				final int len2 = na[a2].ll.size();
				for (int l1 = 0; l1 < len1; l1 ++) {
					for (int l2 = 0; l2 < len2; l2 ++) {
						
						HashSet<Integer> hs1 = na[a1].ll.get(l1);
						HashSet<Integer> hs2 = na[a2].ll.get(l2);
						
						boolean isContains = false;
						
						Iterator<Integer> it = hs1.iterator();
						while (it.hasNext()) {
							if (hs2.contains(it.next())) {
								isContains = true;
								break;
							}
						}
						
						
						if (! isContains) {
							
							HashSet<Integer> hs3 = new HashSet<Integer>();
							hs3.addAll(hs1);
							hs3.addAll(hs2);
							
							
							final int len = na[asum].ll.size();
							boolean isHasInAsum = false;
							for (int k = 0; k < len; k ++) {
								HashSet<Integer> hsT = na[asum].ll.get(k);
								if (hsT.size() == hs3.size() && hsT.containsAll(hs3) ) {
									isHasInAsum = true;
								}
							}
							
							if (! isHasInAsum )
								na[asum].ll.add(hs3);
						}
					}
				}
			}
		}
		ArrayList<HashSet<Integer>> al = na[na.length-1].ll;
		for (int i = 0; i < al.size(); i ++) {
			HashSet<Integer> hsi = al.get(i);
			Iterator<Integer> it = hsi.iterator();
			while (it.hasNext()) {
				System.out.printf("%d\t",data[it.next()]);
			}
			System.out.println();
		}
		
//		try {
//			Thread.currentThread().sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	static class Node {
		ArrayList<HashSet<Integer>> ll;
		public Node () {
			ll = new ArrayList<HashSet<Integer>>();
		}
	}
	static int getSum (int[] data) {
		int re = 0;
		for(int i : data) {
			re += i;
		}
		return re;
	}
}
