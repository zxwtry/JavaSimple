package book.jianZhiOffer;

import java.util.Iterator;

public class 题25二叉树中和为某一值的路径 {
	private static int expectedSum, currentSum;
	public static void main(String[] args) {
		BinaryTreeNode left = new BinaryTreeNode (5, new BinaryTreeNode(4), new BinaryTreeNode(7));
		BinaryTreeNode root = new BinaryTreeNode (10, left, new BinaryTreeNode(12));
		expectedSum = 19; 
		findPath(root);
		findPath2(root);
	}
	static class BinaryTreeNode {
		int data;
		BinaryTreeNode left, right;
		public BinaryTreeNode ( ) {}
		public BinaryTreeNode (int data) {
			this.data = data;
			left = right = null;
		}
		public BinaryTreeNode (int data, BinaryTreeNode left, BinaryTreeNode right ) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	private static void findPath (BinaryTreeNode root) {
		if (root == null)   return;
		java.util.Stack<Integer> stk = new java.util.Stack<Integer>();
		findPath(root, stk);
	}
	private static void findPath (BinaryTreeNode root, java.util.Stack<Integer> stk) {
		currentSum += root.data;
		stk.push(root.data);
		boolean isLeaf = root.left == null && root.right == null;
		if (currentSum == expectedSum && isLeaf) {
			System.out.print("找到一条路径：");
			Iterator<Integer> it = stk.iterator();
			while (it.hasNext())
				System.out.print("\t"+it.next());
			System.out.println();
		}
		//如果不是叶子节点，则遍历它的子节点
		if (!isLeaf && root.left != null)
			findPath(root.left, stk);
		if (!isLeaf && root.right != null)
			findPath(root.right, stk);
		//返回父节点之前，在路径上删除当前的节点
		currentSum -= root.data;
		stk.pop();
	}
	private static void findPath2(BinaryTreeNode root) {
		if (root == null)   return;
		java.util.Stack<Integer> stk = new java.util.Stack<Integer>();
		currentSum = 0;
		findPath2(root, stk);
	}
	private static void findPath2(BinaryTreeNode root, java.util.Stack<Integer> stk) {
		currentSum += root.data;
		stk.push(root.data);
		boolean isLeaf = root.right == null && root.left == null;
		if (currentSum == expectedSum) {
			Iterator<Integer> it = stk.iterator();
			System.out.print("找到二条路径:");
			while (it.hasNext()) {
				System.out.print("\t"+it.next());
			}
			System.out.println();
		}
		if (!isLeaf && root.left != null)
			findPath2(root.left, stk);
		if (!isLeaf && root.right != null)
			findPath2(root.right, stk);
		currentSum -= root.data;
		stk.pop();
	}
}