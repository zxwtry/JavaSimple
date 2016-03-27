package javaPlatform.thread;

/*
 * 线程池的作用就是限制系统中执行线程的数量
 * 根据系统的环境情况，可以自动或手动设置线程数量，达到运行的最佳效果；
 * 少了浪费系统资源，多了造成系统拥挤效率不高。
 * 一个任务执行完毕，再从队列的最前面的任务开始执行。
 * 若队列中没有等待进程，线程池的这一资源处于等待。
 * 当一个新任务需要运行时，如果线程池中有等待的工作线程，
 * 就可以开始运行了；否则进入等待队列
 */

import java.util.LinkedList;

public class 线程池之自定义线程池 {
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
		private boolean isClose = false;	// 线程池是否关闭
		private LinkedList<Runnable> workQueue;		// 工作队列
		
		public MyThreadPool(int poolSize) {
			// 调用父类构造方法，指定ThreadGroup的名称
			super("threadPoolId" + "");
			// 继承的方法，设置是否是指守护线程池
			setDaemon(true);
			// 创建工作队列
			workQueue = new LinkedList<Runnable>();
			for (int i = 0; i < poolSize; i ++) {
				// 创建并启动工作线程，创建线程池最大容量数的工作线程
				new WorkThread(i).start();
			}
		}
		
		// 向工作线程中添加一个任务，有工作线程来执行该任务
		public synchronized void execute (Runnable task) {
			if (isClose) {
				throw new IllegalStateException();
			}
			if (null != task) {
				// 向消息队列中添加一个任务
				workQueue.add(task);
				// 唤醒一个正在getTask()方法中等待任务的工作线程
				notify();
			}
		}
		
		// 从工作队列中取出一个任务，工作线程会调用该方法
		private synchronized Runnable getTask(int threadId) throws InterruptedException {
			while (0 == workQueue.size()) {
				if (isClose) {
					return null;
				}
				// 如果工作线程中没有任务，那么就等着
				wait();
			}
			System.out.println("工作线程"+threadId+"开始执行任务");
			// 返回队列中的第一个元素，并从队列中删除
			return workQueue.removeFirst();
		}
		
		// 等待工作线程把任务执行完成
		public void waitFinish() {
			synchronized(this) {
				isClose = true;
				// 唤醒所有还在getTash()方法中等待任务的工作线程
				notifyAll();
			}
			// activeCount() 返回改线程组中活动线程的估计值
			Thread[] threads = new Thread[activeCount()];
			// enumerate方法继承自ThreadGroup，根据活动的线程的估计值获得该线程组中当前所有活动的工作线程
			int count = enumerate(threads);
			for (int i = 0; i < count; i ++) {
				try {
					threads[i].join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		// 关闭线程池
		public synchronized void closePool() {
			if (!isClose) {
				// 等待工作线程执行完毕
				waitFinish();
				isClose = true;
				// 清空工作队列
				workQueue.clear();
				// 中断线程池所有的工作线程
				interrupt();
			}
		}
		
		// 工作线程，负责从工作队列中取出任务，并执行
		private class WorkThread extends Thread {
			private int id;
			public WorkThread(int id) {
				// 父类构造，将线程加入到当前ThreadPool线程组
				super(MyThreadPool.this, id + "");
				this.id = id;
			}
			@Override
			public void run() {
				while (! isInterrupted()) {
					Runnable task = null;
					try {
						// 取出任务
						task = getTask(id);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					// 如果getTask()返回null 或者
					// 线程执行getTask()时被中断，则
					// 借宿此线程
					if (null == task) {
						return;
					}
					// 运行任务
					task.run();
				}
			}
		}
	}
}
