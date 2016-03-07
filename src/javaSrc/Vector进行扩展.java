package javaSrc;

import java.util.Vector;

/*

					Vector

1,继承关系：			  java.util.Vector<E>
			extends   java.util.AbstractList<E>
			extends   java.utilAbstractCollection<E>
			extends   java.lang.Object;
			
2,已经实现的接口
					  Serializable
					  Cloneable
					  Iterable<E>
					  Collection<E>
					  List<E>
					  RandomAccess

3,直接已知子类
					  Stack




 */

public abstract class Vector进行扩展 {
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
