/*
请你采用如下的节点结构实现菜单功能。
每个菜单项有4个指针：
parent: 指向父节点
child: 指向第一个孩子节点
left: 指向本节点的“哥哥”
right: 指向本节点的“弟弟”
显示孩子节点的时候，是按从长到幼的次序。
*/
/*
是按从长到幼的次序：默认设置由data从大到小
 */

package gaoXiaoBang;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class 第二章再谈菜单 {
	public static void main(String[] args) {
		Menu menu = new Menu ();
		menu.add("水果","苹果");
		menu.add("水果", "香蕉");
		menu.add("水果", "菠萝 ");
		menu.add("苹果", "红富士苹果");
		menu.add("苹果", "国光苹果");
		menu.add("国光苹果", "国光1号");
		menu.add("国光苹果", "国光2号");
		menu.add("红富士苹果", "红富士1号");
		menu.add("红富士苹果", "红富士2号");
		menu.add("红富士苹果", "红富士3号");
//		System.out.println(menu.getAllChilds("水果"));
//		System.out.println(menu.getAllChilds("苹果"));
//		System.out.println(menu.getAllChilds("菠萝"));
//		System.out.println(menu.getAllChilds("国光苹果"));
//		System.out.println(menu.getAllChilds("红富士苹果"));
//		System.out.println(menu.getAllChilds("红富士1号"));
		String s = menu.go("水果");
		if (!s.equals(""))
			System.out.println("您的选择是："+s);
		else
			System.out.println("从中间段直接退出。");
	}
	static class Menu {
		private Node root = null;
		class Node {
			String data;
			Node parent,child,left,right;
			public Node (String data) {
				this.data = data;
			}
		}
		class NodeTravelFlag {
			Node parent;
			Node child;
			public NodeTravelFlag (Node parent, Node child) {
				this.parent = parent;
				this.child = child;
			}
		}
		class NodeTravelOne {
			Node node;
			public NodeTravelOne (Node node) {
				this.node = node;
			}
		}
		public Menu () {
		}
		public void add (String parent, String child) {
			if (root == null) {
				Node nodeParent = new Node (parent);
				Node nodeChild = new Node (child);
				nodeParent.child = nodeChild;
				root = nodeParent;
				return;
			}
			NodeTravelFlag flag = new NodeTravelFlag(null, null);
			travelAll(root, parent, child, flag);
			if (flag.parent == null)	flag.parent = new Node(parent);
			if (flag.child == null)		flag.child = new Node(child);
			//对child的parent进行操作。
			flag.child.parent = flag.parent;
			//对child的left，right和parent的child进行操作。
			Node setTemp = flag.parent.child;
			if (setTemp == null) {
				flag.parent.child = flag.child;
			} else {//情况1：要将选定好的flag.child设置成为flag.parent的child
				if (flag.parent.child.data.compareTo(flag.child.data) <= 0) {
					flag.child.right = flag.parent.child;
					flag.parent.child.left = flag.child;
					flag.parent.child = flag.child;
				} else {
					while (setTemp.right != null) {
						if (setTemp.data.compareTo(flag.child.data) <= 0)
							break;
						setTemp = setTemp.right;
					}//情况2：
					if (setTemp.right == null && setTemp.data.compareTo(flag.child.data) > 0) {
						setTemp.right = flag.child;
						flag.child.left = setTemp;
					} else {//情况3：
						flag.child.left = setTemp.left;
						flag.child.right = setTemp;
						flag.child.left.right = flag.child;
						flag.child.right.left = flag.child;
					}
				}
			}
		}
		public List<String> getAllChilds (String parent) {
			List<String> reList = new ArrayList<String> ();
			NodeTravelOne flag = new NodeTravelOne(null);
			getNode (flag, parent, root);
			if (flag.node != null) {
				Node getTemp = flag.node.child;
				while (getTemp != null) {
					reList.add(getTemp.data);
					getTemp = getTemp.right;
				}
			}
			return reList;
		}
		public String go (String x) {
			Scanner sc = new Scanner(System.in);
			int record  = 0;
			int bitRecord = 0;
			for (;;) {
				List<String> list = getAllChilds (x);
				if(list.size() == 0) {
					sc.close();
					return x+new String("	编号："+record);
				}
				System.out.println("------------------");
				for (int i = 0; i < list.size(); i ++) {
					System.out.println(i+"."+list.get(i));
				}
				System.out.println("------------------");
				System.out.print("(输入quit退出 back放回上一层menu直接放回到主菜单)\n您的选择是:");
				String s  = sc.nextLine();
				if (s.equals("quit")) {
					sc.close();
					return "";
				} else if (s.equals("back")) {
					if (x.equals("水果")) {
						x = "水果";
					} else {
						x = getParent(x);
						record = record / (int) Math.pow(10, bitRecord);
						bitRecord --;
					}
				} else if (s.equals("menu")) {
					x = "水果";
					record = 0;
					bitRecord = 0;
				} else if (s.charAt(0)>='0' && s.charAt(0) <= '9') {
					int tmp1 = Integer.parseInt(s);
					record = record  + (tmp1+1) * (int) Math.pow(10, bitRecord);
					x = list.get(tmp1);
					bitRecord ++;
				} else {
					System.out.println("输入的字符有误,请重新输入");
				}
			}
		}
		private void travelAll (Node node, String parent, String child, NodeTravelFlag flag) {
			if (node == null || (flag.parent != null && flag.child != null))	return;
			if (node.data.equals(parent))	flag.parent = node;
			else if (node.data.equals(child))	flag.child = node;
			travelAll(node.right, parent, child, flag);
			travelAll(node.child, parent, child, flag);
		}
		private void getNode (NodeTravelOne flag, String data, Node node) {
			if (node == null || flag.node != null)	return;
			if (node.data.equals(data))	{
				flag.node = node;
				return;
			}
			getNode (flag, data, node.child);
			getNode (flag, data, node.right);
		}
		private String getParent (String x) {
			NodeTravelOne flag = new NodeTravelOne (null);
			getNode(flag, x, root);
			return flag.node.parent.data;
		}
	}
}
