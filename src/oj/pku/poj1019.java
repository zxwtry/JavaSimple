package oj.pku;


public class poj1019 {
	// 在Tools中已经测试，getWeiShu方法和Math.log10();能够完成一样的功能
	public static void main(String[] args) {
		java.util.Scanner in = new java.util.Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			System.out.println(location(in.nextInt()));
		}
		in.close();
	}

	private static int location(int i) {
		// i 传入的条件，问题就是求ｉ位置的数
		// j 递推定位串(初始1)
		// base 记录每一个串递推的位数(初始0)
		// sum 记录串的总位数，用作计数(初始1)
		int j = 1, base = 0, sum = 1;
		while (i >= sum) {
			i -= sum;
			j++; // j 记载下一个串到哪个数字串(123..)
			base = (int) Math.log10(j) + 1; // j的位数
			sum += base; // 该串的字符总数
		}
		// 开始判断，一旦i==0那么我们就能输出
		if (i == 0)
			return (j - 1) % 10;
		sum = 1; // 从串(12...j)中第一个数开始找
		base = 1; // 串中第一个数的位数是1
		while (i >= base) { // 求12...j串中第i个数字
			i -= base;
			sum++;
			base = (int) Math.log10(sum) + 1;
		}
		if (i == 0)
			return (sum - 1) % 10;
		j = (int) Math.log10(sum) + 1 - i;
		while (j-- > 0)
			sum /= 10;
		return sum % 10;
	}
}
