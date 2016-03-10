package book.jianZhiOffer;
/*
 * 这就是约瑟夫环问题(Josephuse)
 */
public class 题45圆圈中最后剩下的数字 {
	public static void main(String[] args) {
		System.out.println(getJosephuseNM(3,1));
	}
	private static int getJosephuseNM (int N, int M) {
		//这里最重要的是写出状态转移方程
		if (N < 1)   return -1; 
		if (N == 1 && M >0)
			return 0;
		int last = 0;
		for (int t = 2; t <= N ; t ++) {
			last = (last + M) % t;
		}
		return last;
	}
}
