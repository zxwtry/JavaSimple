package gaoXiaoBang;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class �ڶ���ͨ�ò˵� {
	public static void main(String[] args) {
		Menu menu = new Menu();
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
		String s = menu.go("ˮ��");
		if (!s.equals(""))
			System.out.println("����ѡ���ǣ�"+s);
		else
			System.out.println("���м��ֱ���˳���");
	}
	static class Menu {
		Tree tree = new Tree();
		public Menu() {
		}
		public void add(String parent, String child) {
			tree.add(parent, child);
		}
		public String go (String x) {
			Scanner sc = new Scanner(System.in);
			int record  = 0;
			int bitRecord = 0;
			for (;;) {
				List<String> list = tree.getChild(x);
				if(list.size() == 0) {
					sc.close();
					return x+record;
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
						x = tree.getParent(x);
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
		public List<String> getChild (String x) {
			List<String> reList = new ArrayList<String>();
			Iterator<Node> it = list.iterator();
			Node tmp  = null;
			while(it.hasNext()) {
				tmp = it.next();
				if (tmp.parent.equals(x)) {
					reList.add(tmp.child);
				}
			}
			return reList;
		}
		public String getParent (String child) {
			Iterator<Node> it = list.iterator();
			Node tmp = null;
			String reStr = null;
			while (it.hasNext()) {
				tmp = it.next();
				if(tmp.child.equals(child)){
					reStr = tmp.parent;
				}
			}
			return reStr;
		}
	}
}
