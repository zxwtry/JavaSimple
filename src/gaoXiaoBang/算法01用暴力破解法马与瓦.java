package gaoXiaoBang;


/*


 马与瓦

总共有 100 匹马

总共驮有 100 块瓦（古代的瓦，很大，很重）

每匹大马每次能驮 3 块瓦

每匹小马每次能驮 2 块瓦

小马驹每次 2个马驹驮 1块瓦

求各种马的数目

提示：可能是多解的，要列出所有的解。 


 */


public class 算法01用暴力破解法马与瓦 {
	//为了避免出现小数，全部乘以2
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
						System.out.println("大马数量 : " + numOfBigHorse +
								"\n小马数量 : " + numOfSmallHorse +
								"\n小马驹数量 : " + numOfTinyHorse + "\n\n");
					}
				}
			}
		}
	}
}
