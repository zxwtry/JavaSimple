package jianZhiOffer;

import java.util.Stack;

public class 题05从尾到头打印链表 {
	static class Node {
		int data;
		Node next;
		public Node () {}
		public Node (int data) {
			this.data = data;
		}
	}
	private static void printLinkedListReversingly (Node head) {
		Stack<Node> stk = new Stack<Node>();
		Node headTravel = head;
		while (headTravel != null) {
			stk.push(headTravel);
			headTravel = headTravel.next;
		}
		while (!stk.empty()) {
			headTravel = stk.pop();
			System.out.printf("%d\t", headTravel.data);
		}
	}
	public static void main (String[] args) {
		Node head = new Node(0);
		Node headTravel = head;
		Node createTemp = null;
		for (int i = 1; i < 10; ++ i) {
			createTemp = new Node(i*i);
			headTravel.next = createTemp;
			headTravel = createTemp;
		}
		printLinkedListReversingly(head);
	}
}
