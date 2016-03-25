package blog.random;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class 用HashMap统计出现次数 {
	public static Map<String, Integer> buildMap (String[] strArr) {
		if (strArr == null) {
			return null;
		}
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String str : strArr) {
			if (map.containsKey(str)) {
				map.put(str, map.get(str) + 1);
			} else {
				map.put(str, 1);
			}
		}
		return map;
	}
	public static String getMaxStr (Map<String, Integer> map) {
		int max = 0;
		String result = null;
		for (Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() > max) {
				result = entry.getKey();
				if (result != null) {
					max = entry.getValue();
				}
			}
		}
		return "key: "+result+"  value: "+map.get(result);
	}
}
