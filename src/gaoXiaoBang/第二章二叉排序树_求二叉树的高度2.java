/*
�������һ�ö������ĸ߶Ⱦ��ǴӸ���Ҷ�ӵ�����롣�Ա�����������ĸ߶ȡ�
��ʵ���������ĸ߶Ⱦ����������������������и߶����ֵ + 1
���⿼��: ������������ݱ������������������ᷢ��ʲô��
��ο������ݽṹ���̲Ľ��������⡣
 */
/*
 * ������������ݱ���������������
 * ��:������ٸ�������ô,��Ⱦ��Ƕ��ټ����ֵ�������
 */

/*
 *     6
 *   4   9
 *  2 5 8
 * 1
 * �����˳����:6 4 2 1 5 9 8
 */


package gaoXiaoBang;

public class �ڶ��¶���������_��������ĸ߶�2 {
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
