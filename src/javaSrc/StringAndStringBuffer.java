package javaSrc;

import java.io.Serializable;
import java.util.Arrays;

/*

���ߵ��ص㣺 
	              String                  StringBuffer
	              
1,�̳еĸ���		java.lang.Object   		java.lang.Object

2,���ڵİ�		java.lang.String;		java.lang.StringBuffer

3,ʵ�ֵĽӿ�     	Serializable			Serializable
				CharSequence			Appendable
				Comparable<String> 		CharSequence 

4,�Ƿ���final		final					final

5,һЩժ����




AA��(String)�ַ���������ͨ�� StringBuilder���� StringBuffer����
	���� append ����ʵ�ֵġ�
AB��(String)�ַ���ת����ͨ�� toString ����ʵ�ֵģ��÷����� Object 
	�ඨ�壬���ɱ� Java �е�������̳С�
AC��(String)��������˵�������� null �������ݸ������еĹ��췽����
	�������׳� NullPointerException�� 
AD��(StringBuffer)�̰߳�ȫ�Ŀɱ��ַ����С�


 */

public class StringAndStringBuffer {
	public static void main(String[] args) {
//		String a = new String((char[])null);   //�׳���ָ��
		
//		String a = null;
//		System.out.println(a);   //���null
		
//		String a = "ABCDE";
//		String b = new String(a);
//		System.out.println(a==b);
//		System.out.println(b.intern() == a);
		//public native String intern();
		//.intern()��native����
		//.intern()���أ����ַ������ַ������е�����
		
//		StringBuffer st = new StringBuffer();
//		System.out.println(st.length());	//0
//		System.out.println(st.capacity());  //16
//		st.append("1234567890123456");		//����16
//		System.out.println(st.capacity());  //16
//		st.append("1234567890123456789");	
//		//���1����2����18��
//		System.out.println(st.capacity());  //35
//		st.append("12345678901234567890123456789012345000");
//		System.out.println(st.length()+ " " + st.capacity());
		//73 73
		
		MyStringBuffer myst = new MyStringBuffer();
		System.out.println(myst);
		myst.append("AAA");
		System.out.println(myst);
		myst.append("BBB");
		System.out.println(myst);
		myst.append("ABCDEFGHIJKLMNOPQRST");
		System.out.println(myst);
		System.out.println(myst.getCapacity());
	}
	
	//�Լ�ʵ��һ��MyStringBuffer
	static class MyStringBuffer implements Serializable{
		private static transient char[] data;
		private static final long serialVersionUID = 
						System.identityHashCode(data);
		private static int count = 0;
		public MyStringBuffer() {
			this(16);
		}
		public MyStringBuffer(int capacity) {
			data = new char[capacity];
		}
		public MyStringBuffer append(String str) {
			if (count + str.length() > data.length) {
				expandCapacity (count+str.length());
				System.arraycopy(str.toCharArray(), 0, data, count, str.length());
				count += str.length();
			} else {
				System.arraycopy(str.toCharArray(), 0, data, count, str.length());
				count += str.length();
			}
			return this;
		}
		public int getCapacity () {
			return data.length;
		}
		private void expandCapacity (int minimumCapacity) {
			int newCapacity = 2*data.length+2;
			if (newCapacity < minimumCapacity) {
				newCapacity = minimumCapacity;
			}
			if (minimumCapacity < 0) {
				throw new OutOfMemoryError();
			}
			data = Arrays.copyOf(data, newCapacity);
		}

		public String toString () {
			return String.valueOf(data, 0, count);
		}
	}
}
