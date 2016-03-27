package book.offer;

import java.util.Stack;

public class 题B二叉树递归与非递归 {
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
	 * 	用非到底贵的方式实现二叉树的先序遍历，过程是：
	 * 	1，申请一个新的栈，记为stack。然后将头结点head压入stack中。
	 * 	2，从stack中弹出栈顶节点，记为cur，然后打印cur节点的只。再将节点cur的
	 * 	再将节点cur的右孩子（不为空的话）先压入栈stack中，最后将cur的左孩子
	 * 	（不为空的话）压入stack中。
	 * 	3，不断重复2，知道stack为空，全部过程结束
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
