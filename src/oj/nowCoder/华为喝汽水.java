package oj.nowCoder;

import java.util.Scanner;

public class »ªÎªºÈÆûË® {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		while (sc.hasNext()) {
			int count = sc.nextInt();
			if (count == 0)
				break;
			System.out.println(getMax(count));
		}
		sc.close();
	}
	private static int getMax(int count) {
		int re = count/3;
		int kong = count%3 +count/3;
		while (kong>=3) {
			re += kong/3;
			kong = kong%3 + kong/3;
		}
		if (kong == 2) 
			re ++;
		return re;
	}
}
