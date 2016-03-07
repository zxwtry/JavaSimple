package gaoXiaoBang;

/*



����
���
�����ֻ�ͨ��ʱ�䲻�����24Сʱ��
ĳ���û��Ŀ�ʼͨ��ʱ��Ϊ�� 12:38:15
����ͨ��ʱ��Ϊ�� 12:39:16
����û�ͨ��ʱ��Ϊ��62��
����һ��������������Ҫ���ǣ�����ӣ���Сʱ�����������⡣
�����֪�˿�ʼ�ͽ���ʱ�䣬�Ա����ͨ��ʱ����
ʱ���ʽΪ��hh:mm:ss
Сʱ����24Сʱ��
��ʾ���ؼ�������δ����ܰ�ò�Ʋ�ͬ���������ת��Ϊһ�µ���ͨ�����

 */



public class �㷨05һ���з�_��� {
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
