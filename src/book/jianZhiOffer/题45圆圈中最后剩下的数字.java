package book.jianZhiOffer;
/*
 * �����Լɪ������(Josephuse)
 */
public class ��45ԲȦ�����ʣ�µ����� {
	public static void main(String[] args) {
		System.out.println(getJosephuseNM(3,1));
	}
	private static int getJosephuseNM (int N, int M) {
		//��������Ҫ����д��״̬ת�Ʒ���
		if (N < 1)   return -1; 
		if (N == 1 && M >0)
			return 0;
		int last = 0;
		for (int t = 2; t <= N ; t ++) {
			last = (last + M) % t;
		}
		return last;
	}
}
