package oj.nowCoder;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/*

今后，排序之类的一律使用TreeMap, TreeSet !!!!


 */
public class 网易奖学金3 {
	public static void main(String[] args) {
		
		Scanner in = new Scanner (System.in);
		
		long num, full, need;
		TreeSet<Node> ts = new TreeSet<Node>();
		Node node;
		long cost, myAva;
		while (in.hasNext()) {
			num = in.nextInt();
			full = in.nextInt();
			need = in.nextInt() * num;
			
			int used;
			for (int i = 0; i < num; i ++) {
				used = in.nextInt();
				need -= used;
				ts.add(new Node(full-used, in.nextInt(), i+1));
			}
			
			
			cost = 0;
			
			
			while (need > 0) {
				node = ts.pollFirst();
//				node = ts.first();
				myAva = need;
				if (myAva > node.ava)
					myAva = node.ava;
				need -= myAva;
				cost += myAva * node.pay;
			}
			System.out.println(cost);
			
			ts.clear();
		}
		
		
		in.close();
	}
	
	static class Node implements Comparable <Node> {
		long ava, pay, hash;
		public Node (long ava, long pay, long hash) {
			this.ava = ava;
			this.pay = pay;
			this.hash = hash;
		}
		@Override
		public int compareTo(Node arg0) {
			long re = this.pay-arg0.pay;
			if (re == 0)
				re = 1;
			return (int)re;
		}
		@Override
		public boolean equals (Object o) {
			if ( !(o instanceof Node) )
				return false;
			Node on = (Node) o;
			return on.ava == this.ava && on.pay == this.pay && this.hash == on.hash;
		}
		@Override
		public int hashCode () {
			return (int)hash;
		}
		
	}
	
	static class ComparatorA implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			return (int)(o1.pay - o2.pay);
		}
		
	}
	
}
