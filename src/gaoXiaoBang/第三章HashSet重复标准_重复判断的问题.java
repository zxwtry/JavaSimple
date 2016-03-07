/*

���������ͣ�����ĳӦ���еĵ�����

class MyPoint
{
private int x; //������ ���磺15
private int y; //������ ���磺22
private String color; //�����ɫ�����磺red

...
}

��Ҫ���������͵Ķ�����뵽 HashSet��ȥ�������ظ��жϵ����⡣

�ж�Ҫ�� ��ɫ��ͬ���������벻����2������Ϊ��ͬһ������󣨿���������Ϊ����������������С��Ʈ����

 */

package gaoXiaoBang;

import java.util.HashSet;
import java.util.Set;

public class ������HashSet�ظ���׼_�ظ��жϵ����� {
	public static void main(String[] args) {
		MyHashMap mhm = new MyHashMap();
		mhm.genNewPoint(1, 0, "red");       //����
		mhm.genNewPoint(-1, 0, "red");      //������
		mhm.genNewPoint(2, 0, "red");       //������
		mhm.genNewPoint(-2, 0, "red");      //����
		mhm.genNewPoint(0, 0, "red");       //������
		mhm.genNewPoint(0, 3, "red");       //����
		mhm.genNewPoint(0, 3, "pink");      //����
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
				//y     .....     int  .....  x��yһͬ����
				//color .....  String  .....  unique
				//����   <=   2
				//����ƽ����           1  ...  4  ...  9  ...  16  ...  25  ...  36  ...  49  ...  64
				//��ʽ������           1  ...  2  ...  3  ...   4  ...   5  ...   6  ...   7  ...   8
				return color.hashCode();	//����color��hashCode
			}
			public String toString() {
				return color+String.valueOf(x)+String.valueOf(y);
			}
		}
	}
}
