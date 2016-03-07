/*
java提供的数组有个特点: 当数组元素的个数确定后，就不能再追加元素了。
也就是说，数组的大小在创建的时候就固定了。
现在请你来写一个智能数组类 SmartArray，它能够根据需要动态地分配空间。
实际上，它只不过是在其它位置分配新的数组，然后把旧的数据拷贝过去。
请提供数组访问方法：
int get(int idx); // 返回指定位置的元素值
void set(int idx, int value); // 对指定的下标元素设置新值。当然，如果下标超出了原来数组的大小，则自动分配新的空间。
 */


package gaoXiaoBang;

import java.lang.reflect.Array;

public class 第二章智能数组 {
	public static void main(String[] args) {
		String[] s1 = {"AAA","BBB","CCC"};
		String[] s2 = {"DDD","EEE","FFF","GGG"};
		SmartArray<String> st = new SmartArray<String>();
		for (int i = 0; i < s1.length; i ++) {
			st.add(s1[i]);
		}
		for (int i = 0; i < s2.length; i ++) {
			st.add(s2[i]);
		}
		st.add("HHH");
		st.set(0, "MMM");
//		st.set(100, "AAA");
		
		for (int i = 0; i < st.length(); i ++) {
			System.out.println(st.get(i));
		}
	}
	static class SmartArray <T> {
		private T[] t = null;
		public SmartArray() {
		}
		@SuppressWarnings("unchecked")
		public void add(T x) {
			 int tLength = (t == null ? 0 : t.length);
			 T [] tmp = (T[]) Array.newInstance(Object.class,tLength + 1);
			 for (int i = 0; i < tLength; i ++) {
				 tmp[i] = t[i];
			 }
			 tmp[tLength] = x;
			 t = tmp;
		}
		//在泛型下面会出错。
//		@SuppressWarnings("unchecked")
//		public void add(T[] x) {
//			int tLength = (t == null ? 0 : t.length);
//			T [] tmp = (T[]) Array.newInstance(Object.class,tLength + x.length);
//			for (int i = 0; i < tLength; i ++) {
//				tmp[i] = t[i];
//			}
//			for (int i = tLength; i < tLength + x.length; i ++) {
//				tmp[i] = x[i - tLength];
//			}
//		}
		public int length() {
			return (t == null ? 0 : t.length);
		}
		public T get(int index) {
			indexOutOfBoundsException(index);
			return t[index];
		}
		public void set(int index, T value) {
			indexOutOfBoundsException(index);
			t[index] = value;
		}
		private void indexOutOfBoundsException (int index) {
			if (t == null || index >= t.length || index < 0) 
				throw new IndexOutOfBoundsException("get传入的值超界！");
		}
	}
}
