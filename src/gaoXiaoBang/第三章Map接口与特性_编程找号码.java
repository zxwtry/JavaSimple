/*

��֪ĳ��Map�д洢�˵�ַ���ʱ��ӳ�䣺

�����ׯ ---> 100086
�з����ӳ� ---> 100086
�йش庣�� ----> 100088
������ѧ ----> 100080
�찲�� ---> 100020
�Ͷ���԰ -->100020
���� ---> 100021
��ɽ��԰ --->100020
...
...

���Կ�����ͬ�����ʱ���ܶ�Ӧ�����ַ��
�����ҳ�����Ӧ��ַ��Ŀ�����ʱ���루������е�һ��Ҫ�г�����

 */

package gaoXiaoBang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ������Map�ӿ�������_����Һ��� {
	public static void main(String[] args) {
		MyMap myMap = new MyMap();
		myMap.add("�����ׯ", 100086);
		myMap.add("�з����ӳ�", 100086);
		myMap.add("�йش庣��", 100088);
		myMap.add("������ѧ", 100080);
		myMap.add("�찲��", 100020);
		myMap.add("�Ͷ���԰", 100020);
		myMap.add("����", 100021);
		myMap.add("��ɽ��԰", 100020);
		myMap.add("AAAA", 100086);
		System.out.println(myMap.getMax());
	}
	static class MyMap {
		Map<String, Integer> myMap;
		public MyMap() {
			myMap = new HashMap<String, Integer>();
		}
		public void add(String address, int postNumber) {
			myMap.put(address, postNumber);
		}
		public String getMax() {
			StringBuffer st = new StringBuffer();
			Object[] obj = myMap.keySet().toArray();
			Map<Integer, List<String>> myReturnMap = new HashMap<Integer, List<String>>();
			for (int i = 0; i < obj.length; ++ i) {
				int intTemp = myMap.get(String.valueOf(obj[i]));
				if (myReturnMap.containsKey(intTemp)) {
					List<String> listTemp = myReturnMap.get(intTemp);
					listTemp.add(String.valueOf(obj[i]));
				} else {
					List<String> listTemp = new ArrayList<String>();
					listTemp.add(String.valueOf(obj[i]));
					myReturnMap.put(intTemp, listTemp);
				}
			}
			int maxForReturn = Integer.MIN_VALUE;
			List<Integer> maxList = new ArrayList<Integer>();
			Object[] objReturn = myReturnMap.keySet().toArray();
			for (int i = 0; i < objReturn.length; ++ i) {
				int iTemp = myReturnMap.get(objReturn[i]).size();
				if (maxForReturn == iTemp) {
					maxList.add((Integer)objReturn[i]);
				} else if (maxForReturn < iTemp) {
					maxList.clear();
					maxList.add((Integer)objReturn[i]);
					maxForReturn = iTemp;
				}
			}
			Iterator<Integer> it = maxList.iterator();
			st.append("��Ӧ��ַ��Ŀ����ǣ�" +maxForReturn+ "\n");
			while (it.hasNext()) {
				int intTemp = it.next();
				st.append("�ʱ��ǣ�" + intTemp +"\n");
				Iterator<String> iit = myReturnMap.get(intTemp).iterator();
				while(iit.hasNext()) {
					st.append(iit.next());
					st.append("   ");
				}
				st.append("\n");
			}
			return st.toString();
		}
	}
}
