package book.jianZhiOffer;
/*
 * 求深度代码十分简单
 * 拓展：
 * 		输入一个二叉树的根结点，判断该树是不是平衡二叉树。
 * 		如果某二叉树中任意结点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 */
public class 题39二叉树的深度 {
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
		//有缺点：重复判断
		if (root == null)   return true;
		int leftDepth = getDepth (root.left);
		int rightDepth = getDepth (root.right);
		int diff = leftDepth - rightDepth;
		if (diff>1 || diff<-1)
			return false;
		return isBalanceBinaryTree(root.left) && isBalanceBinaryTree(root.right);
	}
	static boolean isBalanceBinaryTreePostOrder (BinaryTreeNode root, DepthStrut depth) {
		//这是后序遍历
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
		//这是对isBalanceBinaryTreePostOrder的部分改动
		//初始的想法是用Integer类来完成传值，但是Integer是无法进行赋值的233333
		//改成默写吧
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