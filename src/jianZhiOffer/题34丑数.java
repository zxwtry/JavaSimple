package jianZhiOffer;
/*
 * ֻ��������2, 3, 5������������
 * ��С����ĵ�1500������
 * �������Կռ任�¼���˼ά
 */
public class ��34���� {
	public static void main(String[] args) {
		System.out.println(getUglyNumber(8));
	}
	private static int getUglyNumber (int numth) {
		int[] data;
		if (numth < 6)
			data = new int[6];
		else
			data = new int[numth];
		data[0] = 1;   data[1] = 2;   data[2] = 3;
		data[3] = 5;   data[4] = 6;   data[5] = 9;
		int m2 = 3, m3 = 3, m5 = 1;
		int index = 5;
		while (index < numth-1) {
			while (data[m2]*2 <= data[index])   m2 ++;
			while (data[m3]*3 <= data[index])   m3 ++;
			while (data[m5]*5 <= data[index])   m5 ++;
			data[++index] = Math.min(Math.min(data[m2]*2, data[m3]*3),data[m5]*5);
		}
		return data[numth-1];
	}
}