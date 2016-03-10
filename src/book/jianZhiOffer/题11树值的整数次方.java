package book.jianZhiOffer;

public class 题11树值的整数次方 {
	final public static void main (String[] args) {
		System.out.println(powerWithFunction(2.0,3000000));
	}
	private static double powerWithFunction(double base, int exponent) {
		if (exponent == 0)	//有一种情况是0的0次幂也设为1
			return 1;
		if (exponent == 1)
			return base;
		double result = powerWithFunction(base, exponent>>1);
		result *= result;
		if ((exponent&0x1) == 1)
			result *= base;
		return result;
	}
}
