package book.offer;

import java.util.Stack;

public class ��B�������ݹ���ǵݹ� {
	public static void main(String[] args) {
		Node node7 = new Node(7, null, null);
		Node node6 = new Node(6, null, null);
		Node node5 = new Node(5, null, null);
		Node node4 = new Node(4, null, null);
		Node node3 = new Node(3, node6, node7);
		Node node2 = new Node(2, node4, node5);
		Node node1 = new Node(1, node2, node3);
		preOrderRecur(node1);
		System.out.println();
		inOrderRecur(node1);
		System.out.println();
		posOrderRecur(node1);
		System.out.println();
		preOrderUnRecur(node1);
	}
	static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node(int data) {
			this.value = data;
		}
		public Node(int data, Node left, Node right) {
			this.value = data;
			this.left = left;
			this.right = right;
		}
	}
	public static void preOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		System.out.print(head.value + " ");
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}
	public static void inOrderRecur(Node head) {
		if (null == head) {
			return;
		}
		inOrderRecur(head.left);
		System.out.print(head.value+" ");
		inOrderRecur(head.right);
	}
	public static void posOrderRecur(Node head) {
		if (null == head) {
			return;
		}
		System.out.print(head.value+" ");
		posOrderRecur(head.left);
		posOrderRecur(head.right);
	}
	
	/**
	 * 	�÷ǵ��׹�ķ�ʽʵ�ֶ���������������������ǣ�
	 * 	1������һ���µ�ջ����Ϊstack��Ȼ��ͷ���headѹ��stack�С�
	 * 	2����stack�е���ջ���ڵ㣬��Ϊcur��Ȼ���ӡcur�ڵ��ֻ���ٽ��ڵ�cur��
	 * 	�ٽ��ڵ�cur���Һ��ӣ���Ϊ�յĻ�����ѹ��ջstack�У����cur������
	 * 	����Ϊ�յĻ���ѹ��stack�С�
	 * 	3�������ظ�2��֪��stackΪ�գ�ȫ�����̽���
	 */
	public static void preOrderUnRecur(Node head) {
		System.out.print("pre-Order: ");
		if (null != head) {
			Stack<Node> stack = new Stack<Node>();
			stack.add(head);
			while(!stack.isEmpty()) {
				head = stack.pop();
				System.out.print(head.value + " ");
				if (null != head.right) {
					stack.push(head.right);
				}
				if (null != head.left) {
					stack.push(head.left);
				}
			}
		}
		System.out.println();
	}
	public static void inOrderUnRecur(Node head) {
		System.out.print("in-Order: ");
		if (null != head) {
			Stack<Node> stack = new Stack<Node>();
			stack.add(head);
			while(!stack.isEmpty()) {
				head = stack.pop();
				System.out.println(head.value+" ");
				if (null != head.right) {
					stack.push(head.right);
				}
				if (null != head.left) {
					stack.push(head.right);
				}
			}
		}
	}
}
