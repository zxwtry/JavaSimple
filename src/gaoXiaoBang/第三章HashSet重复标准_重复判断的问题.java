/*

有如下类型，代表某应用中的点类型

class MyPoint
{
private int x; //横坐标 例如：15
private int y; //纵坐标 例如：22
private String color; //点的颜色，例如：red

...
}

需要把这种类型的对象加入到 HashSet中去，请解决重复判断的问题。

判定要求： 颜色形同，坐标点距离不超过2，则认为是同一个点对象（可以想象因为测量误差，允许坐标有小的飘动）

 */

package gaoXiaoBang;

import java.util.HashSet;
import java.util.Set;

public class 第三章HashSet重复标准_重复判断的问题 {
	public static void main(String[] args) {
		MyHashMap mhm = new MyHashMap();
		mhm.genNewPoint(1, 0, "red");       //加入
		mhm.genNewPoint(-1, 0, "red");      //不加入
		mhm.genNewPoint(2, 0, "red");       //不加入
		mhm.genNewPoint(-2, 0, "red");      //加入
		mhm.genNewPoint(0, 0, "red");       //不加入
		mhm.genNewPoint(0, 3, "red");       //加入
		mhm.genNewPoint(0, 3, "pink");      //加入
		System.out.println(mhm);
	}
	static class MyHashMap {
		Set<MyPoint> myHashSet;
		public MyHashMap() {
			myHashSet = new HashSet<MyPoint>();
		}
		public String toString() {
			return myHashSet.toString();
		}
		public void genNewPoint(int x, int y, String color) {
			myHashSet.add(new MyPoint(x, y, color));
		}
		public boolean isTheSamePoint(int x, int y, String color , int xx, int yy, String cc){
			return new MyPoint(xx, yy, cc).equals(new MyPoint(x, y, color));
		}
		class MyPoint {
			private int x;
			private int y;
			private String color;
			public MyPoint() {}
			public MyPoint(int x, int y, String color) {
				this.x = x;
				this.y = y;
				this.color = color;
			}
			public int getX() {
				return x;
			}
			public void setX(int x) {
				this.x = x;
			}
			public int getY() {
				return y;
			}
			public void setY(int y) {
				this.y = y;
			}
			public String getColor() {
				return color;
			}
			public void setColor(String color) {
				this.color = color;
			}
			@Override
			public boolean equals(Object obj) {
				if (obj instanceof MyPoint == false)   return false;
				MyPoint mpOBJ = (MyPoint) obj;
				return this.color.equals(mpOBJ.getColor()) && (x - mpOBJ.x)*(x - mpOBJ.x) + (y - mpOBJ.y)*(y - mpOBJ.y) <= 4;
			}
			@Override
			public int hashCode() {
				//x     .....     int  .....  
				//y     .....     int  .....  x与y一同决定
				//color .....  String  .....  unique
				//距离   <=   2
				//距离平方差           1  ...  4  ...  9  ...  16  ...  25  ...  36  ...  49  ...  64
				//上式开根号           1  ...  2  ...  3  ...   4  ...   5  ...   6  ...   7  ...   8
				return color.hashCode();	//保存color的hashCode
			}
			public String toString() {
				return color+String.valueOf(x)+String.valueOf(y);
			}
		}
	}
}
