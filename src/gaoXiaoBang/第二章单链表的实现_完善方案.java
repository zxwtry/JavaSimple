package gaoXiaoBang;

/*


 ������ʾ���и������������ǵݹ鶨��ġ�
 �������ĺô��������ĳ���ֲ�Ҳ��һ������
 �����������߼��ϵĸ������һ���ԡ�

������Ч�ʵĿ��ǣ�������Ҫ����һЩ�����������ӿ�������ٶȣ�
��ʱ������ܸ�������������һ����Ǿͺܷ�������Ĵ���

����˼·��

class MyList
{
private Node head;

class Node{
int data;
Node next;
}
....
}

���ַ����У�MyList���ǵݹ鶨��ģ�
���ڲ�������Node��������������ʵ�ṹ��
MyList����һ������ࡣ��ͨ������head ָ������¼һ�������ͷ�����

�������������ַ����� 


 */


public class �ڶ��µ������ʵ��_���Ʒ��� {
	//ʵ��һ�������ɾ������ӷ������������
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
