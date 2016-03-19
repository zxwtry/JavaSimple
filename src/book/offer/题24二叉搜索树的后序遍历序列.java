package book.offer;

public class ��24�����������ĺ���������� {
	public static void main(String[] args) {
//		Integer[] stepEntryArray = {1,2,3,4,5};
//		Integer[] stepEntryArray = {3,2,1,4,5};
		Integer[] stepEntryArray = {8,10,6,4,5,7,9,11};
		BinaryTreeNode<Integer> root = constructBST(stepEntryArray);
		travelPreOrder(root);
		System.out.println();
		travelInOrder(root);
		System.out.println();
		travelPostOrder(root);
		System.out.println();
		
		System.out.print("��һ���������ǲ��Ƕ�����������  ");
		System.out.println(isAnBST(root));
		
		//�������Ƕ������һ����������жϣ������ɲ����ܶ���һ�������������ĺ������
//		stepEntryArray = new Integer[]{5,7,6,9,11,10,8};
//		stepEntryArray = new Integer[]{7,4,6,5};
//		stepEntryArray = new Integer[]{1,2,5,4,3};
//		stepEntryArray = new Integer[]{5,4,3,2,1};
		stepEntryArray = new Integer[]{5,4,7,6,9,11,8,10};
		System.out.print("��һ������������ǲ���һ�������������ĺ��������   ");
		System.out.println(isPostOrderOfBST(stepEntryArray, 0, stepEntryArray.length-1));
		
	}
	static class BinaryTreeNode <T extends Comparable <? super T>>{
		T data;
		BinaryTreeNode<T> left, right;
		public BinaryTreeNode () {}
		public BinaryTreeNode (T data) {
			this.data = data;
			left = right = null;
		}
	}
	private static <T extends Comparable <? super T>> BinaryTreeNode<T> constructBST (T[] stepEntryArray) {
		if (stepEntryArray == null)   return null;
		BinaryTreeNode<T> root = new BinaryTreeNode<T>(stepEntryArray[0]);
		for (int i = 1;i < stepEntryArray.length; ++ i) {
			constructBSTCore(root, stepEntryArray[i]);
		}
		return root;
	}
	private static <T extends Comparable <? super T>> void constructBSTCore (BinaryTreeNode<T> root, T stepData) {
		if (root == null)   return;
		if (root.data.compareTo(stepData) > 0) {
			if (root.left == null)
				root.left = new BinaryTreeNode<T>(stepData);
			else
				constructBSTCore(root.left, stepData);
		} else if (root.data.compareTo(stepData) < 0) {
			if (root.right == null)
				root.right = new BinaryTreeNode<T>(stepData);
			else
				constructBSTCore(root.right, stepData);
		}
	}
	private static <T extends Comparable <? super T>> void travelPreOrder (BinaryTreeNode<T> root) {
		if (root == null)   return;
		System.out.print(String.valueOf(root.data) + ",");
		travelPreOrder(root.left);
		travelPreOrder(root.right);
	}
	private static <T extends Comparable <? super T>> void travelInOrder (BinaryTreeNode<T> root) {
		if (root == null)   return;
		travelInOrder(root.left);
		System.out.print(String.valueOf(root.data)+",");
		travelInOrder(root.right);
	}
	private static <T extends Comparable <? super T>> void travelPostOrder (BinaryTreeNode<T> root) {
		if (root == null)   return;
		travelPostOrder(root.left);
		travelPostOrder(root.right);
		System.out.print(String.valueOf(root.data) +  ",");
	}
	private static <T extends Comparable <? super T>> boolean isAnBST (BinaryTreeNode<T> root) {
		if (root == null)   return false;
		if (root.left != null) {
			if (root.right != null) {
				//������������Ϊ��
				if (root.right.data.compareTo(root.data) > 0 && root.left.data.compareTo(root.data) < 0)
					return isAnBST (root.left) && isAnBST(root.right);
				else return false;
			} else {
				//���������գ���������
				if (root.left.data.compareTo(root.data) < 0)
					return isAnBST (root.left);
				else
					return false;
			}
		} else {
			if (root.right == null) {
				//�����������������ǿ�
				return true;
			} else {
				//�������գ�����������
				if (root.right.data.compareTo(root.data) > 0)
					return isAnBST(root.right);
				else
					return false;
			}
		}
	}
	private static <T extends Comparable <? super T>> boolean isPostOrderOfBST (T[] postOrderArray, int beginIndex, int endIndex) {
		if (postOrderArray == null || beginIndex > endIndex)   return false;
		if (endIndex-beginIndex <= 1)   return true;
		T rootData = postOrderArray[endIndex];
		int splitIndex = beginIndex;
		while (splitIndex < endIndex && postOrderArray[splitIndex].compareTo(rootData) < 0) {
			splitIndex ++;
		}
		for (int i = splitIndex; i< endIndex; i ++) {
			if (postOrderArray[i].compareTo(rootData) < 0)
				return false;
		}
		boolean leftIsPostOrderOfBST = true, rightIsPostOrderOfBST = true;
		if (splitIndex > beginIndex)
			leftIsPostOrderOfBST = isPostOrderOfBST(postOrderArray, beginIndex, splitIndex-1);
		if (splitIndex < endIndex)
			rightIsPostOrderOfBST = isPostOrderOfBST(postOrderArray, splitIndex, endIndex -1);
		return leftIsPostOrderOfBST && rightIsPostOrderOfBST;
	}
}
