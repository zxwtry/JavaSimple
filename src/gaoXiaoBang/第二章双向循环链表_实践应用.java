/*
 定义双向循环链表，解决如下的问题：

有 n 个孩子顺时针站成一圈，其编号为：1，2，3，... n

从1号孩子开始顺时针数数，每个孩子数一个数，遇到7的倍数或数字中含有7，则该孩子不出声，只拍一下手，数数的方向逆转，下一个孩子数下一个数字。

例如：1,2,3...6,拍手,则接下来，6号孩子数8，5号孩子数9 ....

请模拟该过程，如果有20个孩子，求哪个孩子要数100。
 */

package gaoXiaoBang;

public class 第二章双向循环链表_实践应用 {
	public static void main(String[] args) {
		ListMY list = new ListMY();
		for (int i = 1; i < 20; i ++) {
			list.add(i, false);
		}
		list.add(20, true);
		list.query();
		System.out.println(list.find(100,7));
	}
	private static class ListMY{
		Node head,tail;
		public ListMY() {
			head = null;
			tail = null;
		}
		class Node{
			int data;
			Node pre;
			Node next;
			public Node(int data) {
				this.data = data;
			}
		}
		class Node_For{
			Node node;
			boolean isPlus;
			public Node_For() {
			}
		}
		public void add(int data , boolean isLastOne) {
			Node node = new Node(data);
			if (head == null) {
				tail = node;
				head = node;
				return;
			}
			node.pre = tail;
			if (isLastOne) {
				head.pre = node;
				node.next = head;
				tail.next = node;
			} else {
				tail.next = node;
				tail = node;
			}
		}
		public int find(int position, int findPoint) {
			Node_For tmp_for = new Node_For();
			tmp_for.node = head;
			tmp_for.isPlus = true;
//			int all = 1;
//			Node tmp = head.next;
//			while (tmp != head) {
//				tmp = tmp.next;
//				all ++;
//			}
			while (--position > 0) {
//				if (position%10 != 0)
//					System.out.print(position+"$"+tmp_for.node.data+"\t");
//				else
//					System.out.println(position+"$"+tmp_for.node.data+"\t");
				tmp_for = Node_next(tmp_for,findPoint);
			}
			return tmp_for.node.data;
		}
		private Node_For Node_next(Node_For node, int findPoint) {
			Node_For tmp = new Node_For();
			if (node.node.data%findPoint == 0 || node.node.data%10 == findPoint) {
				if (node.isPlus) {
					tmp.node = node.node.pre;
					tmp.isPlus = false;
				} else {
					tmp.node = node.node.next;
					tmp.isPlus = true;
				}
			} else {
				tmp.isPlus = node.isPlus;
				tmp.node = (node.isPlus == true ? node.node.next : node.node.pre);
			}
			return tmp;
		}
		public void query () {
			Node tmp = head;
			int count = 0;
			while (true) {
				count ++;
				if (count % 10 ==0)
					System.out.println(tmp.data);
				else
					System.out.print(tmp.data+"forw\t");
				tmp = tmp.next;
				if (count == 50) {
					break;
				}
			}
			tmp = head;
			count = 0;
			while (true) {
				count ++;
				if (count % 10 ==0)
					System.out.println(tmp.data);
				else
					System.out.print(tmp.data+"back\t");
				tmp = tmp.pre;
				if (count == 50) {
					break;
				}
			}
		}
	}
}
