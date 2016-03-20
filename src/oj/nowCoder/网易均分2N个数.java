package oj.nowCoder;

import java.util.Arrays;

/*
����2n��������������ѡ��n����������ʹ��ѡ����n��������ʣ�µ�n��������������Ӻ�֮����С
 */
public class ���׾���2N���� {
	public static void main(String[] args) {
		int[] arr = {0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//		int[] arr = {0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
		int[][] ans = solve(arr);
		for (int[] p : ans) {
			for (int k : p)
				System.out.printf("%d\t", k);
			System.out.println();
		}
	}
	public static int[][] solve (int[] arr) {
		int SUM = 0;
		for (int k : arr)
			SUM += k;
		int N = (arr.length-1)/2;
		
		int i, j, s;
		int[][] dp = new int[N+1][SUM/2+2];
		for (int id = 0; id <= N; id ++) {
			Arrays.fill(dp[id], 0);
		}
		for (i = 1; i <= 2*N; ++ i) {
			for (j = 1; j <= Math.min(i, N); ++ j) {
				for (s = SUM/2+1; s >= arr[i]; -- s)
					dp[j][s] = Math.max(dp[j-1][s-arr[i]] + arr[i], dp[j][s]);
			}
		}
		return dp;
	}
}
