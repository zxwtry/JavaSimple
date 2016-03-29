package oj.hdu;

import java.util.Scanner;

/*

ս��ʤ��֮�������֧Ԯ�Ĺ��ҿֻ�ֵ�ͻ�-2��(�ֻ�ֵ���ټ�Ϊ1),
����������δ��֧Ԯ�Ĺ��ҿֻ�ֵ�ͻ�+2��,
ͬʱ����������������ͬ���޵��������ҿֻ�ֵҲ��+1��.
��һ�����ҵĿֻ�ֵ����5��,������Ҿͻ������ʧȥ���ĴӶ��˳�����.
���ڸ��������˽�������ĵص�,
����������ڲ�ʧȥ�κ�һ���������ε�����µֵ����ٴ������˵Ľ���.


 */
public class hdu4536XCOMEnemyUnknown {
	static int n , m , k , zhou[], kong[], gong[][];
	static int finalTimes = Integer.MIN_VALUE;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int times = -1;
		while(in.hasNext()) {
			times = in.nextInt();
			for (int i = 0; i < times; i ++) {
				finalTimes = Integer.MIN_VALUE;
				n = in.nextInt();
				m = in.nextInt();
				k = in.nextInt();
				zhou = new int[n];
				kong = new int[n];
				for (int ii = 0; ii < n; ii ++) {
					zhou[ii] = in.nextInt();
				}
				for (int iii = 0; iii < n; iii ++) {
					kong[iii] = in.nextInt();
				}
				gong = new int[n][3];
				for (int i4 = 0; i4 < k; i4 ++) {
					gong[i4][0] = in.nextInt();
					gong[i4][1] = in.nextInt();
					gong[i4][2] = in.nextInt();
				}
				isAlive(0, 0);
				System.out.println("Case #1: "+finalTimes);
			}
		}
		in.close();
	}
	private static boolean isAlive(int kt, int k3) {
		if (kt == k) {
			finalTimes = k;
			return true;
		}
		int[] fq1 = {1, 0, 0};
		int[] fq2 = {2, 2, 1};
		boolean isK3[] = {true, true, true};
		int select, fq, fqz;
		for (int kk = 0; kk < 3; kk ++) {
			select = gong[kt][kk];
			fq = gong[kt][fq1[kk]];
			fqz = zhou[fq];
			isK3[kk] = isThisAlive(select, fq, fqz);
			if (!isK3[kk])
				continue;
			fq = gong[kt][fq2[kk]];
			if (fqz == zhou[fq]) {
				fqz = -1;
			} else {
				fqz = zhou[fq];
			}
			isK3[kk] = isThisAlive(select, fq, fqz);
		}
		if (isK3[0] || isK3[1] || isK3[2]) {
			for (int i = 0; i < 3; i ++) {
				if (isK3[i])
					isAlive(kt+1, k3);
			}
		} else {
			if (k3 > finalTimes){
				finalTimes = k3 + 1;
			}
		}
		for(int i = 0; i < n; i ++) {
			if (kong[i] > 5)
				return false;
		}
		return true;
	}
	private static boolean isThisAlive(int select, int fq, int fqz) {
		kong[select] -= 2;
		if (kong[select] < 1)
			kong[select] = 1;
		kong[fq] += 2;
		if(kong[fq] > 5)
			return false;
		for (int i = 0; i < n; i ++) {
			if (fqz == zhou[i]) {
				if (fq != i)
					kong[i] ++;
				if (kong[i] > 5)
					return false;
			}
		}
		if (zhou[select] == zhou[fq]) {
			kong[select] --;
		}
		return true;
	}
}
