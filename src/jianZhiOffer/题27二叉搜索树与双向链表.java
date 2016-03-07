package jianZhiOffer;
/*
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求：不能创建任何新的节点，只能调整树中节点指针的指向
 */
public class 题27二叉搜索树与双向链表 {
	public static void main(String[] args) {
		/*
		 * 				6
		 * 			4       8
		 * 		  3   5   7   9
		 * 
		 * 前序：6, 4, 3, 5, 8, 7, 9
		 * 中序：3, 4, 5, 6, 7, 8, 9  
		 *  
		 */
//		int[] preOrderArray = {6, 4, 3, 5, 8, 7, 9}, inOrderArray = {3, 4, 5, 6, 7, 8, 9 };
		
		/*
		 * 					6
		 *        		  5
		 * 				4
		 * 			  3
		 * 			2
		 * 		  1
		 * 
		 * 前序： 6, 5, 4, 3, 2, 1
		 * 中序： 1, 2, 3, 4, 5, 6
		 */
		int[] preOrderArray = {6, 5, 4, 3, 2, 1}, inOrderArray = {1, 2, 3, 4, 5, 6};
		try {
			BinaryTreeNodeBST root = construct(preOrderArray, inOrderArray);
			BinaryTreeNodeBST listNodeHead = getTheListHead (root);
			while (listNodeHead != null) {
				System.out.print(listNodeHead.data+" ");
				listNodeHead = listNodeHead.right;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static class BinaryTreeNodeBST {
		int data;
		BinaryTreeNodeBST left, right;
		public BinaryTreeNodeBST(int data, BinaryTreeNodeBST left, BinaryTreeNodeBST right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
		public BinaryTreeNodeBST (int data) {
			this(data, null, null);
		}
		public BinaryTreeNodeBST () {
			this(0, null, null);
		}
	}
	private static BinaryTreeNodeBST construct (int[] preOrderArray, int[] inOrderArray) throws Exception{
		if (preOrderArray == null || inOrderArray == null || preOrderArray.length != inOrderArray.length)   return null;
		return constructCore (preOrderArray, 0, preOrderArray.length-1,
	  			                inOrderArray, 0, inOrderArray.length-1);
	}
	private static BinaryTreeNodeBST constructCore (int[] preOrderArray, int preBeginIndex, int preEndIndex, 
			                                          int[] inOrderArray,  int inBeginIndex,  int inEndIndex) throws Exception{
		if (preOrderArray == null || inOrderArray == null || preBeginIndex > preEndIndex || inBeginIndex > inEndIndex)
			return null;
		int rootData = preOrderArray[preBeginIndex];
		BinaryTreeNodeBST root = new BinaryTreeNodeBST(rootData);
		if (preBeginIndex == preEndIndex) {
			if (inBeginIndex == inEndIndex && preOrderArray[preBeginIndex] == inOrderArray[inBeginIndex])
				return root;
			else
				throw new Exception("非法输入");
		}
		int inRootIndex = inBeginIndex;
		while (inRootIndex <= inEndIndex && inOrderArray[inRootIndex] != rootData)
			inRootIndex ++;
		if (inRootIndex == inEndIndex && inOrderArray[inRootIndex] != rootData)
			throw new Exception("非法输入");
		int leftLength = inRootIndex - inBeginIndex;
		int leftPreEndIndex = preBeginIndex + leftLength;
		if (leftLength > 0)
			root.left = constructCore(preOrderArray, preBeginIndex+1, leftPreEndIndex,
									   inOrderArray, inBeginIndex,    inRootIndex -1);
		if (leftLength < preEndIndex - preBeginIndex)
			root.right = constructCore(preOrderArray, leftPreEndIndex+1, preEndIndex,
									    inOrderArray, inRootIndex+1,     inEndIndex);
		return root;
	}
	private static BinaryTreeNodeBST getTheListHead (BinaryTreeNodeBST root) {
		if (root == null)   return null;
		IncludeAnNode ian = new IncludeAnNode();
		BinaryTreeNodeBST travelList = null;
		convertNode (root, ian);
		travelList = ian.node;
		while (travelList != null && travelList.left != null)
			travelList = travelList.left;
		return travelList;
	}
	private static void convertNode (BinaryTreeNodeBST root, IncludeAnNode ian) {
		if (root == null)   return;
		BinaryTreeNodeBST currentNode = root;
		convertNode (root.left, ian);
		currentNode.left = ian.node;
		if (ian.node != null)
			ian.node.right = currentNode;
		ian.node = currentNode;
		convertNode (root.right, ian);
	}
	static class IncludeAnNode {
		BinaryTreeNodeBST node;
	}
 }
