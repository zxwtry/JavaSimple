package javaSrc;

import java.util.Vector;

/*

					Vector

1,�̳й�ϵ��			  java.util.Vector<E>
			extends   java.util.AbstractList<E>
			extends   java.utilAbstractCollection<E>
			extends   java.lang.Object;
			
2,�Ѿ�ʵ�ֵĽӿ�
					  Serializable
					  Cloneable
					  Iterable<E>
					  Collection<E>
					  List<E>
					  RandomAccess

3,ֱ����֪����
					  Stack




 */

public abstract class Vector������չ {
	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>();
		System.out.println(v.capacity());
		for (int i = 0; i < 10; i ++) {
			v.addElement(i*i);
		}
		System.out.println(v.capacity());
		v.addElement(3);
		System.out.println(v.capacity());
	}
}
