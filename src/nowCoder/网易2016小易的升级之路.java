package nowCoder;

import java.util.Scanner;

public class 网易2016小易的升级之路 {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner (System.in);
		int numOfBeasts, ablity;
		while (sc.hasNext()) {
			numOfBeasts = sc.nextInt();
			ablity = sc.nextInt();
			int[] ablityOfBeasts = new int[numOfBeasts];
			if (numOfBeasts <= 0) {
				System.out.println(ablity);
				continue;
			}
			for (int i = 0; i < numOfBeasts; i ++) {
				ablityOfBeasts[i] = sc.nextInt();
			}
			System.out.println(getTheFinalAblity(ablity, ablityOfBeasts));
		}
		sc.close();
	}
	private static int getTheFinalAblity(int ablity, int[] ablityOfBeasts) {
		for (int i = 0; i < ablityOfBeasts.length; ++ i)
			ablity += getTheAddAblity (ablity, ablityOfBeasts[i]);
		return ablity;
	}
	private static int getTheAddAblity (int ablityOfMe, int ablityOfBeast ) {
		if (ablityOfMe >= ablityOfBeast) {
			return ablityOfBeast;
		} else {
			return getMaxGY(ablityOfMe, ablityOfBeast);
		}
	}
	private static int getMaxGY (int ablityOfMe, int ablityOfBeast) {
		if (ablityOfMe > ablityOfBeast) {
			ablityOfMe = ablityOfMe ^ ablityOfBeast;
			ablityOfBeast = ablityOfMe ^ ablityOfBeast;
			ablityOfMe = ablityOfMe ^ ablityOfBeast;
		}
		if (ablityOfBeast % ablityOfMe == 0)
			return ablityOfMe;
		return getMaxGY (ablityOfMe, ablityOfBeast%ablityOfMe);
	}
}
