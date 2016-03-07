package dianXingSuanFa;

public class 扔鸡蛋问题 {
	public static void main(String[] args) {
		int n = 2, k = 36;
		System.out.println(eggDrop(n, k));
	}
	
	private static int eggDrop (int n , int k ) {
		//eggFloor[i][j] 表示对于 i个鸡蛋 j 层楼，需要的最少测试次数
		int eggFloor[][] = new int[n+1][k+1];
		int res;
		int i, j, x;
		//初始化
		for (i = 0; i <= n; ++ i) {
			eggFloor[i][1] = 1;
			eggFloor[i][0] = 0;
		}
		//只有一个鸡蛋，没得优化， 需要j次
		for (j = 0; j <= k; j ++) {
			eggFloor[1][j] = j;
		}
		for (i = 2; i <= n; i ++) {
			for (j = 2; j <= k; j ++ ) {
				eggFloor[i][j] = Integer.MAX_VALUE;
				for (x = 1; x <= j; x ++) {
					res = 1 + Math.max(eggFloor[i-1][x-1], eggFloor[i][j-x]);
					if (res < eggFloor[i][j])
						eggFloor[i][j] = res;
				}
			}
		}
		return eggFloor[n][k];
	}
	
}
