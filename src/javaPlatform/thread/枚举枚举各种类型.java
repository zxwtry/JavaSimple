package javaPlatform.thread;

public class ö��ö�ٸ������� {
	public static void main(String[] args) {
//		Example1.main(null);
//		Example2.main(null);
		Example3.main(null);
	}
	/**
	 * 	�÷�һ������
	 *	JDK1.5֮ǰ�����峣�����ǣ�public static final...
	 *	��������ö�٣����԰���صĳ������鵽һ��ö����������
	 *	����ö���ṩ�˱���������ķ���
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
	 * 	�÷�����switch
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
	 *	�÷�������ö��������·���
	 *	��������Զ����Լ��ķ�������ô������enumʵ��
	 *	��������һ���ֺš�����JavaҪ������ȶ���enumʵ��
	 */
	static class Example3 {
		public static void main(String[] args) {
			for (Color c : Color.values()) {
				System.out.println(c.getName());
			}
		}
		public enum Color {
			RED("��ɫ", 1), GREEN("��ɫ", 2), WHITE("��ɫ", 3), YELLOW("��ɫ", 4);
			
			// ��Ա����
			private String name;
			private int index;
			
			// ���췽��
			private Color(String name, int index) {
				this.name= name;
				this.index = index;
			}
			
			// ��ͨ����
			public static String getName(int index) {
				for (Color c : Color.values()) {
					if (c.getIndex() == index) {
						return c.name;
					}
				}
				return null;
			}
			
			// get set ����
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
	 * 	�÷��ģ�����ö�ٵķ���
	 * 	toString
	 */
}
