package javaPlatform.thread;

public class 枚举枚举各种类型 {
	public static void main(String[] args) {
//		Example1.main(null);
//		Example2.main(null);
//		Example3.main(null);
		Example4.main(null);
		System.out.println(Food.Coffee.BLACK_COFFEE.toString());
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
	static class Example4 {
		public static void main(String[] args) {
			System.out.println(Color.RED.toString());
		}
		
		public enum Color {
			RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);
	        // 成员变量
	        private String name;
	        private int index;

	        // 构造方法
	        private Color(String name, int index) {
	            this.name = name;
	            this.index = index;
	        }

	        // 覆盖方法
	        @Override
	        public String toString() {
	            return this.index + "_" + this.name;
	        }
		}
	}
	
	/**
	 * 	方法五：实现接口
	 * 	所有的枚举都继承自java.lang.Enum类
	 * 	由于java是单继承，所以枚举对象不能再继承其他类
	 */
	static interface Behavior {
		void print();
		String getInfo();
	}
	static enum Color implements Behavior {
		RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);

		private String name;
        private int index;

        // 构造方法
        private Color(String name, int index) {
            this.name = name;
            this.index = index;
        }

        // 接口方法
        @Override
        public String getInfo() {
            return this.name;
        }

        // 接口方法
        @Override
        public void print() {
            System.out.println(this.index + ":" + this.name);
        }
	}
	
	/**
	 * 	方法六：使用接口组织枚举
	 */
	static interface Food {
		enum Coffee implements Food {
			BLACK_COFFEE, DECAE_COFFEE, CAPUCCINO
		}
		enum Dessert implements Food {
			FRUIT, CAKE, GEIATO
		}
	}
	
	/**
	 * 	方法七：枚举集合的使用
	 * 	java.util.EnumSet和java.util.EnumMap是两个枚举集合
	 */
	
}
