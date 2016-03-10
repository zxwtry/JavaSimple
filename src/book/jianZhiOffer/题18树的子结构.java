package book.jianZhiOffer;
/*
 * 输入两颗二叉树A和B，判断B是不是A的子结构
 */
public class 题18树的子结构 {
	public static void main(String[] args) throws Exception{
		BinaryNode tree1 = construct(new int[]{6,8,9,2,4,7,0}, new int[]{9,8,4,2,7,6,0});
		BinaryNode tree2 = construct(new int[]{8,9,2}, new int[]{9,8,2});
		System.out.println(hasSubTree(tree1, tree2));
	}
	static class BinaryNode {
		int data;
		BinaryNode left, right;
		public BinaryNode (int data) {
			this.data = data;
			left = right = null;
		}
		public BinaryNode (int data, BinaryNode left, BinaryNode right) {
			this.data = data;
			this.right = right;
			this.left = left;
		}
	}
	private static boolean hasSubTree (BinaryNode tree1, BinaryNode tree2) {
		boolean result = false;
		if (tree1 != null && tree2 != null) {
			if (tree1.data == tree2.data) 
				result = isTheSubTreeFit (tree1, tree2);
			if (!result)
				result = hasSubTree (tree1.left, tree2);
			if (!result)
				result = hasSubTree(tree1.right, tree2);
		}
		return result;
	}
	private static boolean isTheSubTreeFit (BinaryNode tree1, BinaryNode tree2) {
		if (tree2 == null)
			return true;
		if (tree1 == null)
			return false;
		if (tree1.data != tree2.data)
			return false;
		return isTheSubTreeFit(tree1.left, tree2.left) && isTheSubTreeFit(tree1.right, tree2.right);
	}
	private static BinaryNode construct (int[] preOrder, int[] inOrder) throws Exception{
		if (preOrder == null || inOrder == null || preOrder.length != inOrder.length)
			throw new Exception("输入有误");
		return constructCore (preOrder , 0 , preOrder.length-1,
							   inOrder,   0 , inOrder.length-1);
	}
	private static BinaryNode constructCore (
			int[] preOrder, int preBeginIndex, int preEndIndex,
			int[] inOrder,  int inBeginIndex,  int inEndIndex
			) throws Exception {
		if (preBeginIndex > preEndIndex || inBeginIndex > inEndIndex)
			throw new Exception("输入有误");
		if (preBeginIndex == preEndIndex) {
			if (inBeginIndex == inEndIndex && preOrder[preBeginIndex] == inOrder[inBeginIndex])
				return new BinaryNode(preOrder[preBeginIndex]);
			else 
				throw new Exception("输入有误");
		}
		int rootData = preOrder[preBeginIndex];
		BinaryNode root = new BinaryNode(rootData);
		int inRootIndex = inBeginIndex;
		while (inOrder[inRootIndex] != rootData && inRootIndex <= inEndIndex) {
			inRootIndex ++;
		}
		if (inRootIndex == inEndIndex && inOrder[inEndIndex] != rootData) {
			return null;
		}
		int leftLength = inRootIndex-inBeginIndex;
		int leftPreEndIndex = preBeginIndex + leftLength;
		root.left = constructCore(preOrder, preBeginIndex+1, leftPreEndIndex, 
								  inOrder , inBeginIndex,    inRootIndex-1);
		root.right = constructCore(preOrder, leftPreEndIndex+1, preEndIndex,
								   inOrder, inRootIndex+1,   inEndIndex);
		return root;
	}
}
