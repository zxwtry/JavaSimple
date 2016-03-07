package javaSrc;

import java.io.Serializable;
import java.util.Arrays;

/*

两者的特点： 
	              String                  StringBuffer
	              
1,继承的父类		java.lang.Object   		java.lang.Object

2,所在的包		java.lang.String;		java.lang.StringBuffer

3,实现的接口     	Serializable			Serializable
				CharSequence			Appendable
				Comparable<String> 		CharSequence 

4,是否是final		final					final

5,一些摘抄：




AA，(String)字符串串联是通过 StringBuilder（或 StringBuffer）类
	及其 append 方法实现的。
AB，(String)字符串转换是通过 toString 方法实现的，该方法由 Object 
	类定义，并可被 Java 中的所有类继承。
AC，(String)除非另行说明，否则将 null 参数传递给此类中的构造方法或
	方法将抛出 NullPointerException。 
AD，(StringBuffer)线程安全的可变字符序列。


 */

public class StringAndStringBuffer {
	public static void main(String[] args) {
//		String a = new String((char[])null);   //抛出空指针
		
//		String a = null;
//		System.out.println(a);   //输出null
		
//		String a = "ABCDE";
//		String b = new String(a);
//		System.out.println(a==b);
//		System.out.println(b.intern() == a);
		//public native String intern();
		//.intern()是native方法
		//.intern()返回，此字符串在字符串池中的引用
		
//		StringBuffer st = new StringBuffer();
//		System.out.println(st.length());	//0
//		System.out.println(st.capacity());  //16
//		st.append("1234567890123456");		//长度16
//		System.out.println(st.capacity());  //16
//		st.append("1234567890123456789");	
//		//添加1个或2个或18个
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
	
	//自己实现一个MyStringBuffer
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
