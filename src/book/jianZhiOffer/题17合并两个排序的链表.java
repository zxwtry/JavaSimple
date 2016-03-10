package book.jianZhiOffer;


public class 题17合并两个排序的链表 {
	public static void main(String[] args) {
		Node head1 = new Node(0), tail = head1;
		for (int i = 1; i < 8; i ++) {
			Node temp = new Node(3*i+5);
			tail.next = temp;
			tail = temp;
		}
		showListNode(head1);
		Node head2 = new Node(-1);tail = head2;
		for (int i = 1; i < 8; i ++) {
			Node temp = new Node(i*i);
			tail.next = temp;
			tail = temp;
		}
		showListNode(head2);
		Node newHead = mergeTwoList(head1, head2);
		showListNode(newHead);
	}
	static class Node {
		int data;
		Node next;
		public Node () {}
		public Node (int data) {
			this.data = data;
		}
	}
	private static Node mergeTwoList (Node head1, Node head2) {
		if (head1 == null)
			return head2;
		else if (head2 == null)
			return head1;
		Node mergeHead = null;
		if (head1.data < head2.data) {
			mergeHead = head1;
			mergeHead.next = mergeTwoList(head1.next, head2);
		} else {
			mergeHead = head2;
			mergeHead.next = mergeTwoList(head1, head2.next);
		}
		return mergeHead;
	}
	private static void showListNode (Node head) {
		Node travel = head;
		while (travel != null) {
			System.out.printf("%d\t", travel.data);
			travel = travel.next ;
		}
		System.out.println();
	}
}
