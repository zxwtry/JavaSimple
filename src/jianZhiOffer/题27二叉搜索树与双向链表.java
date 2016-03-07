package jianZhiOffer;
/*
 * ����һ�ö��������������ö���������ת����һ�������˫������
 * Ҫ�󣺲��ܴ����κ��µĽڵ㣬ֻ�ܵ������нڵ�ָ���ָ��
 */
public class ��27������������˫������ {
	public static void main(String[] args) {
		/*
		 * 				6
		 * 			4       8
		 * 		  3   5   7   9
		 * ǰ��6, 4, 3, 5, 8, 7, 9
		 * ����3, 4, 5, 6, 7, 8, 9   
		 */
		int[] preOrderArray = {6, 4, 3, 5, 8, 7, 9}, inOrderArray = {3, 4, 5, 6, 7, 8, 9 };
		try {
			BinaryTreeNodeBST root = construct(preOrderArray, inOrderArray);
			
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
				throw new Exception("�Ƿ�����");
		}
		int inRootIndex = inBeginIndex;
		while (inRootIndex <= inEndIndex && inOrderArray[inRootIndex] != rootData)
			inRootIndex ++;
		if (inRootIndex == inEndIndex && inOrderArray[inRootIndex] != rootData)
			throw new Exception("�Ƿ�����");
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
	
}
