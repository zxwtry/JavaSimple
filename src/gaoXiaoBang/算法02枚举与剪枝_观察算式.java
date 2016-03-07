package gaoXiaoBang;

/*




观察算式

观察下面的算式：

△△△ * △△ = △△△△

某3位数乘以2位数，结果为4位数

要求：在9个△所代表的数字中，1~9的数字恰好每个出现1次。


 */

public class 算法02枚举与剪枝_观察算式 {
	//设定三位数是multiplicator1,二位数是multiplicator2,四位数是quotient
	public static void main(String[] args) {
		findAllPossible(new int[10], 1);
	}
	
	private static void findAllPossible(int[] data, int index) {
		for (int indexCheck = 1; indexCheck < index-1; ++ indexCheck) {
			if (data[indexCheck] == data[index-1])
				return;
		}
		if (index == 10) {
			int multiplicator1, multiplicator2, quotient;
			multiplicator1 = data[3] + data[2]*10 +data[1]*100;
			multiplicator2 = data[5] + data[4]*10;
			quotient = data[9] + data[8]*10 + data[7]*100 + data[6]*1000;
			if (multiplicator1 * multiplicator2 == quotient) {
				System.out.println(multiplicator1 + " * " + multiplicator2 + " = " + quotient );
			}
			return;
		}
		for (int indexTry = 1; indexTry < 10; ++ indexTry) {
			data[index] = indexTry;
			index ++;
			findAllPossible(data, index);
			index --;
		}
		
	}
}
