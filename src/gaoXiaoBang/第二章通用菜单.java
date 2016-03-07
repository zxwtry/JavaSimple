package gaoXiaoBang;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class 第二章通用菜单 {
	public static void main(String[] args) {
		Menu menu = new Menu();
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
		String s = menu.go("水果");
		if (!s.equals(""))
			System.out.println("您的选择是："+s);
		else
			System.out.println("从中间段直接退出。");
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
				System.out.print("(输入quit退出 back放回上一层menu直接放回到主菜单)\n您的选择是:");
				String s  = sc.nextLine();
				if (s.equals("quit")) {
					sc.close();
					return "";
				} else if (s.equals("back")) {
					if (x.equals("水果")) {
						x = "水果";
					} else {
						x = tree.getParent(x);
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
