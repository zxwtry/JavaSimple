public class SOF{
	private final static int RANGE_$ = '$'-' ';
	private final static int RANGE_0 = 0;
	private final static int RANGE_NEXTLINE = '\n'-' ';
 	public static void main(String args[]) {
		// question_1();
		// question_2();
		// question_3();
		// question_4(7);
		// question_5(7);
		// question_6(6);
		// question_7(9);
		// question_8(5);
		// question_9();
		// question_10();
	}
	private static void question_1() {
		RECTANGLE(7,5,0,true);
	} 
	private static void question_2() {
		RECTANGLE(7,1,0,true);
		RECTANGLE(2,4,1,true);
		RECTANGLE(7,1,0,true);
	}
	private static void question_3() {
		ONELINESPEC(5,1,5);
		RECTANGLE(9,3,1,true);
		ONELINESPEC(5,1,5);
	}
	private static void question_4(int times) {
		for (int t = 0; t < times; t ++) {
			ONELINESPEC(t+1,0,1);
			myPrint(RANGE_NEXTLINE);
		}
	}
	private static void question_5(int times) {
		for (int t = 0; t < times; t ++) {
			ONELINESPEC(2*t+1,0,1);
			myPrint(RANGE_NEXTLINE);
		}
	}
	private static void question_6(int times) {
		for (int t = 0; t < times; t ++) {
			RECTANGLE(t+1,9,1,true);
		}
	}
	private static void question_7(int times) {
		RECTANGLE(1,1,0,true);
		for (int t = 0; t < times; t ++) {
			RECTANGLE(2,1,1,true);
		}
		RECTANGLE(1,1,0,true);
	}
	private static void question_8(int times) {
		for (int t = 0; t < times; t ++)
			ONELINESPEC(2,1,2);
		RECTANGLE(4,1,0,true);
		RECTANGLE(2,1,0,true);
		RECTANGLE(4,1,0,true);
		for (int t = 0; t < times; t ++)
			ONELINESPEC(2,1,2);
	}
	private static void question_9() {
		RECTANGLE(13,1,0,true);
		RECTANGLE(2,1,1,true);
		RECTANGLE(1,1,1,false);RECTANGLE(9,1,0,false);myPrint(RANGE_0);RECTANGLE(1,1,1,true);
		ONELINESPEC(1,1,4);
		RECTANGLE(2,1,1,false);RECTANGLE(5,1,0,false);myPrint(RANGE_0);RECTANGLE(2,1,1,true);
		ONELINESPEC(1,1,6);ONELINESPEC(1,1,7);ONELINESPEC(1,1,6);
		RECTANGLE(2,1,1,false);RECTANGLE(5,1,0,false);myPrint(RANGE_0);RECTANGLE(2,1,1,true);
		ONELINESPEC(1,1,4);
		RECTANGLE(1,1,1,false);RECTANGLE(9,1,0,false);myPrint(RANGE_0);RECTANGLE(1,1,1,true);
		RECTANGLE(2,1,1,true);
		RECTANGLE(13,1,0,true);
	}
	private static void question_10() {
		RECTANGLE(12,1,0,true);
		RECTANGLE(1,1,0,true);
		RECTANGLE(10,1,0,false);myPrint(RANGE_0);RECTANGLE(1,1,0,true);
		RECTANGLE(3,1,1,true);
		RECTANGLE(1,1,1,false);RECTANGLE(6,1,0,false);myPrint(RANGE_0);RECTANGLE(2,1,1,true);
		RECTANGLE(5,1,1,true);
		RECTANGLE(2,1,1,false);RECTANGLE(2,1,0,false);myPrint(RANGE_0);RECTANGLE(3,1,1,true);
		RECTANGLE(2,1,1,false);RECTANGLE(4,1,0,false);myPrint(RANGE_0);RECTANGLE(2,1,1,true);
		RECTANGLE(4,1,1,true);
		RECTANGLE(1,1,1,false);RECTANGLE(8,1,0,false);myPrint(RANGE_0);RECTANGLE(1,1,0,true);
		RECTANGLE(2,1,1,true);
		RECTANGLE(12,1,0,true);
	}
	private static void ONELINESPEC(int m,int n,int times) {
		for (int i = 0; i < times; i ++) {
			if (i == (times-1)) {
				RECTANGLE(m,1,0,false);
				for (int j = 0; j < n; j ++)
					RECTANGLE(0,0,1,true);
			} else {
				RECTANGLE(m,1,0,false);
				for (int j = 0; j < n; j ++)
					RECTANGLE(0,0,1,false);
			}
		}
	}
	private static void RECTANGLE(int width,int height,int interval,boolean lastNEXTLINE) {
		if (width < 0 || height <0 || interval < 0) return;
		if (width == 0 && height == 0) {
			for (int i = 0; i < interval; i ++)
				myPrint(RANGE_0);
			if (lastNEXTLINE) myPrint(RANGE_NEXTLINE);
		}
		else
			for (int i = 0; i < height; i ++) {
				for (int j = 0; j < width; j ++) {
					myPrint(RANGE_$);
					for (int k = 0; k < interval; k ++)
						myPrint(RANGE_0);
				}
				if (lastNEXTLINE || i != (height-1))
					myPrint(RANGE_NEXTLINE);
			}
	}
	private static void myPrint(int x) {
		System.out.printf("%c",(char)(' '+x));
	}
}