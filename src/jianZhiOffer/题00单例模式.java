package jianZhiOffer;

import java.util.HashMap;
import java.util.Map;

/*

　　1、单例类只能有一个实例。
　　2、单例类必须自己创建自己的唯一实例。
　　3、单例类必须给所有其他对象提供这一实例。

 */


public class 题00单例模式 {
	public static void main(String[] args) {
		MySingleton1 s1 = MySingleton1.getSingleton();   //懒汉模式
		MySingleton1 s2 = MySingleton1.getSingleton();
		if (s1 == s2)
			System.out.println(true);		//输出是true
		MySingletonOut s3 = MySingletonOut.getInstance();
		MySingletonOut s4 = MySingletonOut.getInstance();
		if (s3 == s4)
			System.out.println(true);		//输出是true
		
		MySingleton2 s5 = MySingleton2.getSingleton();   //饿汉模式
		MySingleton2 s6 = MySingleton2.getSingleton();
		if (s5 == s6)
			System.out.println(true);		//输出是true
		
		MySingleton11 s7 = MySingleton11.getSingleton();   //懒汉模式的修改
		MySingleton11 s8 = MySingleton11.getSingleton();
		if (s7 == s8)
			System.out.println(true);		//输出是true
		
		MySingleton12 s9  = MySingleton12.getSingleton();   //懒汉模式的修改的错误示例
		MySingleton12 s10 = MySingleton12.getSingleton();
		if (s9 == s10)
			System.out.println(true);		//输出是true;可能会错；代码一定错
		
		MySingleton3 s11 = MySingleton3.getSingleton();   //私有静态内部类
		MySingleton3 s12 = MySingleton3.getSingleton();
		if (s11 == s12)
			System.out.println(true);		//输出是true
		
		MySingleton4 s13 = MySingleton4.getSingleton(null);   //私有静态内部类
		MySingleton4 s14 = MySingleton4.getSingleton(null);
		if (s13 == s14)
			System.out.println(true);		//输出是true
		
	}
	static class MySingleton1 {
		//静态内部类
		//在单例模式中，必须要在 class MySingleton 之前加上static
		//这种模式叫做懒汉模式
		private static MySingleton1 single;
		private MySingleton1 () {}
		public static synchronized MySingleton1  getSingleton () {
			if (single == null)
				single = new MySingleton1();
			return single;
		}
	}
	static class MySingleton2 {
		//饿汉模式
		//与懒汉模式的不同是：不需要添加同步块，所以比较简单
		private static MySingleton2 single = new MySingleton2();
		private MySingleton2 () {}
		public static MySingleton2 getSingleton () {
			return single;
		}
	}
	
	//接下来的是很多个对懒汉模式的修改
	static class MySingleton11 {
		//双重检测，但要注意写法
		//注意下一个代码段中，会有一段错误代码示例
		private static MySingleton11 single = null;
		private MySingleton11 () {}
		public static MySingleton11 getSingleton () {
			if (single == null) {
				synchronized(MySingleton11.class) {
					MySingleton11 singleTemp = single;
					if (singleTemp == null) {
						singleTemp = new MySingleton11();
						single = singleTemp;
					}
				}
			}
			return single;
		}
	}
	static class MySingleton12 {
		//这是MySingleton11的错误示例
		//更正代码的方式是将下面这句改写为
		//private static volatile MySingleton12 single = null;
		private static MySingleton12 single = null;
		private MySingleton12 () {}
		public static MySingleton12 getSingleton () {
			if (single == null) {
				synchronized (MySingleton12.class) {
					if (single == null) {
						single = new MySingleton12();
					}
				}
			}
			return single;
		}
	}
	
	//实现单例的又一种方式：内部类
	//注意这里的内部类究竟是在什么地方
	static class MySingleton3 {
		private MySingleton3 () {}
		private static class MySingleton3Holder {
			private final static MySingleton3 INSTANCE = new MySingleton3();
		}
		public static MySingleton3 getSingleton () {
			return MySingleton3Holder.INSTANCE;
		}
	}
	
	//登记式单例
	static class MySingleton4 {
		private static Map<String, MySingleton4> singletonMap 
					= new HashMap<String, MySingleton4>();
		static {
			MySingleton4 single = new MySingleton4();
			singletonMap.put(single.getClass().getName(), single);
		}
		private MySingleton4 () {}
		//静态工厂方法，返还此类唯一的实例
		public static MySingleton4 getSingleton(String name) {
			if (name == null) {
				name = MySingleton4.class.getName();
			}
			if (singletonMap.get(name) == null) {
				try {
					singletonMap.put(name, (MySingleton4)Class.forName(name).newInstance());
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
			return singletonMap.get(name);
		}
	}
	
}

class MySingletonOut {
	//非内部类，class MySingletonOut前面不能添加static
	private MySingletonOut () {}
	private static MySingletonOut single = null;
	public static MySingletonOut getInstance () {
		if (single == null)
			single = new MySingletonOut();
		return single;
	}
}
