package jianZhiOffer;

import java.util.HashMap;
import java.util.Map;

/*

����1��������ֻ����һ��ʵ����
����2������������Լ������Լ���Ψһʵ����
����3�������������������������ṩ��һʵ����

 */


public class ��00����ģʽ {
	public static void main(String[] args) {
		MySingleton1 s1 = MySingleton1.getSingleton();   //����ģʽ
		MySingleton1 s2 = MySingleton1.getSingleton();
		if (s1 == s2)
			System.out.println(true);		//�����true
		MySingletonOut s3 = MySingletonOut.getInstance();
		MySingletonOut s4 = MySingletonOut.getInstance();
		if (s3 == s4)
			System.out.println(true);		//�����true
		
		MySingleton2 s5 = MySingleton2.getSingleton();   //����ģʽ
		MySingleton2 s6 = MySingleton2.getSingleton();
		if (s5 == s6)
			System.out.println(true);		//�����true
		
		MySingleton11 s7 = MySingleton11.getSingleton();   //����ģʽ���޸�
		MySingleton11 s8 = MySingleton11.getSingleton();
		if (s7 == s8)
			System.out.println(true);		//�����true
		
		MySingleton12 s9  = MySingleton12.getSingleton();   //����ģʽ���޸ĵĴ���ʾ��
		MySingleton12 s10 = MySingleton12.getSingleton();
		if (s9 == s10)
			System.out.println(true);		//�����true;���ܻ������һ����
		
		MySingleton3 s11 = MySingleton3.getSingleton();   //˽�о�̬�ڲ���
		MySingleton3 s12 = MySingleton3.getSingleton();
		if (s11 == s12)
			System.out.println(true);		//�����true
		
		MySingleton4 s13 = MySingleton4.getSingleton(null);   //˽�о�̬�ڲ���
		MySingleton4 s14 = MySingleton4.getSingleton(null);
		if (s13 == s14)
			System.out.println(true);		//�����true
		
	}
	static class MySingleton1 {
		//��̬�ڲ���
		//�ڵ���ģʽ�У�����Ҫ�� class MySingleton ֮ǰ����static
		//����ģʽ��������ģʽ
		private static MySingleton1 single;
		private MySingleton1 () {}
		public static synchronized MySingleton1  getSingleton () {
			if (single == null)
				single = new MySingleton1();
			return single;
		}
	}
	static class MySingleton2 {
		//����ģʽ
		//������ģʽ�Ĳ�ͬ�ǣ�����Ҫ���ͬ���飬���ԱȽϼ�
		private static MySingleton2 single = new MySingleton2();
		private MySingleton2 () {}
		public static MySingleton2 getSingleton () {
			return single;
		}
	}
	
	//���������Ǻܶ��������ģʽ���޸�
	static class MySingleton11 {
		//˫�ؼ�⣬��Ҫע��д��
		//ע����һ��������У�����һ�δ������ʾ��
		private static MySingleton11 single = null;
		private MySingleton11 () {}
		public static MySingleton11 getSingleton () {
			if (single == null) {
				synchronized(MySingleton11.class) {
					MySingleton11 singleTemp = single;
					if (singleTemp == null) {
						singleTemp = new MySingleton11();
						single = singleTemp;
					}
				}
			}
			return single;
		}
	}
	static class MySingleton12 {
		//����MySingleton11�Ĵ���ʾ��
		//��������ķ�ʽ�ǽ���������дΪ
		//private static volatile MySingleton12 single = null;
		private static MySingleton12 single = null;
		private MySingleton12 () {}
		public static MySingleton12 getSingleton () {
			if (single == null) {
				synchronized (MySingleton12.class) {
					if (single == null) {
						single = new MySingleton12();
					}
				}
			}
			return single;
		}
	}
	
	//ʵ�ֵ�������һ�ַ�ʽ���ڲ���
	//ע��������ڲ��྿������ʲô�ط�
	static class MySingleton3 {
		private MySingleton3 () {}
		private static class MySingleton3Holder {
			private final static MySingleton3 INSTANCE = new MySingleton3();
		}
		public static MySingleton3 getSingleton () {
			return MySingleton3Holder.INSTANCE;
		}
	}
	
	//�Ǽ�ʽ����
	static class MySingleton4 {
		private static Map<String, MySingleton4> singletonMap 
					= new HashMap<String, MySingleton4>();
		static {
			MySingleton4 single = new MySingleton4();
			singletonMap.put(single.getClass().getName(), single);
		}
		private MySingleton4 () {}
		//��̬������������������Ψһ��ʵ��
		public static MySingleton4 getSingleton(String name) {
			if (name == null) {
				name = MySingleton4.class.getName();
			}
			if (singletonMap.get(name) == null) {
				try {
					singletonMap.put(name, (MySingleton4)Class.forName(name).newInstance());
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
			return singletonMap.get(name);
		}
	}
	
}

class MySingletonOut {
	//���ڲ��࣬class MySingletonOutǰ�治�����static
	private MySingletonOut () {}
	private static MySingletonOut single = null;
	public static MySingletonOut getInstance () {
		if (single == null)
			single = new MySingletonOut();
		return single;
	}
}
