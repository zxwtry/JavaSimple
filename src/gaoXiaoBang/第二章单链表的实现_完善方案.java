package gaoXiaoBang;

/*


 我们在示例中给出的链表类是递归定义的。
 这样做的好处是链表的某个局部也是一个链表，
 这与链表在逻辑上的概念具有一致性。

但出于效率的考虑，经常需要引入一些辅助变量来加快操作的速度，
这时，如果能给链表类型增加一个外壳就很方便后续的处理。

基本思路：

class MyList
{
private Node head;

class Node{
int data;
Node next;
}
....
}

这种方案中，MyList不是递归定义的，
而内部包含的Node类代表了链表的真实结构。
MyList类是一个外壳类。它通过持有head 指针来记录一个链表的头在哪里。

请试着完善这种方案。 


 */


public class 第二章单链表的实现_完善方案 {
	//实现一个链表的删除，添加方法，输出链表
	public static void main(String[] args) {
		MyList myList = new MyList();
		myList.addAnElementToList(0);
		myList.addAnElementToList(1);
		myList.addAnElementToList(2);
		myList.addAnElementToList(3);
		myList.addAnElementToList(-2);
		myList.addAnElementToList(-4);
		myList.addAnElementToList(-5);
		myList.addAnElementToList(-3);
		
		myList.showAllElementInList();
		
		myList.deleteAnElementAtIndex(0);
		myList.deleteAnElementAtIndex(4);
		myList.showAllElementInList();
		
		myList.deleteAnElementAtIndex(100);
	}
	
	static class MyList {
		private static MyNode head;
		private static MyNode tail;
		static class MyNode {
			int data;
			MyNode next;
			public MyNode () {}
			public MyNode (int data) {
				this.data = data;
			}
		}
		public void addAnElementToList (int data) {
			if (head == null) {
				tail = head = new MyNode(data);
				return;
			}
			MyNode dataTempNode = new MyNode(data);
			tail.next = dataTempNode;
			tail = tail.next;
		}
		public void deleteAnElementAtIndex (int index) {
			if (index < 0) {
				throw new IndexOutOfBoundsException(String.valueOf(index));
			}
			if (index == 0) {
				head = head.next;
				return;
			}
			MyNode headIndexTemp = head;
			int headIndexCount = 0;
			while (headIndexTemp != null) {
				if (index-1 == headIndexCount) {
					if (headIndexTemp.next != null)
						headIndexTemp.next = headIndexTemp.next.next;
					else
						headIndexTemp = null;
				}
				headIndexCount ++;
				headIndexTemp = headIndexTemp.next;
			}
			throw new IndexOutOfBoundsException(String.valueOf(index));
		}
		public void showAllElementInList() {
			MyNode headIndexTemp = head;
			while (headIndexTemp != null) {
				System.out.print(headIndexTemp.data + " ");
				headIndexTemp = headIndexTemp.next;
			}
			System.out.println();
		}
	}
}
