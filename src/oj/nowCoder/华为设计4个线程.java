package oj.nowCoder;
/*
 * 	设计4个线程,其中两个线程没i对j增加1， 另外两个小城对j每次减少1
 * 	写出程序。
 */
public class 华为设计4个线程 {
	static Object synObj = new Object();
	static int i = 0, j = 0; 
	public static void main(String[] args) {
//		new Thread1().start();
//		new Thread2().start();
//		new Thread3().start();
//		new Thread4().start();
		ThreadTest1.main(null);
	}
	static class Thread1 extends Thread {
		@Override
		public void run() {
			synchronized(synObj) {
				i ++;
			}
			System.out.println("i : "+ i +"\tj : "+j);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	static class Thread2 extends Thread {
		@Override
		public void run() {
			synchronized(synObj) {
				i ++;
			}
			System.out.println("i : "+ i +"\tj : "+j);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	static class Thread3 extends Thread {
		@Override
		public void run() {
			synchronized(synObj) {
				j --;
			}
			System.out.println("i : "+ i +"\tj : "+j);
		}
	}
	static class Thread4 extends Thread {
		@Override
		public void run() {
			synchronized(synObj) {
				j --;
			}
			System.out.println("i : "+ i +"\tj : "+j);
		}
	}
	static class ThreadTest1 {
		private int j;
		public static void main (String[] args) {
			ThreadTest1 tt = new ThreadTest1();
			Dec dec = tt.new Dec();
			Inc inc = tt.new Inc();
			for (int i = 0; i < 2; i ++) {
				Thread t = new Thread(inc);
				t.start();
				t = new Thread(dec);
				t.start();
			}
		}
		private synchronized void inc() {
			i ++;
			System.out.println(Thread.currentThread().getName()
					+ "-inc." + j);
		}
		private synchronized void dec() {
			i --;
			System.out.println(Thread.currentThread().getName()
					+ "-dec." + j);
		}
		class Inc implements Runnable {
			@Override
			public void run() {
				for (int k = 0; k < 100; k ++) {
					inc();
				}
			}
		}
		class Dec implements Runnable {
			@Override
			public void run() {
				for (int k = 0; k < 100; k ++) {
					dec();
				}
			}
		}
	}
}
