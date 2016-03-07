package gaoXiaoBang;

/*



问题
数字数码管
数字或字母可以用7位数码管显示（就是排列为8字形的7个数码管）
 @@@@          0
     @           @       1   2
     @           @         3
       @@@@         4   5
     @           @         6
     @           @
       @@@@
对于大型灯管，为了节约使用，在切换数字的时候，
如果该灯管的状态没有改变，则不需要对该灯管关了再开。
已知一个数字变化的系列，求7个数码管开关的动作。
3：0,2,3,5,6
6：0,1,4,6,5,3


 */


public class 算法06数字数码管 {
	//true标识亮
	//false标识暗
	final static boolean[][] STATE = {
		//0       1       2       3       4       5       6
		{true,  true , true , false, true , true , true }, //0
		
		{false, false, true , false, false, true , false}, //1
		
		{true , false, true , true , true , false, true }, //2
		
		{true , false, true , true , false, true , true }, //3
		
		{false, true , true , true , false, true , false}, //4
		
		{true , true , false, true , false, true , true }, //5
		
		{true , true , false, true , true , true , true }, //6
		
		{true , false, true , false, false, true , false}, //7
		
		{true , true , true , true , true , true , true }, //8
		
		{true , true , true , true , false, true , true }  //9
		
	};
	
	public static void main(String[] args) {
		changeFromIntToInt(8,0);
		changeFromIntToInt(0,8);
//		changeFromIntToInt(8,1);
//		changeFromIntToInt(8,2);
//		changeFromIntToInt(8,3);
//		changeFromIntToInt(8,4);
//		changeFromIntToInt(8,5);
//		changeFromIntToInt(8,6);
//		changeFromIntToInt(8,7);
//		changeFromIntToInt(8,9);
		
	}
	
	private static void changeFromIntToInt(int intBegin, int intEnd) {
		if (intBegin >= 0 && intBegin <10 && intEnd >= 0 && intEnd < 10) {
			boolean[] stateBegin = STATE[intBegin];
			boolean[] stateEnd = STATE[intEnd];
			boolean[] stateChanged = new boolean[7];
			for (int i = 0; i < 7; i ++) {
				stateChanged[i] = stateBegin[i] ^ stateEnd[i];
				if (stateChanged[i]) {
					System.out.printf(" %d 号数码港改变状态\n" , i);
				}
			}
			System.out.println();
		}
	}
}
