package javaPlatform.thread;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class Reference {
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		@SuppressWarnings("unchecked")
		SoftReference<Integer> [] p = new SoftReference[100];
		p[1] = new SoftReference<Integer>(new Integer(1));
		if (p != null) 
			System.out.println("p is not null");
				
		ReferenceQueue<String> myQueue = new ReferenceQueue<String>();
		WeakReference<String> str = new WeakReference<String>("string", myQueue);
		
		SoftReference<String> str2 = new SoftReference<String>("AAA");
		String AAA = str2.get();
		System.out.println(AAA);
		
		System.out.println(p[1].get());
		
		MyClass myc = new MyClass();
		SoftReference<MyClass> myclass = new SoftReference<MyClass>(myc);
		MyClass mycClone = myclass.get();
		System.out.println(mycClone.toString());
		
		System.gc();
		
		
		System.runFinalization();
		
		
		HashMap<Integer, SoftReference<MyClass>> hm = new HashMap<Integer, SoftReference<MyClass>>(100);
		SoftReference<MyClass> soft = new SoftReference<MyClass>((MyClass)null);
		hm.put(1, soft);
		if (hm.get(0) == null)
			System.out.println("hm has a not null Object");
		
		
		try {
			Thread.currentThread().sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (myQueue.poll() != null)
			System.out.println("myQueue has an Object");
		
		if (str != null)
			System.out.println("str is not null");
		
		System.runFinalization();
	}
	
	static class MyClass {
		@Override
		public boolean equals (Object x) {
			return super.equals(x);
		}
		@Override
		public int hashCode () {
			return super.hashCode();
		}
	}
}
