package jianZhiOffer;

public class 题06重建二叉树 {
	static class Node {
		int data;
		Node left, right;
	}
	private static Node construct (int[] preOrder, int[] inOrder, int length) throws Exception {
		if (preOrder == null || inOrder == null || length <= 0)
			return null;
		return constructCore(preOrder, 0, length-1, inOrder, 0, length-1);
	}
	private static Node constructCore(int[] preOrder, int preBeginIndex, int preEndIndex,
										int[] inOrder, int inBeginIndex, int inEndIndex) throws Exception {
		//前序遍历序列的第一个数字是根节点的值
		int rootData = preOrder[preBeginIndex];
		Node root = new Node ();
		root.data = rootData;
		root.left = root.right = null;
		if (preBeginIndex == preEndIndex) {
			if (inBeginIndex == inEndIndex && preOrder[preBeginIndex] == inOrder[inBeginIndex]) {
				return root;
			} else {
				throw new Exception("Invalid input");
			}
		}
		//在中序遍历中找到根节点的值
		int rootInOrderIndex = inBeginIndex;
		while (rootInOrderIndex <= inEndIndex && inOrder[rootInOrderIndex] != rootData)
			++ rootInOrderIndex;
		if (rootInOrderIndex == inEndIndex && inOrder[rootInOrderIndex] != rootData)
			throw new Exception("Invalid input");
		int leftLength = rootInOrderIndex - inBeginIndex;
		int leftPreEndIndex = preBeginIndex + leftLength;
		if (leftLength > 0) {
			//构建左子树
			root.left = constructCore(preOrder, preBeginIndex+1, leftPreEndIndex,
									inOrder, inBeginIndex, rootInOrderIndex-1);
		}
		if (leftLength < preEndIndex - preBeginIndex) {
			root.right = constructCore(preOrder, leftPreEndIndex+1, preEndIndex,
									inOrder, rootInOrderIndex+1, inEndIndex);
		}
		return root;
	}
	private static void travel (Node root) {
		if (root == null)
			return;
		travel(root.left);
		System.out.printf("%d ", root.data);
		travel(root.right);
		
	}
	public static void main(String[] args) throws Exception {
		int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
		int[] inOrder  = {4, 7, 2, 1, 5, 3, 8, 6};
		Node root = construct(preOrder, inOrder, preOrder.length);
		travel(root);
	}
}
