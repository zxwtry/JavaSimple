package book.jianZhiOffer;

public class 题19二叉树的镜像 {
	public static void main(String[] args) {
		int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
		int[] inOrder  = {4, 7, 2, 1, 5, 3, 8, 6};
		//post            7 4 2 5 8 6 3 1 
		try {
			BinaryTreeNode root = construct(preOrder, 0, preOrder.length-1,
											inOrder,  0, inOrder.length -1);
			printPreOrder(root);
			System.out.println();
			printInOrder(root);
			System.out.println();
			printInOrder2(root);
			printPostOrder(root);
			System.out.println();
			printLayer(root);
			mirrorRecursively(root);
			printInOrder(root);
			System.out.println();
			travelLayer(root);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	static class BinaryTreeNode {
		int data;
		BinaryTreeNode left, right;
		public BinaryTreeNode (int data) {
			this.data = data;
			left = right = null;
		}
		public BinaryTreeNode () {}
	}
	private static void mirrorRecursively (BinaryTreeNode head) {
		if (head == null || (head.left == null && head.right == null))
			return;
		BinaryTreeNode leftTemp = head.left;
		head.left = head.right;
		head.right = leftTemp;
		mirrorRecursively(head.left);
		mirrorRecursively(head.right);
	}
	private static BinaryTreeNode construct(int[] preOrder, int preBeginIndex, int preEndIndex,
											  int[] inOrder,  int inBeginIndex, int inEndIndex)  throws Exception{
		if (preOrder == null || inOrder == null || preOrder.length != inOrder.length 
				|| preBeginIndex > preEndIndex || inBeginIndex > inEndIndex)
			throw new Exception(String.format("非法输入%d %d %d %d", preBeginIndex, preEndIndex, inBeginIndex, inEndIndex));
		if (preBeginIndex == preEndIndex) {
			if (inBeginIndex == inEndIndex && preOrder[preBeginIndex] == inOrder[inBeginIndex]) {
				return new BinaryTreeNode(preOrder[preBeginIndex]);
			} else {
				throw new Exception("非法输入");
			}
		}
		int rootData = preOrder[preBeginIndex];
		int inRootIndex = inBeginIndex;
		while (inRootIndex <= inEndIndex && inOrder[inRootIndex] != rootData)
			inRootIndex ++;
		if (inRootIndex == inEndIndex && inOrder[inEndIndex] != rootData)
			throw new Exception("非法输入");
		int leftLength = inRootIndex - inBeginIndex;
		int leftPreEndIndex = preBeginIndex + leftLength;
		BinaryTreeNode root = new BinaryTreeNode(rootData);
		if (leftLength > 0) {
			root.left = construct(preOrder, preBeginIndex+1, leftPreEndIndex,
								  inOrder,  inBeginIndex, inRootIndex-1);
		}
		if (preEndIndex - preBeginIndex > leftLength) {
			root.right = construct(preOrder, leftPreEndIndex+1, preEndIndex,
								  inOrder,  inRootIndex+1, inEndIndex);
		}
		return root;
	}
	private static void printPreOrder(BinaryTreeNode root) {
		if (root == null)   return;
		System.out.printf("%d ", root.data);
		printPreOrder(root.left);
		printPreOrder(root.right);
	}
	private static void printInOrder (BinaryTreeNode root) {
		if (root == null)   return;
		printInOrder(root.left);
		System.out.printf("%d ", root.data);
		printInOrder(root.right);
	}
	private static void printPostOrder (BinaryTreeNode root) {
		if (root == null)   return;
		printPostOrder(root.left);
		printPostOrder(root.right);
		System.out.printf("%d ", root.data);
	}
	private static void printLayer (BinaryTreeNode root) {
		java.util.Queue<BinaryTreeNode> queue = new java.util.ArrayDeque<BinaryTreeNode>();
		queue.add(root);
		BinaryTreeNode tmp;
		while (!queue.isEmpty()) {
			tmp = queue.poll();
			System.out.printf("%d ", tmp.data);
			if (tmp.left != null)
				queue.add(tmp.left);
			if (tmp.right != null)
				queue.add(tmp.right);
		}
		System.out.println();
	}
	private static void travelLayer (BinaryTreeNode root) {
		if (root == null)   return;
		java.util.Queue<BinaryTreeNode> que = new java.util.ArrayDeque<BinaryTreeNode> ();
		que.add(root);
		BinaryTreeNode tmp;
		while (!que.isEmpty()) {
			tmp = que.poll();
			System.out.printf("%d ", tmp.data);
			if (tmp.left != null)
				que.add(tmp.left);
			if (tmp.right != null)
				que.add(tmp.right);
		}
	}
	private static void printInOrder2(BinaryTreeNode root) {
		java.util.Stack<BinaryTreeNode> stk = new java.util.Stack<BinaryTreeNode>();
		BinaryTreeNode tmp = root;
		while (tmp != null || !stk.isEmpty()) {
			if (tmp != null) {
				stk.add(tmp);
				tmp = tmp.left;
			} else {
				tmp = stk.pop();
				System.out.printf("%d ", tmp.data);
				tmp = tmp.right;
			}
		}
		System.out.println();
	}
}