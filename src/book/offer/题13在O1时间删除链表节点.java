package book.offer;

/*
�������������ͷָ���һ���ڵ�ָ�룬 ����һ��������O(1)�¼�ɾ���ýڵ㡣
 */

public class ��13��O1ʱ��ɾ������ڵ� {
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
