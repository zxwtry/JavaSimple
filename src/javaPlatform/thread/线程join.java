package javaPlatform.thread;

/**
 * 测试线程的join
 * @author 小e
 *
 * 2010-4-24 下午07:49:45
 */

class Sleeper extends Thread{
	private int sleepTimes;
	
	public Sleeper(int sleepTimes, String name) {
		super(name);
		this.sleepTimes = sleepTimes;
	}
	@Override
	public void run() {
		System.out.println(getName() + " 开始休眠");
		try {
			sleep(sleepTimes);
		} catch (InterruptedException e) {
			System.out.println(getName() + "被打断了，isInterrupted:" + isInterrupted());
		}
	}
	
}
class Joiner extends Thread{
	private Sleeper sleeper;
	public Joiner(Sleeper sleeper,String name) {
		super(name);
		this.sleeper = sleeper;
	}
	@Override
	public void run() {
		System.out.println(sleeper.getName() + "开始休眠");
		try {
			sleeper.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sleeper.getName() + "休眠结束");
		System.out.println(getName() + "运行结束");
	}
	
}
public class 线程join {
	
	public static void main(String[] args) {
		Sleeper 
			s1 = new Sleeper(2000, "s1"),
			s2 = new Sleeper(2000, "s2");
		
		Joiner
			j1 = new Joiner(s1, "j1"),
			j2 = new Joiner(s2, "j2");
		
		j2.start();
		 try {
			j2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		j1.start();
		
	}

}
