package testSpeed;

/*

charAt是native方法
toCharArray看源码好像操作复杂

 */


public class String的CharAt和toCharArray {
	public static void main(String[] args) {
		final String str = "ABCDEFGHIJKLMN";
		char temp = '\u0061';
		char \u0061 = 'A';
		long time1 = System.currentTimeMillis();
		for (int i = 0; i < 10000000; ++ i) {
			for (int j = 0; j < 14; ++ j) {
				temp = str.charAt(j);
			}
		}
		System.out.println(System.currentTimeMillis()-time1);
		
		time1 = System.currentTimeMillis();
		char[] c = str.toCharArray();
		for (int i = 0; i < 10000000; ++ i) {
			for (int j = 0; j < c.length; j ++) {
				temp = c[j];
			}
		}
		System.out.println(System.currentTimeMillis()-time1);
		System.out.println(temp);
		System.out.println(a);
	}
}
