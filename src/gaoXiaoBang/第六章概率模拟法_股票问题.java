/*
��Ʊ�����ϵ�Ͷ����Ϊ����ʮ��Σ�ա�����ĳ��Ʊ��Ϊʮ�ֹ��죬
ÿ�첻����ͣ������10%�����ǵ�ͣ���µ�10%����
�������Ǻ��µ��ĸ��ʾ��ȣ�����50%����
�ټ��轻�׹���û���κ������ѡ�
ĳ���ڿ�ʼ��ʱ������ܼ�ֵΪx�ĸùɹ�Ʊ����ô100�������պ�
��ӯ���Ŀ������Ƕ����أ�
 */


package gaoXiaoBang;

public class �����¸���ģ�ⷨ_��Ʊ���� {
	static final int NUM = 10000;
	public static void main(String[] args) {
		double money = 1;
		int count = 0;
		for (int j = 0; j < NUM; ++ j) {
			money = 1;
			for (int i = 0; i < 100; ++ i) {
				if ((int)(Math.random()+0.5)==0) {
//					money *= 1.1;
					money *= 0.9;
				} else {
//					money *= 0.9;
					money *= 1.1;
				}
			}
			if (money > 1) {
				count ++;
			}
		}
		System.out.println((double)count/NUM);
	}
}
