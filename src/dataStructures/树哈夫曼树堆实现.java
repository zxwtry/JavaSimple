package dataStructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ������������ʵ�� {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = 10;
		ArrayList<Node> al = new ArrayList<Node>();
		Node newNode = null;
		for (int i = 0; i < num; i ++) {
			newNode = new Node();
			newNode.weight = scan.nextInt();
			al.add(newNode);
		}
		Collections.sort(al);
		for (int i = 0; i < al.size() / 2 - 1; i ++) {
			Node root = al.get(i);
			root.left = al.get(2 * i + 1);
			root.right = al.get(2 * i + 2);
		}
		// ��ɽ�һ��ArrayListת����һ��С�� 
		// ֻҪ���ͷ�ڵ����
		Node root = al.get(0);
		System.out.println(root.weight);
		scan.close();
	}
	static void heap(ArrayList<Node> al) {
		int index = 0;
		while (index < al.size()) {
			
		}
	}
	static class Node implements Comparable<Node> {
		int weight;
		Node left, right;
		public int compareTo(Node node) {
			return this.weight - node.weight;
		}
	}
}
