package gaoXiaoBang;

/*

�㷨
�������ʽ��
���� + ���� = ����
���ÿ������Ǵ��� 1 ~ 9 �Ĳ�ͬ�����֡�
�����ʽ�ж����ֿ��ܵ���ȷ��д������
173 + 286 = 459
295 + 173 = 468
173 + 295 = 468
183 + 492 = 675
���϶�����ȷ����д����
ע�⣺
111 + 222 = 333 �Ǵ������д����
��Ϊÿ�����ֱ����ǲ�ͬ�ģ�
Ҳ����˵��1~9�е��������֣�ÿ����������ҽ�����һ�Σ�
ע�⣺
���������֡�0����
ע�⣺
����ӷ������ʵ�ʽ�������ֲ�ͬ�Ĵ𰸡�
���Դ𰸿϶��Ǹ�ż����


 */


public class �㷨58�㷨 {
	//�趨��λ����multiplicator1,��λ����multiplicator2,��λ����quotient
	private static int count = 0;
	public static void main(String[] args) {
		findAllPossible(new int[10], 1);
		System.out.println("�ܹ���"+count+"�����");
	}
	
	private static void findAllPossible(int[] data, int index) {
		for (int indexCheck = 1; indexCheck < index-1; ++ indexCheck) {
			if (data[indexCheck] == data[index-1])
				return;
		}
		if (index == 10) {
			int multiplicator1, multiplicator2, quotient;
			multiplicator1 = data[3] + data[2]*10 + data[1]*100;
			multiplicator2 = data[6] + data[5]*10 + data[4]*100;
			quotient = data[9] + data[8]*10 + data[7]*100;
			if (multiplicator1 + multiplicator2 == quotient) {
				count ++;
				System.out.println(multiplicator1 + " + " + multiplicator2 + " = " + quotient );
			}
			return;
		}
		for (int indexTry = 1; indexTry < 10; ++ indexTry) {
			data[index] = indexTry;
			index ++;
			findAllPossible(data, index);
			index --;
		}
		
	}


}
