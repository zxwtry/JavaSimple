package javaPlatform.thread;

/*
 * �̳߳ص����þ�������ϵͳ��ִ���̵߳�����
 * ����ϵͳ�Ļ�������������Զ����ֶ������߳��������ﵽ���е����Ч����
 * �����˷�ϵͳ��Դ���������ϵͳӵ��Ч�ʲ��ߡ�
 * һ������ִ����ϣ��ٴӶ��е���ǰ�������ʼִ�С�
 * ��������û�еȴ����̣��̳߳ص���һ��Դ���ڵȴ���
 * ��һ����������Ҫ����ʱ������̳߳����еȴ��Ĺ����̣߳�
 * �Ϳ��Կ�ʼ�����ˣ��������ȴ�����
 */

import java.util.LinkedList;

public class �̳߳�֮�Զ����̳߳� {
	public static void main(String[] args) {
		MyThreadPool threadPool = new MyThreadPool(4);
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		for (int i = 0; i < 7; i ++) {
			final int index = i;
			
			threadPool.execute(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println("new in main" + index);
				}
				
			});
			
			threadPool.waitFinish();
			threadPool.closePool();
		}
	}
	
	static class MyThreadPool extends ThreadGroup{
		private boolean isClose = false;	// �̳߳��Ƿ�ر�
		private LinkedList<Runnable> workQueue;		// ��������
		
		public MyThreadPool(int poolSize) {
			// ���ø��๹�췽����ָ��ThreadGroup������
			super("threadPoolId" + "");
			// �̳еķ����������Ƿ���ָ�ػ��̳߳�
			setDaemon(true);
			// ������������
			workQueue = new LinkedList<Runnable>();
			for (int i = 0; i < poolSize; i ++) {
				// ���������������̣߳������̳߳�����������Ĺ����߳�
				new WorkThread(i).start();
			}
		}
		
		// �����߳������һ�������й����߳���ִ�и�����
		public synchronized void execute (Runnable task) {
			if (isClose) {
				throw new IllegalStateException();
			}
			if (null != task) {
				// ����Ϣ���������һ������
				workQueue.add(task);
				// ����һ������getTask()�����еȴ�����Ĺ����߳�
				notify();
			}
		}
		
		// �ӹ���������ȡ��һ�����񣬹����̻߳���ø÷���
		private synchronized Runnable getTask(int threadId) throws InterruptedException {
			while (0 == workQueue.size()) {
				if (isClose) {
					return null;
				}
				// ��������߳���û��������ô�͵���
				wait();
			}
			System.out.println("�����߳�"+threadId+"��ʼִ������");
			// ���ض����еĵ�һ��Ԫ�أ����Ӷ�����ɾ��
			return workQueue.removeFirst();
		}
		
		// �ȴ������̰߳�����ִ�����
		public void waitFinish() {
			synchronized(this) {
				isClose = true;
				// �������л���getTash()�����еȴ�����Ĺ����߳�
				notifyAll();
			}
			// activeCount() ���ظ��߳����л�̵߳Ĺ���ֵ
			Thread[] threads = new Thread[activeCount()];
			// enumerate�����̳���ThreadGroup�����ݻ���̵߳Ĺ���ֵ��ø��߳����е�ǰ���л�Ĺ����߳�
			int count = enumerate(threads);
			for (int i = 0; i < count; i ++) {
				try {
					threads[i].join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		// �ر��̳߳�
		public synchronized void closePool() {
			if (!isClose) {
				// �ȴ������߳�ִ�����
				waitFinish();
				isClose = true;
				// ��չ�������
				workQueue.clear();
				// �ж��̳߳����еĹ����߳�
				interrupt();
			}
		}
		
		// �����̣߳�����ӹ���������ȡ�����񣬲�ִ��
		private class WorkThread extends Thread {
			private int id;
			public WorkThread(int id) {
				// ���๹�죬���̼߳��뵽��ǰThreadPool�߳���
				super(MyThreadPool.this, id + "");
				this.id = id;
			}
			@Override
			public void run() {
				while (! isInterrupted()) {
					Runnable task = null;
					try {
						// ȡ������
						task = getTask(id);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					// ���getTask()����null ����
					// �߳�ִ��getTask()ʱ���жϣ���
					// ���޴��߳�
					if (null == task) {
						return;
					}
					// ��������
					task.run();
				}
			}
		}
	}
}
