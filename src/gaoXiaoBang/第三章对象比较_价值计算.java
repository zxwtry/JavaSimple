/*

某游戏中的对象具有属性：

1. 材质： 木材，钢铁，合金，塑料

2. 颜色： 红 黑 黄 白

3. 形状： 方 圆 三角 五边
4. 尺寸： 整数 1 ~ 1000

请设计该对象的价值计算方法。属性的重要性从上到下减小。同一属性的值的重要性从左到右减小。

即： 材质好的不管颜色、尺寸，肯定有更高价值。
其它相同，红色的比黑色价值高
尺寸越小越值钱。

 */


package gaoXiaoBang;

public class 第三章对象比较_价值计算 {
	public static void main(String[] args) {
		GameObject g1 = new GameObject("塑料", "红", "五边", 1000);
		GameObject g2 = new GameObject("木材", "红", "五边", 1000);
		System.out.println(g1.getTheMoreValuableOne(g2).toString());
	}
	static class GameObject {
		private String 材质;
		private String 颜色;
		private String 形状;
		private int 尺寸;
		public GameObject() {
		}
		public GameObject(String 材质, String 颜色, String 形状, int 尺寸) {
			this.材质 = 材质;
			this.颜色 = 颜色;
			this.形状 = 形状;
			this.尺寸 = 尺寸;
		}
		public void set材质(String 材质) {
			this.材质 = 材质;
		}
		public String get材质() {
			return 材质;
		}
		public void set颜色(String 颜色) {
			this.颜色 = 颜色;
		}
		public String get颜色() {
			return 颜色;
		}
		public void set形状(String 形状) {
			this.形状 = 形状;
		}
		public String get形状() {
			return 形状;
		}
		public void set尺寸(int 尺寸) {
			this.尺寸 = 尺寸;
		}
		public int get尺寸() {
			return 尺寸;
		}
		public int getValue() {
			//value值越小越是重要
			int value = 0;
			if (材质.equals("木材"))
				value = value * 100 + 0;
			else if (材质.equals("钢铁"))
				value = value * 100 + 1;
			else if (材质.equals("合金"))
				value = value * 100 + 2;
			else if (材质.equals("塑料"))
				value = value * 100 + 3;
			if (颜色.equals("红"))
				value = value * 100 + 0;
			else if (颜色.equals("黑"))
				value = value * 100 + 1;
			else if (颜色.equals("黄"))
				value = value * 100 + 2;
			else if (颜色.equals("白"))
				value = value * 100 + 3;
			if (形状.equals("方"))
				value = value * 100 + 0;
			else if (形状.equals("圆"))
				value = value * 100 + 1;
			else if (形状.equals("三角"))
				value = value * 100 + 2;
			else if (形状.equals("五边"))
				value = value * 100 + 3;
			value = value * 1000 + 尺寸 - 1;
			return value;
		}
		public GameObject getTheMoreValuableOne(GameObject myGameObject) {
			return this.getValue() < myGameObject.getValue() ? this : myGameObject;
		}
		public String toString() {
			return "材质:"+材质+"   颜色:"+颜色+"   形状:"+形状+"   尺寸:"+尺寸;
		}
	}
}
