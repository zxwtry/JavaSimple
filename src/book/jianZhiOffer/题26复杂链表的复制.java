package book.jianZhiOffer;
/*
 * 一个简答的单链表，再在每个节点上面增加一个指向任意节点或null的引用
 */
public class 题26复杂链表的复制 {
	public static void main(String[] args) {
		ListNodeWithSibling node5 = new ListNodeWithSibling (5, null, null);
		ListNodeWithSibling node4 = new ListNodeWithSibling (4, node5, node5);
		ListNodeWithSibling node3 = new ListNodeWithSibling (3, node4, null);
		ListNodeWithSibling node2 = new ListNodeWithSibling (2, node3, node4);
		ListNodeWithSibling node1 = new ListNodeWithSibling (1, node2, null);
		showListNodeWithSibling (node1);
		cloneNode(node1);
		showListNodeWithSibling (node1);
		ListNodeWithSibling newHead = divideIntoTwoHalf (node1);
		showListNodeWithSibling(newHead);
		showListNodeWithSibling(node1);
	}
	static class ListNodeWithSibling {
		int data;
		ListNodeWithSibling next, sibling;
		public ListNodeWithSibling () {
			this(0, null, null);
		}
		public ListNodeWithSibling (int data) {
			this(data, null, null);
		}
		public ListNodeWithSibling (int data, ListNodeWithSibling next, ListNodeWithSibling sibling) {
			this.data = data;
			this.next = next;
			this.sibling = sibling;
		}
	}
	private static void cloneNode (ListNodeWithSibling head) {
		ListNodeWithSibling headTravel = head;
		//每一个节点上面都是进行克隆一个节点的操作
		//第一个循环是完成简单单向链表的复制，将复制节点的所有sibling都初置为null
		while (headTravel != null) {
			ListNodeWithSibling nodeInsert = new ListNodeWithSibling(headTravel.data, headTravel.next, null);
			headTravel.next = nodeInsert;
			headTravel = nodeInsert.next;
		}
		//返回头结点继续进行操作
		headTravel = head;
		while (headTravel != null && headTravel.next != null) {
			if (headTravel.sibling == null) {
				headTravel.next.sibling = null;
			} else {
				headTravel.next.sibling = headTravel.sibling.next;
			}
			headTravel = headTravel.next.next;
		}
	}
	private static ListNodeWithSibling divideIntoTwoHalf (ListNodeWithSibling head) {
		if (head == null)   return null;
		ListNodeWithSibling headNewList = head.next, tailOldList = head, tailNewList = head.next;
		while (true) {
			tailOldList.next = tailNewList.next;
			if (tailNewList.next == null) {
				break;
			} else {
				tailNewList.next = tailNewList.next.next;
			}
			tailNewList = tailNewList.next;
			tailOldList = tailOldList.next;
		}
		tailOldList.next = null;
		tailNewList.next = null;
		return headNewList;
	}
	private static void showListNodeWithSibling (ListNodeWithSibling head) {
		ListNodeWithSibling headTravel = head;
		while (headTravel != null) {
			int data = (headTravel.sibling == null) ? Integer.MIN_VALUE : headTravel.sibling.data;
			System.out.println(headTravel.data + "   " + data);
			headTravel = headTravel.next;
		}
		System.out.println();
	}
}
