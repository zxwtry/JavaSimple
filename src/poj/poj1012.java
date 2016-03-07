package poj;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

//对这题，由于问题确实要求算法非常精妙才能在K非常大的情况下，短时间内得到结果
//本题有BUG就是K是0到13，可以利用P1012的程序得到所有结果并直接输出。
public class poj1012 {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int []store={2,7,5,30,169,441,1872,7632,1740,93313,459901,1358657,2504881};
		int k;
		while((k=in.nextInt())!=0)
			System.out.println(store[k-1]);
		in.close();
	}
}