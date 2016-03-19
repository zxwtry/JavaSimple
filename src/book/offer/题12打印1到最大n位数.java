package book.offer;

public class 题12打印1到最大n位数 {
	
//	private static void print1ToMaxOfNDigits(int n) {
//		if (n<=0)	return;
//		char[] number = new char[n];
//		for (int i = 0; i < 10; ++ i) {
//			number[0] = (char)(i+'0');
//			print1ToMaxOfNDigitsRecursively(number, 0);
//		}
//	}
//	private static void print1ToMaxOfNDigitsRecursively (char[] number, int index) {
//		if (index == number.length - 1) {
//			printNumber(number);
//			return;
//		}
//		for (int i = 0; i < 10; ++ i) {
//			number[index+1] = (char)(i+'0');
//			print1ToMaxOfNDigitsRecursively(number, index+1);
//		}
//	}
//	private static void printNumber (char[] number) {
//		boolean isBegining0 = true;
//		for (int i = 0; i < number.length; ++ i) {
//			if (isBegining0 && number[i] != '0')
//				isBegining0 = false;
//			if (!isBegining0)
//				System.out.printf("%c", number[i]);
//		}
//		System.out.printf("\t");
//	}
	
	public static void main(String[] args) {
//		char[] c = new char[3];
//		c[0] = '0';
//		charArrayRecordIndex(c, 0);
		printFromOneToNDigits(1);
		
//		print1(2);
	}
	
//	private static void printSolutionStep1 (int n) {
//		if (n <= 0)   return;
//		char[] data = new char[n];
//		for (int i = 0; i < 10; i ++) {
//			data[0] = (char)(i+'0');
//			printSolutionStep2(data, 0);
//		}
//	}
//	private static void printSolutionStep2 (char[] data, int index) {
//		if (index == data.length-1) {
//			printSolutionStep3(data);
//			return;
//		}
//		for (int i = 0; i < 10; ++ i) {
//			data[index+1] = (char)(i+'0'); 
//			printSolutionStep2(data, index+1);
//		}
//	}
//	private static void printSolutionStep3 (char[] data) {
//		boolean isBegin0 = true;
//		for (int i = 0; i < data.length; ++ i) {
//			if (isBegin0 && data[i] != '0')
//				isBegin0 = false;
//			if (!isBegin0)
//				System.out.printf("%c", data[i]);
//		}
//		System.out.printf("\t");
//	}
	
	
//	private static void print1 (int numOfDigits) {
//		if (numOfDigits <= 0)   return;
//		char[] data = new char[numOfDigits];
//		for (int from0To9 = 0; from0To9 < 10; from0To9 ++) {
//			data[0] = (char)(from0To9+'0');
//			print2(data, 0);
//		}
//	}
//	private static void print2 (char[] data, int printIndex) {
//		if (printIndex == data.length-1) {
//			print3(data);
//			return;
//		}
//		for (int from0To9 = 0; from0To9 < 10; from0To9 ++) {
//			data[printIndex+1] = (char)(from0To9+'0');
//			print2(data, printIndex+1);
//		}
//	}
//	private static void print3 (char[] data) {
//		boolean isBegin0 = true;
//		for (int dataIndex = 0; dataIndex < data.length; dataIndex ++) {
//			if (isBegin0 && data[dataIndex] != '0')
//				isBegin0 = false;
//			if (!isBegin0)
//				System.out.printf("%c", data[dataIndex]);
//		}
//		System.out.printf("\t");
//	}
	
	private static void charArrayPrint(char[] data) {
		boolean isBegin0 = true;
		for (int dataIndex = 0; dataIndex < data.length; dataIndex ++) {
			if (data[dataIndex] =='\0')
				continue;
			if (isBegin0 && data[dataIndex] != '0')
				isBegin0 = false;
			if (!isBegin0)
				System.out.printf("%c", data[dataIndex]);
		}
		System.out.printf("\t");
	}
	private static void charArrayRecordIndex (char[] data, int recordIndex) {
		if (recordIndex == data.length-1) {
			charArrayPrint(data);
			return;
		}
		for (int fromZeroToNine = 0; fromZeroToNine < 10; fromZeroToNine ++) {
			data[recordIndex+1] = (char)(fromZeroToNine+'0');
			charArrayRecordIndex(data, recordIndex+1);
		}
	}
	private static void printFromOneToNDigits (int numOfDigits) {
		if (numOfDigits <= 0)   return;
		char[] data = new char[numOfDigits];
		for (int fromZeroToNine = 0; fromZeroToNine < 10; fromZeroToNine ++) {
			data[0] = (char)(fromZeroToNine + '0');
			charArrayRecordIndex (data, 0);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
