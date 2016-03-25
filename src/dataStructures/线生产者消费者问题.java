package dataStructures;

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * �������������������ķ������Է�Ϊ���ࣺ
 * 1������ĳ�ֻ��Ʊ��������ߺ�������֮���ͬ����
 * 2����������������֮�佨��һ���ܵ���
 * �����������ķ�����
 * 1��ͬ�������нϸ�Ч�ʲ�������ʵ�֣�����ɿ��Ժã����ڳ���ģʽ
 * 2���ܵ������ܵ����������׿��ƣ����������ݶ����׷�װ�ȣ�ʵ���Բ�ǿ��                                                           
 */
public class ������������������ {
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
		
		
		
		
		// ʹ�� ReentrantLock lock.await() lock.notifyAll()
		
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
	// wait/notify����
	// wait()/notify()�ǻ���Object����������
	//wait()������������������/��ʱ��������/�������߳�ֹͣ�Լ���ִ��
	//��������ʹ�Լ����ڵȴ�״̬���������߳�ִ��
	//notify()��������������/�������򻺳�������/ȡ��һ����Ʒʱ���������ȴ�
	//���̷߳�����ִ�е�֪ͨ��ͬʱ��������ʹ�Լ����ڵȴ�״̬
	static class Storage1 {
		private final int MAX_SIZE = 100;
		private LinkedList<Object> list = new LinkedList<Object>();
		public void produce(int num) {
			synchronized(list) {
				while(list.size() + num > MAX_SIZE) {
					System.out.println("Ҫ�����Ĳ�Ʒ������"+num+"\t�����:"+
							list.size()+"\t��ʱ����ִ����������");
					try {
						list.wait();
					} catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
				for(int i = 1; i <= num; ++ i) {
					list.add(new Object());
				}
				System.out.println("�Ѿ�������"+num+"\t�ֿ������"+list.size());
				list.notifyAll();
			}
		}
		public void consume(int num) {
			synchronized(list) {
				while(list.size() < num) {
					System.out.println("Ҫ���ѵ�������"+num+"\t�������"+list.size()+"\t��ʱ����ִ����������");
					try {
						list.wait();
					} catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
				for(int i = 1; i <= num; ++ i) {
					list.remove();
				}
				System.out.println("�Ѿ����ѣ�"+num+"\t�������"+list.size());
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
	 * await()/signal()����
	 * JDK5.0֮��Java�ṩ�˸��ӽ�׳���̴߳�����ƣ�����ͬ�����������̳߳صȣ�
	 * ���ǿ���ʵ�ָ�ϸ���ȵ��߳̿��ơ�await()��signal()��������������ͬ�������ַ�����
	 * ���ǵĹ��ܻ����Ϻ�wait()/notify()��ͬ����ȫ����ȡ�����ǣ��������Ǻ����������������Lockֱ�ӹҹ�
	 * ���и��������ԡ�ͨ��Lock�����ϵ���newCondition()������������������һ����������а󶨣�
	 * �������Ʋ���������ʾ�����Դ�İ�ȫ��
	 */
	
	static class Storage2 {
		private final int MAX_SIZE = 100;
		private LinkedList<Object> list = new LinkedList<Object>();
		private final Lock lock = new ReentrantLock();
		// �ֿ�������������
		private final Condition full = lock.newCondition();
		// �ֿ�յ���������
		private final Condition empty = lock.newCondition();
		// ����num����Ʒ
		public void produce(int num) {
			//�����
			lock.lock();
			while (list.size() + num > MAX_SIZE) {
				System.out.println("Ҫ�����Ĳ�Ʒ������"+num+"\t�������"+list.size()+"\t��ʱ����ִ����������");
				try {
					full.await();
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int i = 1; i <= num; ++ i) {
				list.add(new Object());
			}
			System.out.println("�Ѿ�������Ʒ����"+num+"\t�ֲִ���Ϊ��"+list.size());
			// �������������߳�
			full.signalAll();
			empty.signalAll();
			
			lock.unlock();
		}
		public void consume(int num) {
			lock.lock();
			while (list.size() < num) {
				System.out.println("Ҫ���ѵĲ�Ʒ��������"+num+"\t�������"+list.size());
				try {
					empty.await();
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			for(int i = 1; i <= num; ++ i) {
				list.removeFirst();
			}
			System.out.println("�Ѿ����Ѳ�Ʒ����"+num+"\t�������"+list.size());
			
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
	 * BlockingQueue�������з���
	 * BlockingQueue�� JDK5.0���������ݣ�����һ���Ѿ����ڲ�ʵ����ͬ���Ķ��У�
	 * ʵ�ַ�ʽ���õ������ǵ�2��await()/singal()�����������������ɶ���ʱ��
	 * ָ�������Ĵ�С��������������������put()��take()������
	 * put()����������������������������̣߳������ﵽ���ʱ���Զ�����
	 * take()����:����������������������̣߳�����Ϊ0ʱ���Զ�������
	 * 
	 */
	
	public class Storage3 {
		private final int MAX_SIZE = 100;
		private LinkedBlockingQueue<Object> list = new LinkedBlockingQueue<Object>();
		public void produce(int num) {
			//�������д��ݴ���
			// �������徯�����
			if (MAX_SIZE > 99) {
				System.out.println();
			}
			if (list == null) {
				System.out.println();
			}
		}
	}
	
	
}
