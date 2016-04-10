package dataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Node implements Comparable<Node> {
	int weight;
	Node left, right;
	
	@Override
	public int compareTo(Node o) {
		return this.weight - o.weight;
	}
	
}


public class Ê÷¹þ·òÂüÊ÷ {
	public static void main(String[] args) {
//		ArrayList<Integer> alk = new ArrayList<Integer>();
		
		
		int[] arrInt = new int[]{3, 2, 4, 5, 9, 7, 3};
		Arrays.sort(arrInt);
		for (int i = 0; i < arrInt.length; i ++) {
			System.out.print(arrInt[i] + " ");
		}
		System.out.println();
		Scanner scan = new Scanner (System.in);
		ArrayList<Node> al = new ArrayList<Node>();
		Node newNode = null;
		int count = 0;
		while (scan.hasNext()) {
			count ++;
			if (count == 7) {
				break;
			}
			newNode = new Node();
			newNode.weight = scan.nextInt();
			al.add(newNode);
		}
		Collections.sort(al);
		Node node1 = null, node2 = null;
		while (al.size() > 1) {
			node1 = al.get(0);
			node2 = al.get(1);
			Node newParent = new Node();
			newParent.weight = node1.weight + node2.weight;
			newParent.left = node1;
			newParent.right = node2;
			al.remove(1);
			al.remove(0);
			int i = 0;
			for (; i < al.size(); i ++) {
				if (al.get(i).weight > newParent.weight) {
					break;
				}
			}
			al.add(i, newParent);
		}
		Node finalRoot = al.get(0);
		System.out.println(finalRoot.weight);
		scan.close();
	}
}
