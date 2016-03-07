package gaoXiaoBang;
public class 第二章Set接口与应用_推算年龄 {
	private static final int MIN_4 = 1000;
	private static final int MAX_4 = 9999;
	private static final int MIN_6 = 100000;
	private static final int MAX_6 = 999999;
	private static int MIN_4_3 = (int)Math.pow(MIN_4,(double)1/3);
 	private static int MAX_4_3 = (int)Math.pow(MAX_4,(double)1/3);
	private static int MIN_6_4 = (int)Math.sqrt(Math.sqrt(MIN_6));
	private static int MAX_6_4 = (int)Math.sqrt(Math.sqrt(MAX_6));
 	private static boolean used[] = {false,false,false,false,false,
									false,false,false,false,false};
	public static void main (String[] args) {
		if (Math.pow(MIN_4_3,3) < MIN_4)		MIN_4_3 ++;
		if ((int)Math.pow(MAX_4_3+1,3) <= MAX_4)	MAX_4_3 ++;
		if (Math.pow(MIN_6_4,4) < MIN_6)		MIN_6_4 ++;
		if ((int)Math.pow(MAX_6_4+1,4) <= MAX_6)	MAX_6_4 ++;
		int forMin = (MIN_4_3 < MIN_6_4 ? MIN_6_4 : MIN_4_3);
		int forMax = (MAX_4_3 < MAX_6_4 ? MAX_4_3 : MAX_6_4);
		for (int t = forMin; t <= forMax; t ++) {
			int tmp_3 = (int)Math.pow(t,3);
			int tmp_4 = (int)Math.pow(t,4);
			boolean isRepeat = false;
			while(!used[tmp_3 % 10] && !isRepeat)	{
				used[tmp_3 % 10] = true;
				tmp_3 /= 10;
				if (tmp_3 == 0)	break;
			}
			if (tmp_3 != 0)	isRepeat = true;
			while(!used[tmp_4 % 10] && !isRepeat)	{
				used[tmp_4 % 10] = true;
				tmp_4 /= 10;
				if (tmp_4 == 0)	break;
			}
			if (tmp_4 != 0)	isRepeat = true;
			if (!isRepeat){
				System.out.println("The age is "+t);
				break;
			}
			for (int i = 0; i < used.length; i ++)
				used[i] = false;
		}
	}
}