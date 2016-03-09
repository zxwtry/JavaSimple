package nowCoder;
/*
 * 题目和华为简答错误信息是一样的
 */
public class 华为简答错误信息2 {
	public static void main(String[] args) {
		
	}
	private static int addInto (Error[] errorArray, int nextIndex, String errorName, int errorNum) {
		
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
	
}
