package javaSrc;

public class this指针 {

	public void method() {
		System.out.println("TestThis.method()");
	}

	public class Inner {
		public this指针 getThisTest() {
			return this指针.this;
		}
	}

	public Inner getInner(){
		return new Inner();
	}

	public static void main(String[] args) {
		this指针 tt = new this指针();
		this指针 tt2 = new this指针();
		Inner in = tt2.getInner();
		this指针 t = in.getThisTest();
		System.out.println(tt == t);
		System.out.println(tt2 == t);
	}
	
}