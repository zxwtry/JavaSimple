/*

某个文本文件中存储如下格式信息：

张小兵 北京
胡进 河北
将达民 四川
高力 河北
卢刊令 北京
....

读入这个文件，要求输出内容为：
北京：
卢刊令
张小兵

河北：
高力
胡进

四川：
将达民

....

即，先按省份的拼音序，每个省份内再按姓名拼音序来排列。

 */


package gaoXiaoBang;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class 第三章Map典型应用_按要求排序 {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("C://A.txt"));
			String brTemp = null;
			MyMap myMap = new MyMap();
			while((brTemp = br.readLine()) != null) {
				String[] spites = brTemp.split(" ");
				if (spites.length != 2) {
					System.out.println("Form Wrong");
					break;
				}
				myMap.addToMyMap(spites[1], spites[0]);
			}
			System.out.println(myMap);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	static class MyMap {
		Map<String, List<String>> myMap;
		public MyMap() {
			myMap = new HashMap<String, List<String>>();
		}
		public void addToMyMap(String str1, String str2) {
			if (myMap.containsKey(str1)) {
				List<String> listTemp = myMap.get(str1);
				int listCount = 0;
				Iterator<String> it = listTemp.iterator();
				while(it.hasNext()) {
					if (! compareArray(getNumGBK(it.next()), getNumGBK(str2))) {
						listTemp.add(listCount, str2);
						return;
					}
					listCount ++;
				}
				listTemp.add(str2);
			} else {
				List<String> listTemp = new ArrayList<String>();
				listTemp.add(str2);
				myMap.put(str1, listTemp);
			}
		}
		@Override
		public String toString() {
			StringBuffer st = new StringBuffer();
			Object[] myMapObject = myMap.keySet().toArray();
			for (int i = 0; i < myMapObject.length; ++ i) {
				Object obj = myMapObject[i];
				int j;
				for (j = i-1; j >= 0 && compareArray(getNumGBK(String.valueOf(obj))
						, getNumGBK(String.valueOf(myMapObject[j]))); --j)
					myMapObject[j+1] = myMapObject[j];
				myMapObject[j+1] = obj;
			}
			for (int i = 0; i < myMapObject.length; ++ i) {
				st.append(myMapObject[i]);   st.append(":\n");
				Iterator<String> it = myMap.get(String.valueOf(myMapObject[i])).iterator();
				while(it.hasNext()) {
					st.append(it.next());
					st.append("\n");
				}
				st.append("\n");
			}
			return st.toString();
		}
		private boolean compareArray(int[] arr1, int[] arr2) {
			int minLength = Math.min(arr1.length, arr2.length);
			for (int i = 0; i < minLength; ++ i) {
				if(arr1[i] != arr2[i])
					return arr1[i] < arr2[i];
			}
			return minLength == arr1.length;
		}
		private int[] getNumGBK(String chnStr) {
			int[] intReturn = null;
			try {
				byte[] byteTemp = chnStr.getBytes("gbk");
				intReturn = new int[byteTemp.length/2];
				for (int i = 0; i < intReturn.length; ++ i)
					intReturn[i] = (byteTemp[2*i]+128) * 1000 + (byteTemp[2*i+1]+128);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return intReturn;
		}
	}
}
