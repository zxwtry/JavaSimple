/*
如果定义一棵二叉树的高度就是从根到叶子的最长距离。试编码求二叉树的高度。
其实，二叉树的高度就是它的左子树和右子树中高度最大值 + 1
另外考虑: 当待排序的数据本来就是有序的情况，会发生什么？
请参考《数据结构》教材解决这个问题。
 */
/*
 * 当待排序的数据本来就是有序的情况
 * 答:输入多少个数字那么,深度就是多少即数字的总数。
 */

/*
 *     6
 *   4   9
 *  2 5 8
 * 1
 * 输入的顺序是:6 4 2 1 5 9 8
 */


package gaoXiaoBang;

public class 第二章二叉排序树_求二叉树的高度2 {
	public static void main(String[] args) {
		Tree tree = new Tree();
//		tree.add(6);
//		tree.add(4);tree.add(2);tree.add(1);
//		tree.add(5);tree.add(9);tree.add(8);
		for (int i = 0; i < 10; i ++) {
			tree.add(i);
		}
		System.out.println(tree.getDepth());
	}
	static class Tree {
		Integer data;
		Tree left;
		Tree right;
		public Tree (int data) {
			this.data = data;
		}
		public Tree () {
			data = null;
		}
		private void add (int data) {
			if (this.data == null) {
				this.data = data;
				return;
			}
			if (data < this.data) {
				if (left == null) 
					left = new Tree(data);
				else 
					left.add(data);
			} else {
				if (right == null)
					right = new Tree(data);
				else 
					right.add(data);
			}
		}
		public int getDepth() {
			return getDepth(this);
		}
		public int getDepth(Tree tree) {
			if (tree == null) return 0;
			return Integer.max(getDepth(tree.left)+1, getDepth(tree.right)+1);
		}
	}
}
