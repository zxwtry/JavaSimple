package jianZhiOffer;

/*
 * 链表尾节点是倒数第一个节点
 */
public class 题15链表中倒数第k个节点 {
	public static void main(String[] args) {
		Node head = new Node (0), tail = head;
		for (int i = 1; i < 4; ++ i) {
			Node temp = new Node (i);
			tail.next = temp;
			tail = temp;
		}
		showListNode(head);
		Node re = findKthToTail(head, 5);
		if (re != null)
			System.out.println(re.data);
		else 
			System.out.println("null");
	}
	static class Node {
		int data;
		Node next;
		public Node (int data) {
			this.data = data;
			next = null;
		}
	};
	private static Node findKthToTail (Node head, int k ) {
		if (k <= 0 || head == null)
			return (Node)null;
		Node preNodeIndex = head;
		for (int i = 1; i < k; ++ i) {
			preNodeIndex = preNodeIndex.next;
			if (preNodeIndex == null)
				return (Node)null;
		}
		Node reNode = head;
		while (preNodeIndex.next != null) {
			preNodeIndex = preNodeIndex.next;
			reNode = reNode.next;
		}
		return reNode;
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
