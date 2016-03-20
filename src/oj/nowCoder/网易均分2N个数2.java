package oj.nowCoder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/*

������Ŀ�Ľⷨ���ܶ�ʱ���Ƕ�̬�滮
2n����������֪������sum
����һ��s[2*n][n]������д洢
��֪��


 */
public class ���׾���2N����2 {
	// ����Ϊ���������϶���û���κδ���ģ����ǳ����˴���Ӧ���Ǳ�̴���ϣ��ĳ��ʱ���Լ��ܹ���������������
	// ��������̫��߼����ݽṹ���Լ�д����
	public static void main(String[] args) {
		int[] data = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int sum = getSum(data);
		int possSum = sum/2;
		Node[] node = new Node[possSum + 1];
		for (int i = 0; i < node.length; i ++) {
			node[i] = new Node();
		}
		int value;
		for (int index = 0; index < data.length; index ++) {
			value = data[index];
			HashSet<Integer> hs = new HashSet<Integer>();
			hs.add(index);
			node[value].al.add(hs);
		
		}
		for (int index1 = 0; index1 < node.length; index1 ++) {
			for (int index2 = 0; index2 <= index1; index2 ++) {
				int asum = index1, splus1 = index2, splus2 = index1 - index2;
				
				ArrayList<HashSet<Integer>> al1 = node[splus1].al;
				ArrayList<HashSet<Integer>> al2 = node[splus2].al;
				
				if (al1.size() == 0 || al2.size() == 0)
					continue;
				
				ArrayList<HashSet<Integer>> alT = new ArrayList<HashSet<Integer>> ();
				
				for (int i = 0; i < al1.size(); i ++) {
					for (int j = 0; j < al2.size(); j ++) {
						HashSet<Integer> hs1 = al1.get(i);
						HashSet<Integer> hs2 = al2.get(j);
						if (! hs1.containsAll(hs2)) {
							HashSet<Integer> hs3 = new HashSet<Integer>();
							hs3.addAll(hs1);
							hs3.addAll(hs2);
							alT.add(hs3);
						}
					}
				}
				
				
				node[asum].al.addAll(alT);
			}
		}
		ArrayList<HashSet<Integer>> ansal = node[possSum].al;
		for (int i = 0; i < ansal.size(); i ++) {
			Iterator<Integer> it = ansal.get(i).iterator();
			while (it.hasNext()) {
				System.out.printf("%d\t", it.next());
			}
			System.out.println();
		}
	}
	static class Node implements Cloneable{
		ArrayList<HashSet<Integer>> al;
		public Node () {
			al = new ArrayList<HashSet<Integer>>();
		}
		
	}
	static int getSum (int[] data) {
		int re = 0;
		for (int i : data) {
			re += i;
		}
		return re;
	}
	static int getMax (int[] data) {
		int re = Integer.MIN_VALUE;
		for (int i : data) {
			if (i > re)
				re = i;
		}
		return re;
	}
}
