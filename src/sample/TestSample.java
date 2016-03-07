package sample;

import org.junit.Test;
import org.junit.Before;

public class TestSample {
	@Before
	public void before () {
		System.out.println("OOO");
	}
	@Test
	public void test () {
		System.out.println("AAAA");
	}
	//�ó������趨��ʱ��֮��ֹͣ
	@Test(timeout = 3000)
	public void timeout () {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("test");
		}
	}
	//ָ��expected
	@Test(expected = ArithmeticException.class)
	public void expected01() {
		int tmp = 3;
		System.out.println(4/(tmp-3));
	}


}
