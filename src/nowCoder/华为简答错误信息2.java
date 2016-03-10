package nowCoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 题目和华为简答错误信息是一样的
 * E:\V1R2\product\01234567890123456789 1325
 */
public class 华为简答错误信息2 {
	public static void main(String[] args) throws Exception{
		Error[] errorArray = new Error[8];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nextIndex = 0;
		String input;
		while (!(input = br.readLine()).equals("")) {
			String[] split = input.split(" ");
			String str = split[0];
			int index = str.lastIndexOf('\\');
			String tmp = str.substring(index+1, str.length());
			if (tmp.length() > 16)
				tmp = tmp.substring(tmp.length()-16);
			nextIndex = addInto(errorArray, nextIndex, tmp, Integer.parseInt(split[1]));
//			myPrint(errorArray, nextIndex);
		}
		myPrint(errorArray, nextIndex);
		br.close();
	}
	private static int addInto (Error[] errorArray, int nextIndex, String errorName, int errorNum) {
		boolean isExist = false;
		Error newObj = new Error (errorName, errorNum);
		for (int errorIndex = 0; errorIndex < 8; errorIndex ++) {
			if (errorArray[errorIndex] != null) {
				if (errorArray[errorIndex].equals(newObj)) {
					errorArray[errorIndex].times ++;
					isExist = true;
					Error tmp = errorArray[errorIndex];
					for (int i = 0; i < 8; i ++) {
						errorArray[(errorIndex+i)&0x7] = errorArray[(errorIndex+i+1)&0x7];
						if (((errorIndex+i+1)&0x7) == nextIndex) {
							errorArray[nextIndex] = tmp;
							break;
						}
					}
				}
			}
		}
		if (!isExist) {
			errorArray[nextIndex] = newObj;
		}
		return (nextIndex+1)&0x7;
	}
	static class Error {
		String errorName;
		int errorNum;
		int times;
		public Error (String errorName, int errorNum, int times) {
			this.errorName = errorName;
			this.errorNum = errorNum;
			this.times = times;
		}
		public Error (String errorName, int errorNum) {
			this(errorName, errorNum, 1);
		}
		public Error () {
			this(null, -1, 0);
		}
		public boolean equals (Object obj) {
			if (!(obj instanceof Error))   return false;
			Error errorObj = (Error) obj;
			return (this.errorName.equals(errorObj.errorName))
					&& (this.errorNum == errorObj.errorNum);
		}
	}
	private static void myPrint (Error[] errorArray, int nextIndex) {
		for (int i = 0; i < 8; i ++) {
			int index = (nextIndex+i) & 0x7;
			if (errorArray[index] != null)
				System.out.println(errorArray[index].errorName+" "+errorArray[index].errorNum+" "+errorArray[index].times);
		}
	}
	
}
