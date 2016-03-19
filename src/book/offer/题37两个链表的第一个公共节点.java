package book.offer;
//将题目更改为判断是否有一个公共节点，那是可以使用环的方法的
public class 题37两个链表的第一个公共节点 {
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		node1.next = node2; node2.next = node3; 
		node3.next = node6;node6.next = node7;
		node4.next = node5; node5.next = node6;
		ListNode publicNode = getTheFirstPublic (node1, node4);
		System.out.println(publicNode.data);
	}
	static class ListNode {
		int data;
		ListNode next;
		public ListNode () {
			this(Integer.MIN_VALUE, null);
		}
		public ListNode (int data) {
			this(data, null);
		}
		public ListNode (int data, ListNode next) {
			this.data = data;
			this.next = next;
		}
	}
	public static ListNode getTheFirstPublic (ListNode head1, ListNode head2) {
		ListNode head1Travel = head1, head2Travel = head2;
		int count1 = 0, count2 = 0;
		while (head1Travel != null) {
			count1 ++;
			head1Travel = head1Travel.next;
		}
		while (head2Travel != null) {
			count2 ++;
			head2Travel = head2Travel.next;
		}
		head1Travel = head1;  head2Travel = head2;
		if (count1 > count2) {
			for (int i = 0; i < count1-count2; i ++)
				head1Travel = head1Travel.next;
		} else if (count2 > count1) {
			for (int i = 0; i < count2-count1; i ++)
				head2Travel = head2Travel.next;
		}
		ListNode firstPublicNode = null;
		while (head1Travel != null) {
			if (head1Travel == head2Travel) {
				firstPublicNode = head1Travel;
				break;
			}
			head1Travel = head1Travel.next;
			head2Travel = head2Travel.next;
		}
		return firstPublicNode;
	}
}
