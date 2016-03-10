package oj.pku;


public class poj1019 {
	// ��Tools���Ѿ����ԣ�getWeiShu������Math.log10();�ܹ����һ���Ĺ���
	public static void main(String[] args) {
		java.util.Scanner in = new java.util.Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			System.out.println(location(in.nextInt()));
		}
		in.close();
	}

	private static int location(int i) {
		// i ���������������������λ�õ���
		// j ���ƶ�λ��(��ʼ1)
		// base ��¼ÿһ�������Ƶ�λ��(��ʼ0)
		// sum ��¼������λ������������(��ʼ1)
		int j = 1, base = 0, sum = 1;
		while (i >= sum) {
			i -= sum;
			j++; // j ������һ�������ĸ����ִ�(123..)
			base = (int) Math.log10(j) + 1; // j��λ��
			sum += base; // �ô����ַ�����
		}
		// ��ʼ�жϣ�һ��i==0��ô���Ǿ������
		if (i == 0)
			return (j - 1) % 10;
		sum = 1; // �Ӵ�(12...j)�е�һ������ʼ��
		base = 1; // ���е�һ������λ����1
		while (i >= base) { // ��12...j���е�i������
			i -= base;
			sum++;
			base = (int) Math.log10(sum) + 1;
		}
		if (i == 0)
			return (sum - 1) % 10;
		j = (int) Math.log10(sum) + 1 - i;
		while (j-- > 0)
			sum /= 10;
		return sum % 10;
	}
}
