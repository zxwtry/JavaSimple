package gaoXiaoBang;

/*

算法
看这个算式：
☆☆☆ + ☆☆☆ = ☆☆☆
如果每个五角星代表 1 ~ 9 的不同的数字。
这个算式有多少种可能的正确填写方法？
173 + 286 = 459
295 + 173 = 468
173 + 295 = 468
183 + 492 = 675
以上都是正确的填写法！
注意：
111 + 222 = 333 是错误的填写法！
因为每个数字必须是不同的！
也就是说：1~9中的所有数字，每个必须出现且仅出现一次！
注意：
不包括数字“0”！
注意：
满足加法交换率的式子算两种不同的答案。
所以答案肯定是个偶数！


 */


public class 算法58算法 {
	//设定三位数是multiplicator1,二位数是multiplicator2,四位数是quotient
	private static int count = 0;
	public static void main(String[] args) {
		findAllPossible(new int[10], 1);
		System.out.println("总共："+count+"个结果");
	}
	
	private static void findAllPossible(int[] data, int index) {
		for (int indexCheck = 1; indexCheck < index-1; ++ indexCheck) {
			if (data[indexCheck] == data[index-1])
				return;
		}
		if (index == 10) {
			int multiplicator1, multiplicator2, quotient;
			multiplicator1 = data[3] + data[2]*10 + data[1]*100;
			multiplicator2 = data[6] + data[5]*10 + data[4]*100;
			quotient = data[9] + data[8]*10 + data[7]*100;
			if (multiplicator1 + multiplicator2 == quotient) {
				count ++;
				System.out.println(multiplicator1 + " + " + multiplicator2 + " = " + quotient );
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
