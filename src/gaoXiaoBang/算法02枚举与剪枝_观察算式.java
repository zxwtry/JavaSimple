package gaoXiaoBang;

/*




�۲���ʽ

�۲��������ʽ��

������ * ���� = ��������

ĳ3λ������2λ�������Ϊ4λ��

Ҫ����9����������������У�1~9������ǡ��ÿ������1�Ρ�


 */

public class �㷨02ö�����֦_�۲���ʽ {
	//�趨��λ����multiplicator1,��λ����multiplicator2,��λ����quotient
	public static void main(String[] args) {
		findAllPossible(new int[10], 1);
	}
	
	private static void findAllPossible(int[] data, int index) {
		for (int indexCheck = 1; indexCheck < index-1; ++ indexCheck) {
			if (data[indexCheck] == data[index-1])
				return;
		}
		if (index == 10) {
			int multiplicator1, multiplicator2, quotient;
			multiplicator1 = data[3] + data[2]*10 +data[1]*100;
			multiplicator2 = data[5] + data[4]*10;
			quotient = data[9] + data[8]*10 + data[7]*100 + data[6]*1000;
			if (multiplicator1 * multiplicator2 == quotient) {
				System.out.println(multiplicator1 + " * " + multiplicator2 + " = " + quotient );
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
