package javaPlatform.thread;


/*


Javaͨ��Executors�ṩ�����̳߳أ��ֱ�Ϊ��
newCachedThreadPool����һ���ɻ����̳߳أ�����̳߳س��ȳ���������Ҫ��
�������տ����̣߳����޿ɻ��գ����½��̡߳�
newFixedThreadPool ����һ�������̳߳أ��ɿ����߳���󲢷������������̻߳��ڶ����еȴ���
newScheduledThreadPool ����һ�������̳߳أ�֧�ֶ�ʱ������������ִ�С�
newSingleThreadExecutor ����һ�����̻߳����̳߳أ���ֻ����Ψһ�Ĺ����߳���ִ�����񣬱�֤����������ָ��˳��(FIFO, LIFO, ���ȼ�)ִ�С�



 */
public class Java�����̳߳� {
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