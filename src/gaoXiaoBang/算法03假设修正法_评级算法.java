package gaoXiaoBang;


/*



“评级”算法

某小学要求不能给学生打具体分数，而是给一个评级。

当然，这个“评级”也是根据分数计算出来的。

规则：

设百分制的分数为 n

则根据 n 的范围：

90-100： 优秀

80-89： 良好

70-79: 正常

60-69: 合格

0-59: 加油

已经知道了分数 n， 请计算“评级”

注意：不允许使用else语句，当然也不能使用 switch，因为题目的目的是训练假设修正法。


 */



public class 算法03假设修正法_评级算法 {
	private static final String[] LEVEL = {"加油",  "合格",  "正常",  "良好",  "优秀"};
	public static void main(String[] args) {
		System.out.println(getLevel(50));
		System.out.println(getLevel(60));
		System.out.println(getLevel(90));
		System.out.println(getLevel(100));
	}
	
	private static String getLevel (int mark) {
		if (mark<60)
			mark = 59;
		if (mark>99)
			mark = 99;
		return LEVEL[((mark/60)*10+mark-60)/10];
	}
}
