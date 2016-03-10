package book.jianZhiOffer;
/*
 * һ�������г�����������֮�⣬���������ֶ��������Σ��ҳ�������ֻ����һ�ε����֡�
 * Ҫ���¼�O(N) �ռ�O(1)
 * ���ϵķ����ǣ�
 * ����λ���ĵ�һ���ܵĽ����һ����Ϊ0��int���ּ�ΪintSign
 * ��intSign�еõ���һ����Ϊ0��λ����λ�ã�
 * ת��Ϊһ��ѭ���õ�һ��int ��
 * ���ַ����ǳ���Ч���ǳ�ֵ��ѧϰ
 */
public class ��40������ֻ����һ�ε����� {
	public static void main(String[] args) {
		int[] dataArray = {2, 4, 3, 6, 3, 2, 5, 5};
		TwoInt ti = splitIntoTwoIntArray(dataArray);
		System.out.println(ti.answer1 + "   " + ti.answer2);
	}
	private static int getSplitInt (int[] dataArray) {
		if (dataArray == null)
			return Integer.MIN_VALUE;
		int intSign = dataArray[0];
		for (int dataIndex = 1; dataIndex < dataArray.length; dataIndex ++) {
			intSign ^= dataArray[dataIndex];
		}
		int splitInt = 1;
		while ((intSign & 0x1) == 0) {
			splitInt = splitInt << 1;
			intSign = intSign >> 1;
		}
		return splitInt;
	}
	private static TwoInt splitIntoTwoIntArray (int[] dataArray) {
		TwoInt ti = new TwoInt ();
		int splitInt = getSplitInt(dataArray);
		for (int dataIndex = 0; dataIndex < dataArray.length; dataIndex ++) {
			if ((dataArray[dataIndex] & splitInt ) == splitInt) {
				ti.answer1 ^= dataArray[dataIndex];
			} else {
				ti.answer2 ^= dataArray[dataIndex];
			}
		}
		return ti;
	}
	static class TwoInt {
		int answer1;
		int answer2;
	}
}
