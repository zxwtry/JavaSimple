package book.offer;

/*
给定单项链表的头指针和一个节点指针， 定义一个函数在O(1)事件删除该节点。
 */

public class 题13在O1时间删除链表节点 {
	static class Node {
		int data;
		Node next;
		public Node (int data) {
			this.data = data;
			this.next = (Node)null;
		}
		public Node () {}
	}
	private static Node deleteNode (Node head, Node nodeToBeDeleted) {
		if (head == null || nodeToBeDeleted == null)
			return (Node)null;
		if (nodeToBeDeleted.next != null) {
			Node deletedNext = nodeToBeDeleted.next;
			nodeToBeDeleted.data = deletedNext.data;
			nodeToBeDeleted.next = deletedNext.next;
		} else if (head == nodeToBeDeleted) {
			head = null;
		} else {
			Node travel = head;
			while (travel.next != nodeToBeDeleted)
				travel = travel.next;
			travel.next = null;
		}
		return head;
	}
	private static void showListNode (Node head) {
		Node travel = head;
		while (travel != null) {
			System.out.printf("%d\t", travel.data);
			travel = travel.next ;
		}
		System.out.println();
	}
	public static void main (String[] args) {
		Node head = new Node (1);
		Node node9 = null, addTemp, tail = head;
		for (int i = 2; i < 10; i ++) {
			addTemp = new Node (i);
			if (i == 9)
				node9 = addTemp;
			tail.next = addTemp;
			tail = addTemp;
		}
		head = deleteNode (head, node9);
//		deleteNode(head ,node9);
//		head = deleteNode(head, head);
		showListNode(head);
	}
}
