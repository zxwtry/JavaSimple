/*

ע�����νṹ���ص㣺
��һ���ڵ㵽��һ���ڵ�ֻ��һ��ͨ·��
�����a�㵽b���ͨ·���ȡ�
*/
/*
 * �ٶ�:
 * 1������洢��û����ͬ��Ԫ��.
 * 2���ٶ���������Ԫ�رض���һ��·����
 */
package gaoXiaoBang;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
public class �ڶ���һ�����νṹ_��ͨ·���� {
	public static void main(String[] args) {
		Tree t = new Tree();
		t.add("����", "�й�");
		t.add("����", "�¹�");
		t.add("����", "����");
		t.add("�й�", "����");
		t.add("�й�", "�㶫");
		t.add("����", "����");
		t.add("�㶫", "����");
		t.add("����", "����");
		t.add("����", "����");
		t.add("����", "�Ͼ�");
		t.add("�㶫", "����");
//		String[] rs = t.findOk("����", "����");
//		String[] rs = t.findOk("����", "����");
		String[] rs = t.findOk("����", "����");
		
		for (int i = 0; i < rs.length; i ++) {
			System.out.print(rs[i]+"\t");
		}
		System.out.println("\nͨ·����:"+(rs.length-1));
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
