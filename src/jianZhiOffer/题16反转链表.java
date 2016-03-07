package jianZhiOffer;

/*
 * 注意输入：
 * 		1，空指针
 * 		2，整个链表只有一个节点
 * 		3，反转后出现断裂
 * 		4，反转后的头结点不是原始链表的尾节点
 */
public class 题16反转链表 {
	public static void main(String[] args) {
		Node head = new Node (1);
		Node newHead = reverseList3(head);
		showListNode(newHead);
		Node  addTemp, tail = head;
		for (int i = 2; i < 10; i ++) {
			addTemp = new Node (i);
			tail.next = addTemp;
			tail = addTemp;
		}
		showListNode(head);
		newHead = reverseList3(head);
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
//	private static Node reverseList (Node head) {
//		if (head == null)
//			return null;
//		Node travelHead = head,travelPre = head.next,travelPost = null;
//		while (travelHead.next != null) {
//			travelPre = travelHead.next;
//			travelHead.next = travelPost;
//			travelPost = travelHead;
//			travelHead = travelPre;
//			travelPre = travelPre.next;
//		}
//		travelHead.next = travelPost;
//		return travelHead;
//	}
//	private static Node reverseList2 (Node head) {
//		if (head == null)
//			return null;
//		Node travelHead = head, travelPre = head.next, travelPost = null;
//		while (travelHead.next != null) {
//			travelHead.next = travelPost;
//			travelPost = travelHead;
//			travelHead = travelPre;
//			travelPre = travelHead.next;
//		}
//		travelHead.next = travelPost;
//		return travelHead;
//	}
	private static Node reverseList3(Node head) {
		if (head == null)   return null;
		Node travelHead = head, travelPre = head.next, travelPost = null;
		while (travelHead.next != null) {
			travelHead.next = travelPost;
			travelPost = travelHead;
			travelHead = travelPre;
			travelPre = travelPre.next;
		}
		travelHead.next = travelPost;
		return travelHead;
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





















