package dataStructures;

import java.util.Map;

// �������������ͬ������

public class ģӰ��ʵ�� {

}
class Singleton {
	public static Singleton ins = null;
	private Map<String, String> properties = null;
	
	private Singleton () {
	}
	
	public Map<String, String> getProperties () {
		return properties;
	}
	
	private static synchronized void syncInit() {
		if (ins == null) {
			ins = new Singleton ();
		}
	}
	
	public static Singleton getInstance () {
		if (ins == null) {
			syncInit();
		}
		return ins;
	}
	
	public void updateProperties (String key, String value) {
		Singleton shadow = new Singleton();
		shadow.properties.put(key, value);
		
	}
	
}
