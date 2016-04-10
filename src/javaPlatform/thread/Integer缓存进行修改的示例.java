package javaPlatform.thread;

import java.lang.reflect.Field;

public class Integer缓存进行修改的示例 {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Class<?> MyInteger = Integer.class.getDeclaredClasses()[0];
		Field MyField = MyInteger.getDeclaredField("cache");
		MyField.setAccessible(true);
		Integer[] MyCache = (Integer[]) MyField.get(MyInteger);
		
		// -128 ----   0
		// 4    ----   132
		// 5    ----   133
		
		MyCache[132] = MyCache[133];
		
		System.out.println(2 + 2);
		
		Integer i1 = new Integer(2);
		Integer i2 = new Integer(2);
		
		System.out.println(i1 + i2);
		
		System.out.println(MyCache[132] + "====" + MyCache[133]) ;
	}
}
