package javaSrc;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Map的基本功能 {
	public static void main(String[] args) {
		Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
		myMap.put(1, 100);
		myMap.put(1, 101);
		myMap.put(null, 0);
		System.out.println(myMap.get(1));
		System.out.println(myMap.get(null));
		Hashtable<Integer, Integer> s = new Hashtable<Integer, Integer> ();
		s.put(null, 1);
		System.out.println(s.get(null));
	}
}
