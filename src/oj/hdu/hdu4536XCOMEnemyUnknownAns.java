package oj.hdu;

public class hdu4536XCOMEnemyUnknownAns {
	static final int maxN = 20;
	static int p[] = new int[maxN], nervous[] = new int[maxN], n, m, k, maxCNT, att[][] = new int[110][3];
	static void dfs(int cn) {
		if (maxCNT >= k)
			return;
		if (cn >= k) {
			maxCNT = k;
			return;
		}
		int[] a = new int[3], bak = new int[3];
		for (int v = 0; v < 3; v ++) {
			a[0] = att[cn][v];
			a[1] = att[cn][(v+1)%3];
			a[3] = att[cn][(v+2)%3];
			
			bak[0] = nervous[a[0]];
			bak[1] = nervous[a[1]];
			bak[2] = nervous[a[2]];
			nervous[a[0]] -= 2;
			if (nervous[a[0]] < 1)
				nervous[a[0]] = 1;
			nervous[a[1]] += 2;
			nervous[a[2]] += 2;
			for (int i = 0; i < n; i ++) {
				if (p[i] == p[a[i]] && i != a[1]) nervous[i] ++;
//				if ()
			}
		}
	}
}
