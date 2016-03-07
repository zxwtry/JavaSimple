package jianZhiOffer;

/*
 * ע�����룺
 * 		1����ָ��
 * 		2����������ֻ��һ���ڵ�
 * 		3����ת����ֶ���
 * 		4����ת���ͷ��㲻��ԭʼ�����β�ڵ�
 */
public class ��16��ת���� {
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





















