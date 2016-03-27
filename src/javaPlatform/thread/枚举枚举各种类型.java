package javaPlatform.thread;

public class 枚举枚举各种类型 {
	public static void main(String[] args) {
//		Example1.main(null);
//		Example2.main(null);
		Example3.main(null);
	}
	/**
	 * 	用法一：常量
	 *	JDK1.5之前，定义常量都是：public static final...
	 *	现在有了枚举，可以把相关的常量分组到一个枚举类型量，
	 *	而且枚举提供了比两两更多的方法
	 */
	static class Example1 {
		private enum Color {
			RED, GREEN, ZXW, BLANK, YELLOW
		}
		public static void main(String[] args){
			System.out.println(String.valueOf(Color.RED) == ("RED"));
		}
	}
	/**
	 * 	用法二：switch
	 */
	static class Example2 {
		private enum Signal {
			GREEN, YELLOW, RED
		}
		public static void main(String[] args) {
			Signal color = Signal.GREEN;
			switch(color) {
			case GREEN:
				System.out.println(color);
				break;
			case YELLOW:
				System.out.println(color);
				break;
			case RED:
				System.out.println(color);
				break;
			default :
				System.out.println("AAA");
				break;
			}
		}
	}
	
	/**
	 *	用法三：向枚举中添加新方法
	 *	如果打算自定义自己的方法，那么必须在enum实例
	 *	的最后添加一个分号。而且Java要求必须先定义enum实例
	 */
	static class Example3 {
		public static void main(String[] args) {
			for (Color c : Color.values()) {
				System.out.println(c.getName());
			}
		}
		public enum Color {
			RED("红色", 1), GREEN("绿色", 2), WHITE("白色", 3), YELLOW("黄色", 4);
			
			// 成员变量
			private String name;
			private int index;
			
			// 构造方法
			private Color(String name, int index) {
				this.name= name;
				this.index = index;
			}
			
			// 普通方法
			public static String getName(int index) {
				for (Color c : Color.values()) {
					if (c.getIndex() == index) {
						return c.name;
					}
				}
				return null;
			}
			
			// get set 方法
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public int getIndex() {
				return index;
			}
			public void setIndex(int index) {
				this.index = index;
			}
		};
	}
	
	/**
	 * 	用法四：覆盖枚举的方法
	 * 	toString
	 */
}
