/*
 ����˫��ѭ������������µ����⣺

�� n ������˳ʱ��վ��һȦ������Ϊ��1��2��3��... n

��1�ź��ӿ�ʼ˳ʱ��������ÿ��������һ����������7�ı����������к���7����ú��Ӳ�������ֻ��һ���֣������ķ�����ת����һ����������һ�����֡�

���磺1,2,3...6,����,���������6�ź�����8��5�ź�����9 ....

��ģ��ù��̣������20�����ӣ����ĸ�����Ҫ��100��
 */

package gaoXiaoBang;

public class �ڶ���˫��ѭ������_ʵ��Ӧ�� {
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
