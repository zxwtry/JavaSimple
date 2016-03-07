/*
java�ṩ�������и��ص�: ������Ԫ�صĸ���ȷ���󣬾Ͳ�����׷��Ԫ���ˡ�
Ҳ����˵������Ĵ�С�ڴ�����ʱ��͹̶��ˡ�
����������дһ������������ SmartArray�����ܹ�������Ҫ��̬�ط���ռ䡣
ʵ���ϣ���ֻ������������λ�÷����µ����飬Ȼ��Ѿɵ����ݿ�����ȥ��
���ṩ������ʷ�����
int get(int idx); // ����ָ��λ�õ�Ԫ��ֵ
void set(int idx, int value); // ��ָ�����±�Ԫ��������ֵ����Ȼ������±곬����ԭ������Ĵ�С�����Զ������µĿռ䡣
 */


package gaoXiaoBang;

import java.lang.reflect.Array;

public class �ڶ����������� {
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
		//�ڷ�����������
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
				throw new IndexOutOfBoundsException("get�����ֵ���磡");
		}
	}
}
