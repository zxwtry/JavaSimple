package javaPlatform.thread;


/*


Java通过Executors提供四种线程池，分别为：
newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，
可灵活回收空闲线程，若无可回收，则新建线程。
newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。



 */
public class Java四种线程池 {
	static class A {
		static int a = (b = 3);
		static int b;
		
		public A () {
			System.out.println(a + "..." + b);
		}
	}
	public static void main(String[] args) {
//		myNewCachedThreadPool();
//		myNewFixedThreadPool();
//		myScheduledThreadPool1();
		myScheduledThreadPool2();
//		mySingleThreadPool();
//		System.out.println("ABCDEFGHIJK".substring(2, 3));
	}  	//end of main
	
	static void myNewCachedThreadPool () {
		java.util.concurrent.ExecutorService cachedThreadPool = java.util.concurrent.Executors.newCachedThreadPool();  
		for (int i = 0; i < 10; i++) {  
			final int index = i;  
			  
			cachedThreadPool.execute(new Runnable() {  
				public void run() {
					try {  
						Thread.sleep(1000);  
					} catch (InterruptedException e) {  
						e.printStackTrace();  
					}
					System.out.println("ThreadName:"+Thread.currentThread().getName()+"\t...\t"+"ThreadID:"+Thread.currentThread().getId()+"\t...\t"+index);  
				}  
			});  
		}  //end of for 
		cachedThreadPool.shutdown();
	} // end of myNewCachedThreadPool
	
	static void myNewFixedThreadPool () {
		 java.util.concurrent.ExecutorService fixedThreadPool = java.util.concurrent.Executors.newFixedThreadPool(3); 
		 for (int i = 0; i < 10; i++) {
			 final int index = i;  
			 fixedThreadPool.execute(new Runnable() {
				 @Override
				 public void run() {
					 try {  
//						 System.out.println(Runtime.getRuntime().availableProcessors());
						 Thread.sleep(1000);  
					 } catch (InterruptedException e) {  
						 e.printStackTrace();  
					 }
					 System.out.println("ThreadName:"+Thread.currentThread().getName()+"\t...\t"+"ThreadID:"+Thread.currentThread().getId()+"\t...\tindex:"+index);  
				 }  
			 });  	//end of fixedThreadPool
		 }		//end of for
		 fixedThreadPool.shutdown();
	}	//end of myNewFixedThreadPool
	
	static void myScheduledThreadPool1 () {
		java.util.concurrent.ScheduledExecutorService myScheduledThreadPool =
				java.util.concurrent.Executors.newScheduledThreadPool(5);
		myScheduledThreadPool.schedule(new Runnable() {
			@Override
			public void run () {
				System.out.println("delay 3 second");
			}
		}, 3, java.util.concurrent.TimeUnit.SECONDS);
//		myScheduledThreadPool.shutdown();
	}

	static void myScheduledThreadPool2 () {
		java.util.concurrent.ScheduledExecutorService myScheduledThreadPool = java.util.concurrent.Executors.newScheduledThreadPool(2);
		myScheduledThreadPool.scheduleAtFixedRate(new Runnable(){
			@Override
			public void run () {
				System.out.println("delay 1 seconds, and excute every 3 seconds");
			}
 		}, 1, 3, java.util.concurrent.TimeUnit.SECONDS);
//		myScheduledThreadPool.shutdown();
	}
	
	static void mySingleThreadPool () {
		java.util.concurrent.ExecutorService singleThreadExecutor = java.util.concurrent.Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i ++) {
			final int index = i;
			singleThreadExecutor.execute(new Runnable () {
				@Override
				public void run () {
					try {
						 System.out.println("ThreadName:"+Thread.currentThread().getName()+"\t...\t"+"ThreadID:"+Thread.currentThread().getId()+"\t...\tindex:"+index);  
						 Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
	
}