package javaSrc;

public class thisָ�� {

	public void method() {
		System.out.println("TestThis.method()");
	}

	public class Inner {
		public thisָ�� getThisTest() {
			return thisָ��.this;
		}
	}

	public Inner getInner(){
		return new Inner();
	}

	public static void main(String[] args) {
		thisָ�� tt = new thisָ��();
		thisָ�� tt2 = new thisָ��();
		Inner in = tt2.getInner();
		thisָ�� t = in.getThisTest();
		System.out.println(tt == t);
		System.out.println(tt2 == t);
	}
	
}