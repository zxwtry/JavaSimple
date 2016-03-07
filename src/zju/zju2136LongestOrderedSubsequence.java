package zju;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class zju2136LongestOrderedSubsequence {
	static class ANS {
		int beginIndex;
		int endIndex;
		int length;
		int preIndex;
		public ANS () {}
		public ANS (int beginIndex, int endIndex, int length, int preIndex) {
			this.beginIndex = beginIndex;
			this.endIndex = endIndex;
			this.length = length;
			this.preIndex = preIndex;
		}
	}
	private static int findANS (int[] data) {
		ANS[] ans = new ANS[data.length];
		int findThePreIndex;
		for (int i = 0; i < data.length; ++ i) {
			findThePreIndex = -1;
			for (int j = 0; j < i; ++ j) {
				if (data[j] < data[i]) {
					if (findThePreIndex == -1)
						findThePreIndex = j;
					else {
						if (ans[findThePreIndex].length < ans[j].length)
							findThePreIndex = j;
					}
				}
			}
			if (findThePreIndex == -1) {
				ans[i] = new ANS(i, i, 1, -1);
			} else {
				ans[i] = new ANS(ans[findThePreIndex].beginIndex, i, 
						ans[findThePreIndex].length+1, findThePreIndex);
			}
		}
		int maxLengthIndex = 0;
		for (int i = 1; i < ans.length; ++ i) {
			if (ans[i].length > ans[maxLengthIndex].length)
				maxLengthIndex = i;
		}
		return ans[maxLengthIndex].length;
	}
//	private static int findTheMaxLastIndex (ANS[] ans) {
//		int maxLengthIndex = 0;
//		for (int i = 1; i < ans.length; ++ i) {
//			if (ans[i].length > ans[maxLengthIndex].length)
//				maxLengthIndex = i;
//		}
//		return maxLengthIndex;
//	}
//	private static int[] findTheSubArray (ANS[] ans, int[] data) {
//		findANS(data, ans);
//		int maxLengthIndex = findTheMaxLastIndex(ans);
//		int[] re = new int[ans[maxLengthIndex].length];
//		for (int i = re.length-1; i >= 0; -- i) {
//			re[i] = data[maxLengthIndex];
//			maxLengthIndex = ans[maxLengthIndex].preIndex;
//		}
//		return re;
//	}
	public static void main(String[] args) throws Exception{
//		int[] data = {1, 7, 6, 2, 9, 8, 3, 5, 4};
//		int[] data = {1, 7, 3, 5, 9, 4, 8};
//		ANS[] ans = new ANS[data.length];
//		System.out.println(findANS(data, ans));
		/*
		 1

		  7
		1 7 3 5 9 4 8
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numOfTest = Integer.parseInt(br.readLine().trim());
		while (numOfTest-- > 0) {
			br.readLine();br.readLine();
			String[] spilt = br.readLine().trim().split(" ");
			int[]data = new int[spilt.length];
			for (int i = 0; i < spilt.length; ++ i) {
				data[i] = Integer.parseInt(spilt[i]);
			}
			System.out.println(findANS(data));
			if (numOfTest != 0) {
				System.out.println();
			}
		}
		br.close();
	}
}
