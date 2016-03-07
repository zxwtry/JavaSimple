package gaoXiaoBang;

/*



问题
编程
假设手机通话时间不会大于24小时。
某个用户的开始通话时间为： 12:38:15
结束通话时间为： 12:39:16
则该用户通话时长为：62秒
对于一般的情况，可能需要考虑：跨分钟，跨小时，跨零点的问题。
如果已知了开始和结束时间，试编程求通话时长。
时间格式为：hh:mm:ss
小时采用24小时制
提示：关键在于如何处理，能把貌似不同的特殊情况转化为一致的普通情况。

 */



public class 算法05一刀切法_编程 {
	public static void main(String[] args) throws Exception{
		final String startTime = "12:38:15";
		final String endTime = "12:38:14";
		String[] startTimeSplit = startTime.trim().split(":");
		String[] endTimeSplit = endTime.trim().split(":");
		int startSeconds = getSeconds(Integer.parseInt(startTimeSplit[0]),
				Integer.parseInt(startTimeSplit[1]),Integer.parseInt(startTimeSplit[2]));
		int endSeconds = getSeconds(Integer.parseInt(endTimeSplit[0]),
				Integer.parseInt(endTimeSplit[1]),Integer.parseInt(endTimeSplit[2]));
		if (startSeconds < endSeconds) {
			System.out.println(getStandardTime(endSeconds-startSeconds+1));
		} else {
			System.out.println(getStandardTime(endSeconds-startSeconds+1+24*3600));
		}
		System.out.println(getStandardTime(100));
	}
	private static String getStandardTime(int seconds) {
		StringBuffer st = new StringBuffer();
		st.append(String.format("%02d", seconds/3600));
		st.append(":");
		st.append(String.format("%02d", seconds/60%60));
		st.append(":");
		st.append(String.format("%02d", seconds%60));
		return st.toString();
	}
	private static int getSeconds (int hour, int minute, int second) {
		return hour * 60 * 60 + minute * 60 + second;
	}
}
