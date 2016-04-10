package oj.nowCoder;

class test extends Thread {
	static int num;
	static int arr[] = new int[9];
	test(String name){
		super(name);
	}
	public synchronized void run(){
		System.out.println(this.getName());
		if(this.getName().equals("read")){		
			System.out.println("a");
			while(true){
				if(num==0){
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(arr[num]);
				num--;
				this.notify();
			}
		}
			if(this.getName().equals("write")){
			System.out.println("aaa");
			while(true){
				if(num==9){
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
					arr[num]=(char)(97+Math.random()*10);
					num++;
					this.notify();
			}
		}//System.out.println("2323");
	}
}

class NewTest extends Thread{
	static Object o = new Object();
	static int[] num = new int[10];
	static int index;
	public NewTest (String name) {
		super(name);
	}
	@Override
	public void run() {
		while (true) {
			synchronized(o) {
				try {
					myRun();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	void myRun () throws InterruptedException {
		if (this.getName().equals("read")) {
			if (index == 0) {
				o.wait();
			} else {
				System.out.println(num[index]);
				for (int i = 0; i < 10; i ++) {
					System.out.print(num[i] +" ");
				}
				System.out.println();
				index --;
				o.notify();
			}
		} else if (this.getName().equals("write")) {
			if (index == 10) {
				o.wait();
			} else {
				num[index]=(int)(100+Math.random()*100);
				System.out.println("´´½¨   " + num[index]);
				index ++;
				o.notify();
			}
		}
	}
}

public class nnnnnn {
	public static void main(String[] args) {
		NewTest t1 = new NewTest("read");
		NewTest t2 = new NewTest("write");
		t2.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.start();
		
	}

}
