/*

注意树形结构的特点：
从一个节点到另一个节点只有一条通路。
编程求a点到b点的通路长度。
*/
/*
 * 假定:
 * 1，这个存储中没有相同的元素.
 * 2，假定，这两个元素必定有一条路径。
 */
package gaoXiaoBang;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
public class 第二章一般树形结构_求通路长度 {
	public static void main(String[] args) {
		Tree t = new Tree();
		t.add("地球", "中国");
		t.add("地球", "德国");
		t.add("地球", "美国");
		t.add("中国", "江苏");
		t.add("中国", "广东");
		t.add("江苏", "苏州");
		t.add("广东", "深圳");
		t.add("加州", "湾区");
		t.add("美国", "加州");
		t.add("江苏", "南京");
		t.add("广东", "广州");
//		String[] rs = t.findOk("地球", "苏州");
//		String[] rs = t.findOk("苏州", "地球");
		String[] rs = t.findOk("湾区", "地球");
		
		for (int i = 0; i < rs.length; i ++) {
			System.out.print(rs[i]+"\t");
		}
		System.out.println("\n通路长度:"+(rs.length-1));
	}
	static class Tree {
		static boolean findTheResult = false;
		class Node {
			String parent;
			String child;
			public Node (String parent, String child) {
				this.parent = parent;
				this.child = child;
			}
		}
		List<Node> list = null;
		public Tree () {
			list = new ArrayList<Node>();
		}
		public void add (String parent, String child) {
			list.add(new Node(parent,child));
		}
		String[] findOk (String str1, String str2) {
			findTheResult = false;
			findThe(str1, str2);
			if (findTheResult)
				return findRoute(str1, str2);
			else 
				return findRoute(str2,str1);
		}
		void findThe(String str1, String str2) {
			if (findTheResult)	return;
			Iterator<Node> it = list.iterator();
			while (it.hasNext()) {
				Node tmp = it.next();
				if (str1.equals(tmp.parent)) {
					if (tmp.child.equals(str2)){
						findTheResult = true;
					}
					findThe(tmp.child,str2);
				}
			}
		}
		String[] findRoute (String str1, String str2) {
			List<String> al = new ArrayList<String>();
			boolean isDone = false;
			String theChildTmp = str2;
			while(!isDone) {
				for (int i = 0; i < list.size(); i ++ ) {
					if (list.get(i).child.equals((theChildTmp))) {
						al.add(theChildTmp);
						theChildTmp = list.get(i).parent;
						if (list.get(i).parent.equals(str1)){
							isDone = true;
							al.add(str1);
						}
						break;
					}
				}
			}
			int length = al.size();
			String[] st = new String [length];
			for (int i = 0; i < length; i ++) {
				st[length-i-1] = al.get(i);
			}
			return st;
		}
	}
}
