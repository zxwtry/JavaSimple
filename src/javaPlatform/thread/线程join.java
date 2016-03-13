package javaPlatform.thread;

/**
 * �����̵߳�join
 * @author Сe
 *
 * 2010-4-24 ����07:49:45
 */

class Sleeper extends Thread{
	private int sleepTimes;
	
	public Sleeper(int sleepTimes, String name) {
		super(name);
		this.sleepTimes = sleepTimes;
	}
	@Override
	public void run() {
		System.out.println(getName() + " ��ʼ����");
		try {
			sleep(sleepTimes);
		} catch (InterruptedException e) {
			System.out.println(getName() + "������ˣ�isInterrupted:" + isInterrupted());
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
		System.out.println(sleeper.getName() + "��ʼ����");
		try {
			sleeper.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sleeper.getName() + "���߽���");
		System.out.println(getName() + "���н���");
	}
	
}
public class �߳�join {
	
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
