package book.jianZhiOffer;

import java.util.Arrays;

/*
 * ��N���������ڵ��ϣ��������ӳ���һ��ĵ���֮��Ϊs������N����ӡ��s�����п��ܵ�ֵ
 */
public class ��43N�����ӵĵ��� {
	public static void main(String[] args) {
		double[] re = fromIntArrayToDoubleArray(3);
		for (int i = 1; i <re.length; i ++) {
			System.out.printf("%d %f\t", i, re[i]);
			if (i % 6 == 0) 
				System.out.println();
		}
	}
	public static int[] getTheArray (final int N) {
		int[] intReturn = new int [7];
		Arrays.fill(intReturn, 0);
		for (int i = 1; i <= 6; i ++) {
			intReturn[i] = 1;
		}
		for (int k = 2; k <= N; k ++) {
			int[] tmp = new int[6*k+1];
			Arrays.fill(tmp, 0);
			for (int i = 1; i <= 6; i ++) {
				for (int j = 1; j <= k*6-6; j ++) {
					if (intReturn[j] != 0)
						tmp[j+i] += intReturn[j];
				}
			}
			intReturn = tmp;
		}
		return intReturn;
	}
	public static double[] fromIntArrayToDoubleArray (final int N) {
		if (N <= 0)   return null;
		int[] intReturn = getTheArray(N);
		double sum = Math.pow(6, N);
		double[] doubleReturn = new double[intReturn.length];
		for (int i = 0; i < doubleReturn.length; i ++) {
			doubleReturn[i] = intReturn[i]/sum;
		}
		return doubleReturn;
	}
}
