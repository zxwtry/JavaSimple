package dataStructures;

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 解决生产者消费者问题的方法可以分为两类：
 * 1，采用某种机制保护生产者和消费者之间的同步；
 * 2，在生产者消费者之间建立一个管道。
 * 对上述方法的分析：
 * 1，同步法，有较高效率并且易于实现，代码可控性好，属于常用模式
 * 2，管道法：管道缓冲区不易控制，被传输数据对象不易封装等，实用性不强。                                                           
 */
public class 线生产者消费者问题 {
	public static void main(String[] args) {
//		Storage1 storage = new Storage1();
//		
//		Producer1 p1 = new Producer1(storage);
//		Producer1 p2 = new Producer1(storage);
//		Producer1 p3 = new Producer1(storage);
//		Producer1 p4 = new Producer1(storage);
//		Producer1 p5 = new Producer1(storage);
//		Producer1 p6 = new Producer1(storage);
//		Producer1 p7 = new Producer1(storage);
//		Producer1 p8 = new Producer1(storage);
//		
//		Consumer1 c1 = new Consumer1(storage);
//		Consumer1 c2 = new Consumer1(storage);
//		Consumer1 c3 = new Consumer1(storage);
//		
//		p1.setNum(10);
//		p2.setNum(10);
//		p3.setNum(10);
//		p4.setNum(10);
//		p5.setNum(10);
//		p6.setNum(10);
//		p7.setNum(10);
//		p8.setNum(80);
//		
//		c1.setNum(50);
//		c2.setNum(50);
//		c3.setNum(50);
//		
//		c1.start();
//		c2.start();
//		c3.start();
//		
//		p1.start();
//		p2.start();
//		p3.start();
//		p4.start();
//		p5.start();
//		p6.start();
//		p7.start();
//		p8.start();
		
		
		
		
		// 使用 ReentrantLock lock.await() lock.notifyAll()
		
		Storage2 storage = new Storage2();
		
		Producer2 p1 = new Producer2(storage);
		Producer2 p2 = new Producer2(storage);
		Producer2 p3 = new Producer2(storage);
		Producer2 p4 = new Producer2(storage);
		Producer2 p5 = new Producer2(storage);
		Producer2 p6 = new Producer2(storage);
		Producer2 p7 = new Producer2(storage);
		Producer2 p8 = new Producer2(storage);
		
		Consumer2 c1 = new Consumer2(storage);
		Consumer2 c2 = new Consumer2(storage);
		Consumer2 c3 = new Consumer2(storage);
		
		p1.setNum(10);
		p2.setNum(10);
		p3.setNum(10);
		p4.setNum(10);
		p5.setNum(10);
		p6.setNum(10);
		p7.setNum(10);
		p8.setNum(80);
		
		c1.setNum(50);
		c2.setNum(50);
		c3.setNum(50);
		
		c1.start();
		c2.start();
		c3.start();
		
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
		p6.start();
		p7.start();
		p8.start();
		
	}
	/**
	 * 
	 */
	// wait/notify方法
	// wait()/notify()是基类Object的两个方法
	//wait()方法：当缓冲区已满/空时，生产者/消费者线程停止自己的执行
	//放弃锁，使自己处于等待状态，让其他线程执行
	//notify()方法，当生产者/消费者向缓冲区放入/取出一个产品时，向其他等待
	//的线程发出可执行的通知，同时放弃锁，使自己处于等待状态
	static class Storage1 {
		private final int MAX_SIZE = 100;
		private LinkedList<Object> list = new LinkedList<Object>();
		public void produce(int num) {
			synchronized(list) {
				while(list.size() + num > MAX_SIZE) {
					System.out.println("要生产的产品数量："+num+"\t库存量:"+
							list.size()+"\t暂时不能执行生产任务！");
					try {
						list.wait();
					} catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
				for(int i = 1; i <= num; ++ i) {
					list.add(new Object());
				}
				System.out.println("已经生产："+num+"\t现库存量："+list.size());
				list.notifyAll();
			}
		}
		public void consume(int num) {
			synchronized(list) {
				while(list.size() < num) {
					System.out.println("要消费的数量："+num+"\t库存量："+list.size()+"\t暂时不能执行消费任务");
					try {
						list.wait();
					} catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
				for(int i = 1; i <= num; ++ i) {
					list.remove();
				}
				System.out.println("已经消费："+num+"\t库存量："+list.size());
				list.notifyAll();
			}
		}
	}
	static class Producer1 extends Thread {
		private int num;
		private Storage1 storage;
		public Producer1(Storage1 storage) {
			this.storage = storage;
		}
		public void run() {
			produce(num);
		}
		public void produce(int num) {
			storage.produce(num);
		}
		public int getNum() {
			return num;
		}
		public void setNum(int num) {
			this.num = num;
		}
		public Storage1 getStorage() {
			return storage;
		}
		public void setStorage(Storage1 storage) {
			this.storage = storage;
		}
	}
	static class Consumer1 extends Thread {
		private int num;
		private Storage1 storage;
		public Consumer1(Storage1 storage) {
			this.storage = storage;
		}
		@Override
		public void run() {
			consume(num);
		}
		public void consume(int num) {
			storage.consume(num);
		}
		public int getNum() {
			return num;
		}
		public void setNum(int num) {
			this.num = num;
		}
		public Storage1 getStorage() {
			return storage;
		}
		public void setStorage(Storage1 storage) {
			this.storage = storage;
		}
	}
	
	/*
	 * await()/signal()方法
	 * JDK5.0之后，Java提供了更加健壮的线程处理机制，包括同步、锁定、线程池等，
	 * 它们可以实现更细粒度的线程控制。await()和signal()就是其中用来做同步的两种方法，
	 * 它们的功能基本上和wait()/notify()相同，完全可以取代它们，但是他们和新引入的锁定机制Lock直接挂钩
	 * 具有更大的灵活性。通过Lock对象上调用newCondition()方法，将条件变量和一个锁对象进行绑定，
	 * 进而控制并发程序访问竞争资源的安全。
	 */
	
	static class Storage2 {
		private final int MAX_SIZE = 100;
		private LinkedList<Object> list = new LinkedList<Object>();
		private final Lock lock = new ReentrantLock();
		// 仓库满的条件变量
		private final Condition full = lock.newCondition();
		// 仓库空的条件变量
		private final Condition empty = lock.newCondition();
		// 生产num个产品
		public void produce(int num) {
			//获得锁
			lock.lock();
			while (list.size() + num > MAX_SIZE) {
				System.out.println("要生产的产品数量："+num+"\t库存量："+list.size()+"\t暂时不能执行生产任务！");
				try {
					full.await();
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int i = 1; i <= num; ++ i) {
				list.add(new Object());
			}
			System.out.println("已经生产产品数："+num+"\t现仓储量为："+list.size());
			// 唤醒其他所有线程
			full.signalAll();
			empty.signalAll();
			
			lock.unlock();
		}
		public void consume(int num) {
			lock.lock();
			while (list.size() < num) {
				System.out.println("要消费的产品的数量："+num+"\t库存量："+list.size());
				try {
					empty.await();
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			for(int i = 1; i <= num; ++ i) {
				list.removeFirst();
			}
			System.out.println("已经消费产品数："+num+"\t库存量："+list.size());
			
			full.signalAll();
			empty.signalAll();

			lock.unlock();
		}
		public int getMAX_SIZE() {
			return MAX_SIZE;
		}
		public LinkedList<Object> getList() {
			return list;
		}
		public void setList(LinkedList<Object> list) {
			this.list = list;
		}
	}
	
	static class Producer2 extends Thread {
		private int num;
		private Storage2 storage;
		public Producer2(Storage2 storage) {
			this.storage = storage;
		}
		public void run() {
			produce(num);
		}
		public void produce(int num) {
			storage.produce(num);
		}
		public int getNum() {
			return num;
		}
		public void setNum(int num) {
			this.num = num;
		}
		public Storage2 getStorage() {
			return storage;
		}
		public void setStorage(Storage2 storage) {
			this.storage = storage;
		}
	}
	static class Consumer2 extends Thread {
		private int num;
		private Storage2 storage;
		public Consumer2(Storage2 storage) {
			this.storage = storage;
		}
		@Override
		public void run() {
			consume(num);
		}
		public void consume(int num) {
			storage.consume(num);
		}
		public int getNum() {
			return num;
		}
		public void setNum(int num) {
			this.num = num;
		}
		public Storage2 getStorage() {
			return storage;
		}
		public void setStorage(Storage2 storage) {
			this.storage = storage;
		}
	}
	
	/*
	 * BlockingQueue阻塞队列方法
	 * BlockingQueue是 JDK5.0的新增内容，它是一个已经在内部实现了同步的队列，
	 * 实现方式采用的是我们第2中await()/singal()方法。它可以在生成对象时，
	 * 指定容量的大小。它用于阻塞操作的是put()和take()方法。
	 * put()方法：类似于我们上面的生产者线程，容量达到最大时，自动阻塞
	 * take()方法:类似于我们上面的消费者线程，容量为0时，自动阻塞。
	 * 
	 */
	
	public class Storage3 {
		private final int MAX_SIZE = 100;
		private LinkedBlockingQueue<Object> list = new LinkedBlockingQueue<Object>();
		public void produce(int num) {
			//不想继续写这份代码
			// 以下是清警告代码
			if (MAX_SIZE > 99) {
				System.out.println();
			}
			if (list == null) {
				System.out.println();
			}
		}
	}
	
	
}
