package book.offer;
/*
 * 先输入前序和中序的数据
 * 然后再从上往下打印二叉树
 */
public class 题23从上往下打印二叉树 {
	public static void main(String[] args) {
//		int[] preOrder = {1,2,3}, inOrder = {3,2,1};
//		int[] preOrder = {1,2,3}, inOrder = {1,2,3};
		int[] preOrder = {1,2,4,8,5,9,3,6,10,7,11}, inOrder = {8,4,2,5,9,1,10,6,3,7,11};
		try {
			BinaryTreeNode root = construct (
					preOrder, 0 , preOrder.length-1,
					inOrder,  0 , inOrder.length-1
					);
			travelPreOrder(root);
			System.out.println();
			travelInOrder(root);
			System.out.println();
			travelPostOrder(root);
			System.out.println();
			travelLayer(root);
			
		} catch (Exception e) {
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
	}
	private static BinaryTreeNode construct (int[] preOrder, int preBeginIndex,   int preEndIndex,
											   int[] inOrder, int inBeginIndex,    int inEndIndex) throws Exception{
		if (preOrder == null || inOrder == null || preBeginIndex > preEndIndex || inBeginIndex > inEndIndex)
			return null;
		BinaryTreeNode root = new BinaryTreeNode(preOrder[preBeginIndex]);
		if (preBeginIndex == preEndIndex) {
			if (inBeginIndex == inEndIndex && preOrder[preBeginIndex] == inOrder[inBeginIndex])
				return root;
			else 
				throw new Exception("非法输入");
		}
		int rootData = preOrder[preBeginIndex];
		int inRootIndex = inBeginIndex;
		while (inRootIndex <= inEndIndex) {
			if (inOrder[inRootIndex] == rootData)
				break;
			inRootIndex ++;
		}
		if (inRootIndex > inEndIndex)
			throw new Exception("非法输入");
		else if (inRootIndex == inEndIndex) {
			if (inOrder[inRootIndex] != rootData)
				throw new Exception("非法输入");
		}
		int leftLength = inRootIndex - inBeginIndex;
		int leftPreEndIndex = preBeginIndex + leftLength;
		if (leftLength > 0)
			root.left = construct (preOrder, preBeginIndex+1, leftPreEndIndex,
								    inOrder, inBeginIndex,    inRootIndex-1);
		if (leftLength < preEndIndex - preBeginIndex)
			root.right = construct (preOrder, leftPreEndIndex+1, preEndIndex, 
									inOrder,  inRootIndex+1,     inEndIndex);
		return root;
	}
	private static void travelPreOrder (BinaryTreeNode root) {
		if (root == null)   return;
		System.out.printf("%d ", root.data);
		travelPreOrder(root.left);
		travelPreOrder(root.right);
	}
	private static void travelInOrder (BinaryTreeNode root) {
		if (root == null)   return;
		travelInOrder(root.left);
		System.out.printf("%d ", root.data);
		travelInOrder(root.right);
	}
	private static void travelPostOrder (BinaryTreeNode root) {
		if (root == null)   return;
		travelPostOrder(root.left);
		travelPostOrder(root.right);
		System.out.printf("%d ", root.data);
	}
	private static void travelLayer (BinaryTreeNode root) {
		if (root == null)   return;
		java.util.Queue<BinaryTreeNode> mq = new java.util.ArrayDeque<BinaryTreeNode>();
		mq.add(root);
		BinaryTreeNode tmp;
		while (!mq.isEmpty()) {
			tmp = mq.poll();
			System.out.print(tmp.data + " ");
			if (tmp.left != null)
				mq.add(tmp.left);
			if (tmp.right != null)
				mq.add(tmp.right);
		}
		System.out.println();
	}
}