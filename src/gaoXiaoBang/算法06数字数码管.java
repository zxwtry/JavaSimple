package gaoXiaoBang;

/*



����
���������
���ֻ���ĸ������7λ�������ʾ����������Ϊ8���ε�7������ܣ�
 @@@@          0
     @           @       1   2
     @           @         3
       @@@@         4   5
     @           @         6
     @           @
       @@@@
���ڴ��͵ƹܣ�Ϊ�˽�Լʹ�ã����л����ֵ�ʱ��
����õƹܵ�״̬û�иı䣬����Ҫ�Ըõƹܹ����ٿ���
��֪һ�����ֱ仯��ϵ�У���7������ܿ��صĶ�����
3��0,2,3,5,6
6��0,1,4,6,5,3


 */


public class �㷨06��������� {
	//true��ʶ��
	//false��ʶ��
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
					System.out.printf(" %d ������۸ı�״̬\n" , i);
				}
			}
			System.out.println();
		}
	}
}
