/*

已知某个Map中存储了地址到邮编的映射：

海淀黄庄 ---> 100086
中发电子城 ---> 100086
中关村海龙 ----> 100088
北京大学 ----> 100080
天安门 ---> 100020
劳动公园 -->100020
北海 ---> 100021
中山公园 --->100020
...
...

可以看出，同样的邮编可能对应多个地址。
请编程找出：对应地址数目最多的邮编号码（多个并列第一则都要列出）。

 */

package gaoXiaoBang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class 第三章Map接口与特性_编程找号码 {
	public static void main(String[] args) {
		MyMap myMap = new MyMap();
		myMap.add("海淀黄庄", 100086);
		myMap.add("中发电子城", 100086);
		myMap.add("中关村海龙", 100088);
		myMap.add("北京大学", 100080);
		myMap.add("天安门", 100020);
		myMap.add("劳动公园", 100020);
		myMap.add("北海", 100021);
		myMap.add("中山公园", 100020);
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
			st.append("对应地址数目最大是：" +maxForReturn+ "\n");
			while (it.hasNext()) {
				int intTemp = it.next();
				st.append("邮编是：" + intTemp +"\n");
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
