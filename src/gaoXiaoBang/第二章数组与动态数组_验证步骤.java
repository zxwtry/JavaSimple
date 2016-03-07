package gaoXiaoBang;
public class 第二章数组与动态数组_验证步骤 {
	private static final int MAXNUM = 10000;
	private static int MAX_INDEX = 0;
	private static boolean isFound = false;
	private static int times_pre = 0;
	private static int times = 0;
 	public static void main(String args[]) {
		for (int i = 1; i <= MAXNUM; i ++) {
			oper(i);
			if (times_pre < times) {
				MAX_INDEX = i;
				times_pre = times;
			}
			times = 0;
		}
		isFound = true;
		oper(MAX_INDEX);
	}
	private static void oper(int num) {
		if (num == 1) {
			if (isFound)
				System.out.printf("\n");
		}
		else if (num % 2 == 1) oper(operEven(num));
		else oper(operOdd(num));
	}
	private static int operOdd(int num) {
		if (isFound)
			System.out.printf("%d ",num/2);
		times ++;
		return num/2;
	}
	private static int operEven(int num) {
		if (isFound)
			System.out.printf("%d ",3*num+1);
		times ++;
		return 3*num+1;
	}
}