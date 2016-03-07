/*

ĳͣ��������Ϊ1000����Ŵ�1000~1999 �����ڱ��λ�ÿ϶������ڵġ���߷��Լ��Ҫͣ��800������

���賵�ƺ��������ƣ�����NHK936�� �����ĺ��֡����֡���ĸ��ϡ�

������Ҫһ�ַ��������Դӳ��ƺſ��ٵؼ�����ó����Ĵ�Լͣ��λ�á�

���������˵绰ѯ��ĳ������λ��ʱ��ֻҪ��һ�³��ƺžͿ����ˡ�

// 9 2 2 3 3 7 2 0 3 6 8 5 4 7 7 5 8 0 7
//   8 7 6 5 4 3 2 1 0 9 8 7 6 5 4 3 2 1

'z' - '0'  ====  74

'Z' - '0'  ====  42

'9' - '0'  ====  74

6λ���ֻ�����ĸ�ܹ�ռ 2*6 = 12λ��

����ԭ�ȵ�˳��ȥ�12-1λ

������ת����Ϊgbk�룬Ӧ������λ��byte����

��λ������128�Ͷ��ɷǸ�����0λ����1000�ټ���1λ

�õ�һ��������6λ�������18-13λ

 */

/*
��NHK936   ====   1000
³AAAA03   ====   1006
��K03666   ====   1010
��A09000   ====   1011
 */


package gaoXiaoBang;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ������ɢ��ԭ��_��Ʒ��� {
	public static void main(String[] args) {
		MyHashMap mhm = new MyHashMap();
		mhm.putToParking("��NHK936", 1000);
		mhm.putToParking("³AAAA03", 1006);
		mhm.putToParking("��K03666", 1010);
		mhm.putToParking("��A09000", 1011);
		System.out.println(mhm.getFromParking("��K03666"));
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
			//���Ƶ���λ���Ǻ��֣�������6λ���ֻ�������ĸ��һ�㲻���ִ�Сд��
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
