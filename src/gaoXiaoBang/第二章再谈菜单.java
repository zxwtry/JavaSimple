/*
����������µĽڵ�ṹʵ�ֲ˵����ܡ�
ÿ���˵�����4��ָ�룺
parent: ָ�򸸽ڵ�
child: ָ���һ�����ӽڵ�
left: ָ�򱾽ڵ�ġ���硱
right: ָ�򱾽ڵ�ġ��ܵܡ�
��ʾ���ӽڵ��ʱ���ǰ��ӳ����׵Ĵ���
*/
/*
�ǰ��ӳ����׵Ĵ���Ĭ��������data�Ӵ�С
 */

package gaoXiaoBang;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class �ڶ�����̸�˵� {
	public static void main(String[] args) {
		Menu menu = new Menu ();
		menu.add("ˮ��","ƻ��");
		menu.add("ˮ��", "�㽶");
		menu.add("ˮ��", "���� ");
		menu.add("ƻ��", "�츻ʿƻ��");
		menu.add("ƻ��", "����ƻ��");
		menu.add("����ƻ��", "����1��");
		menu.add("����ƻ��", "����2��");
		menu.add("�츻ʿƻ��", "�츻ʿ1��");
		menu.add("�츻ʿƻ��", "�츻ʿ2��");
		menu.add("�츻ʿƻ��", "�츻ʿ3��");
//		System.out.println(menu.getAllChilds("ˮ��"));
//		System.out.println(menu.getAllChilds("ƻ��"));
//		System.out.println(menu.getAllChilds("����"));
//		System.out.println(menu.getAllChilds("����ƻ��"));
//		System.out.println(menu.getAllChilds("�츻ʿƻ��"));
//		System.out.println(menu.getAllChilds("�츻ʿ1��"));
		String s = menu.go("ˮ��");
		if (!s.equals(""))
			System.out.println("����ѡ���ǣ�"+s);
		else
			System.out.println("���м��ֱ���˳���");
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
			//��child��parent���в�����
			flag.child.parent = flag.parent;
			//��child��left��right��parent��child���в�����
			Node setTemp = flag.parent.child;
			if (setTemp == null) {
				flag.parent.child = flag.child;
			} else {//���1��Ҫ��ѡ���õ�flag.child���ó�Ϊflag.parent��child
				if (flag.parent.child.data.compareTo(flag.child.data) <= 0) {
					flag.child.right = flag.parent.child;
					flag.parent.child.left = flag.child;
					flag.parent.child = flag.child;
				} else {
					while (setTemp.right != null) {
						if (setTemp.data.compareTo(flag.child.data) <= 0)
							break;
						setTemp = setTemp.right;
					}//���2��
					if (setTemp.right == null && setTemp.data.compareTo(flag.child.data) > 0) {
						setTemp.right = flag.child;
						flag.child.left = setTemp;
					} else {//���3��
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
					return x+new String("	��ţ�"+record);
				}
				System.out.println("------------------");
				for (int i = 0; i < list.size(); i ++) {
					System.out.println(i+"."+list.get(i));
				}
				System.out.println("------------------");
				System.out.print("(����quit�˳� back�Ż���һ��menuֱ�ӷŻص����˵�)\n����ѡ����:");
				String s  = sc.nextLine();
				if (s.equals("quit")) {
					sc.close();
					return "";
				} else if (s.equals("back")) {
					if (x.equals("ˮ��")) {
						x = "ˮ��";
					} else {
						x = getParent(x);
						record = record / (int) Math.pow(10, bitRecord);
						bitRecord --;
					}
				} else if (s.equals("menu")) {
					x = "ˮ��";
					record = 0;
					bitRecord = 0;
				} else if (s.charAt(0)>='0' && s.charAt(0) <= '9') {
					int tmp1 = Integer.parseInt(s);
					record = record  + (tmp1+1) * (int) Math.pow(10, bitRecord);
					x = list.get(tmp1);
					bitRecord ++;
				} else {
					System.out.println("������ַ�����,����������");
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
