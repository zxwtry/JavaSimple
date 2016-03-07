/*
如果定义一棵二叉树的高度就是从根到叶子的最长距离。试编码求二叉树的高度。
其实，二叉树的高度就是它的左子树和右子树中高度最大值 + 1
另外考虑: 当待排序的数据本来就是有序的情况，会发生什么？
请参考《数据结构》教材解决这个问题。
 */
/*
 * 当待排序的数据本来就是有序的情况
 * 答:在这个图中,可以看到是层序排列.这种顺序排列在以迭代为主的方法中体现不明显.
 * 可以看到,查找深度的方法是以先序进行,如果储存也是先序,那么是以排好序的方式进行访问.
 */

/*
 *     1
 *   2   3
 *  4 5 6
 * 7
 */


package gaoXiaoBang;

public class 第二章二叉排序树_求二叉树的高度 {
	public static void main(String[] args) {
		BinaryTree<Integer> bi = new BinaryTree<Integer>();
		BinaryNode<Integer> root1 = bi.insert(1);
		BinaryNode<Integer> root2 = bi.insert(root1, 2, true);
		BinaryNode<Integer> root3 = bi.insert(root1, 3, false);
		BinaryNode<Integer> root4 = bi.insert(root2, 4, true);
		BinaryNode<Integer> root5 = bi.insert(root2, 5, false);
		BinaryNode<Integer> root6 = bi.insert(root3, 6, true);
		BinaryNode<Integer> root7 = bi.insert(root4, 7, true);
		System.out.println(bi.getTheDepth());
		if (root5 == null) {}
		if (root6 == null) {}
		if (root7 == null) {}
	}
	static class BinaryTree <T> {
		public BinaryNode <T> root;
		public BinaryTree() {
			this.root = null;
		}
		public boolean isEmpty() {
			return this.root == null;
		}
		public BinaryNode <T> insert(T t) {
			return this.root = new BinaryNode <T> (t,this.root,null);
		}
		public BinaryNode <T> insert(BinaryNode<T> parent, T t, boolean isLeftChild) {
			if (t == null) 	return null;
			if (isLeftChild) 	return parent.left = new BinaryNode <T> (t,parent.left,null);
			return parent.right = new BinaryNode <T> (t,null,parent.right);
		}
		public int getTheDepth() {
			return getTheDepth(this.root);
		}
		private int getTheDepth(BinaryNode<T> p) {
			if (p != null) {
				int tmp1 = getTheDepth(p.left);
				int tmp2 = getTheDepth(p.right);
				return (tmp1 > tmp2 ? tmp1+1 : tmp2 + 1);
			} else return 0;
		}
	}
	static class BinaryNode <T> {
		public T data;
		public BinaryNode<T> left,right;
		public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
		public BinaryNode(T data) {
			this(data,null,null);
		}
		public String toString() {
			return this.data.toString();
		}
		public boolean isLeaf() {
			return this.left == null && this.right == null;
		}
	}
}
