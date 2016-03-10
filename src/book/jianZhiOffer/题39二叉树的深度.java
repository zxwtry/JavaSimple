package book.jianZhiOffer;
/*
 * ����ȴ���ʮ�ּ�
 * ��չ��
 * 		����һ���������ĸ���㣬�жϸ����ǲ���ƽ���������
 * 		���ĳ����������������������������������1����ô������һ��ƽ���������
 */
public class ��39����������� {
	public static void main(String[] args) {
		BinaryTreeNode node4 = new BinaryTreeNode(4);
		BinaryTreeNode node3 = new BinaryTreeNode(3, node4, null);
		BinaryTreeNode node2 = new BinaryTreeNode(2, node3, null);
		BinaryTreeNode node1 = new BinaryTreeNode(1, node2, null);
		System.out.println(getDepth(node1));
		BinaryTreeNode tmp = node4;
		System.out.println(getDepth(tmp));
		System.out.println(isBalanceBinaryTree(tmp));
		System.out.println(isBalanceBinaryTreePostOrder(tmp, new DepthStrut(0)));
		System.out.println(isBalanceBinaryTreePostOrder2(tmp, new DepthStrut(0)));
		System.out.println(isBalanceBinaryTreePostOrder3(tmp, new DepthStrut(0)));
	}
	static class BinaryTreeNode {
		int data;
		BinaryTreeNode left, right;
		public BinaryTreeNode (int data, BinaryTreeNode left, BinaryTreeNode right) {
			this.data = data;
			this.right = right;
			this.left = left;
		}
		public BinaryTreeNode (int data) {
			this(data, null, null);
		}
		public BinaryTreeNode () {
			this(Integer.MIN_VALUE, null, null);
		}
	}
	static int getDepth (BinaryTreeNode root) {
		if (root == null)   return 0;
		int leftDepth = getDepth(root.left);
		int rightDepth = getDepth(root.right);
		return (leftDepth>rightDepth ? leftDepth+1 : rightDepth+1);
	}
	static boolean isBalanceBinaryTree (BinaryTreeNode root) {
		//��ȱ�㣺�ظ��ж�
		if (root == null)   return true;
		int leftDepth = getDepth (root.left);
		int rightDepth = getDepth (root.right);
		int diff = leftDepth - rightDepth;
		if (diff>1 || diff<-1)
			return false;
		return isBalanceBinaryTree(root.left) && isBalanceBinaryTree(root.right);
	}
	static boolean isBalanceBinaryTreePostOrder (BinaryTreeNode root, DepthStrut depth) {
		//���Ǻ������
		if (root == null) {
			depth.depth = 0;
			return true;
		}
		DepthStrut leftDepth = new DepthStrut(), rightDepth = new DepthStrut();
		if (isBalanceBinaryTreePostOrder(root.left, leftDepth) && 
				isBalanceBinaryTreePostOrder(root.right, rightDepth)) {
			int diff = leftDepth.depth - rightDepth.depth;
			if (diff>=-1 && diff<=1) {
				depth.depth = 1 + (leftDepth.depth>rightDepth.depth
						? leftDepth.depth : rightDepth.depth);
				return true;
			}
		}
		return false;
	}
	static boolean isBalanceBinaryTreePostOrder2 (BinaryTreeNode root, DepthStrut depth) {
		//���Ƕ�isBalanceBinaryTreePostOrder�Ĳ��ָĶ�
		//��ʼ���뷨����Integer������ɴ�ֵ������Integer���޷����и�ֵ��233333
		//�ĳ�Ĭд��
		if (root == null) {
			depth.depth = 0;
			return true;
		}
		DepthStrut leftDepth = new DepthStrut(), rightDepth = new DepthStrut();
		if (isBalanceBinaryTreePostOrder2(root.left, leftDepth) && isBalanceBinaryTreePostOrder2(root.right, rightDepth)) {
			int diff = leftDepth.depth - rightDepth.depth;
			if (diff<=1 && diff>=-1) {
				depth.depth = 1 + Math.max(rightDepth.depth, leftDepth.depth);
				return true;
			}
		}
		return false;
	}
	private static boolean isBalanceBinaryTreePostOrder3 (BinaryTreeNode root, DepthStrut depth) {
		if (root == null) {
			depth.depth = 0;
			return true;
		}
		DepthStrut leftDepth = new DepthStrut(), rightDepth = new DepthStrut();
		if (isBalanceBinaryTreePostOrder3(root.left, leftDepth) && isBalanceBinaryTreePostOrder3(root.right, rightDepth)) {
			int diff = leftDepth.depth - rightDepth.depth;
			if (diff>=-1 && diff<=1) {
				depth.depth = 1 + Math.max(leftDepth.depth, rightDepth.depth);
				return true;
			}
		}
		return false;
	}
	static class DepthStrut {
		int depth;
		public DepthStrut (int depth) {
			this.depth = depth;
		}
		public DepthStrut () {
			this(Integer.MIN_VALUE);
		}
	}
}