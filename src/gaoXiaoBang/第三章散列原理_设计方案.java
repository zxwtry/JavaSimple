/*

某停车场容量为1000，编号从1000~1999 且相邻编号位置肯定是相邻的。最高峰大约需要停放800辆车。

假设车牌号码是类似：“京NHK936” 这样的汉字、数字、字母混合。

我们需要一种方案，可以从车牌号快速地计算出该车辆的大约停车位置。

这样当有人电话询问某辆车的位置时，只要报一下车牌号就可以了。

// 9 2 2 3 3 7 2 0 3 6 8 5 4 7 7 5 8 0 7
//   8 7 6 5 4 3 2 1 0 9 8 7 6 5 4 3 2 1

'z' - '0'  ====  74

'Z' - '0'  ====  42

'9' - '0'  ====  74

6位数字或者字母总共占 2*6 = 12位。

按照原先的顺序去填到12-1位

将汉字转化成为gbk码，应该是两位，byte数。

两位都加上128就都成非负数，0位乘以1000再加上1位

得到一个可能是6位数的数填到18-13位

 */

/*
京NHK936   ====   1000
鲁AAAA03   ====   1006
浙K03666   ====   1010
粤A09000   ====   1011
 */


package gaoXiaoBang;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class 第三章散列原理_设计方案 {
	public static void main(String[] args) {
		MyHashMap mhm = new MyHashMap();
		mhm.putToParking("京NHK936", 1000);
		mhm.putToParking("鲁AAAA03", 1006);
		mhm.putToParking("浙K03666", 1010);
		mhm.putToParking("粤A09000", 1011);
		System.out.println(mhm.getFromParking("浙K03666"));
	}
	static class MyHashMap extends HashMap<String, Integer> {
		private static final long serialVersionUID = 1L;
		HashMap<Long, Integer> myHashMap = new HashMap<Long, Integer>();
		public int getFromParking(String str) {
			return myHashMap.get(translateStringToLong(str));
		}
		public void cleanInParking() {
			myHashMap.clear();
		}
		public boolean containsKeyInParking(String str) {
			return myHashMap.containsKey(translateStringToLong(str));
		}
		public boolean containsValueInParking(int myInt) {
			return myHashMap.containsValue(myInt);
		}
		public Set<java.util.Map.Entry<Long, Integer>> entrySetInParking() {
			return myHashMap.entrySet();
		}
		public int getInParking(String str) {
			return myHashMap.get(translateStringToLong(str));
		}
		public boolean isEmptyInParking() {
			return myHashMap.isEmpty();
		}
		public Set<Long> keySetInParking() {
			return myHashMap.keySet();
		}
		public void putToParking(String str, int myInt) {
			myHashMap.put(translateStringToLong(str), myInt);
		}
		public void putAllToParking(Map<? extends Long, ? extends Integer> m) {
			myHashMap.putAll(m);
		}
		public Integer removeFromParking(String str) {
			return myHashMap.remove(translateStringToLong(str));
		}
		public int sizeOfParking() {
			return myHashMap.size();
		}
		public Collection<?> valueOfParking() {
			return myHashMap.values();
		}
		private Long translateStringToLong(String str) {
			//车牌的首位都是汉字，其余是6位数字或者是字母（一般不区分大小写）
			long reLong = 0l;
			try {
				char[] strChar = str.toCharArray();
				byte[] gbkTemp = String.valueOf(strChar[0]).getBytes("gbk");
				reLong = reLong * 1000 + gbkTemp[0] + 128;
				reLong = reLong * 1000 + gbkTemp[1] + 128;
				for (int i = 1 ; i < strChar.length; ++ i)
					reLong = reLong * 100 + strChar[i] - '0';
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return new Long(reLong);
		}
	}
}
