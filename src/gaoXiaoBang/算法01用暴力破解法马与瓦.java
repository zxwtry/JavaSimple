package gaoXiaoBang;


/*


 ������

�ܹ��� 100 ƥ��

�ܹ����� 100 ���ߣ��Ŵ����ߣ��ܴ󣬺��أ�

ÿƥ����ÿ������ 3 ����

ÿƥС��ÿ������ 2 ����

С���ÿ�� 2������� 1����

����������Ŀ

��ʾ�������Ƕ��ģ�Ҫ�г����еĽ⡣ 


 */


public class �㷨01�ñ����ƽⷨ������ {
	//Ϊ�˱������С����ȫ������2
	private static final int NUM_OF_HORSE = 100;
	private static final int NUM_OF_TILE = 200;
	private static final int CARRY_OF_BIG_HORSE = 6;
	private static final int CARRY_OF_SMALL_HORSE = 4;
	private static final int CARRY_OF_TINY_HORSE = 1;
	public static void main(String[] args) {
		for (int numOfBigHorse = 0; numOfBigHorse <= NUM_OF_HORSE &&
				numOfBigHorse <= NUM_OF_TILE / CARRY_OF_BIG_HORSE; ++ numOfBigHorse) {
			for (int numOfSmallHorse = 0; (numOfSmallHorse+numOfBigHorse) <= NUM_OF_HORSE &&
					numOfSmallHorse <= NUM_OF_TILE / CARRY_OF_SMALL_HORSE; ++ numOfSmallHorse) {
				for (int numOfTinyHorse = 0; (numOfSmallHorse+numOfBigHorse+numOfTinyHorse) <= NUM_OF_HORSE &&
						numOfTinyHorse <= NUM_OF_TILE / CARRY_OF_TINY_HORSE; numOfTinyHorse += 2) {
					if ((numOfSmallHorse+numOfBigHorse+numOfTinyHorse) == NUM_OF_HORSE  &&  
							(numOfSmallHorse*CARRY_OF_SMALL_HORSE+numOfBigHorse*CARRY_OF_BIG_HORSE+numOfTinyHorse*CARRY_OF_TINY_HORSE) == NUM_OF_TILE) {
						System.out.println("�������� : " + numOfBigHorse +
								"\nС������ : " + numOfSmallHorse +
								"\nС������� : " + numOfTinyHorse + "\n\n");
					}
				}
			}
		}
	}
}
