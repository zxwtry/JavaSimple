package javaPlatform.thread;

import java.util.LinkedList;

public class 死锁检测JConsole {
	public static void main (String[] args) {
//		A a = new A();
		B a = new B();
		Thread t1 = new Thread(a);
		Thread t2 = new Thread(a);
		Thread t3 = new Thread(a);
		Thread t4 = new Thread(a);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		
		new Thread (new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("AAAA");
				}
			}
			
		}).start();
		
	}
	
	static class B implements Runnable {
		// 建立一个，互斥访问量
		private LinkedList<Integer> list = new LinkedList<Integer>();
		{
			for (int i = 0 ; i < 10; i ++) {
				list.add(i * i);
			}
		}
		
		// run方法
		public void run() {
			while (true) {
				synchronized (list) {
					if (list.size() > 0) {
						Integer x = list.get(0);
						System.out.println(x);
						list.remove(x);
					} else
						try {
							list.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	
	static class A implements Runnable{
		@Override
		public void run () {
			while (true) {
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("AAAA");
			}
		}
		
	}
}
