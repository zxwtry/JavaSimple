package dianXingSuanFa;

public class �Ӽ������� {
	public static void main(String[] args) {
		int n = 2, k = 36;
		System.out.println(eggDrop(n, k));
	}
	
	private static int eggDrop (int n , int k ) {
		//eggFloor[i][j] ��ʾ���� i������ j ��¥����Ҫ�����ٲ��Դ���
		int eggFloor[][] = new int[n+1][k+1];
		int res;
		int i, j, x;
		//��ʼ��
		for (i = 0; i <= n; ++ i) {
			eggFloor[i][1] = 1;
			eggFloor[i][0] = 0;
		}
		//ֻ��һ��������û���Ż��� ��Ҫj��
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
