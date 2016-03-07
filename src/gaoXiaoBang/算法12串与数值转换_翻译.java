package gaoXiaoBang;

/*


问题
翻译
把大写数字翻译为整数：
一四零零六 ==> 14006
二五七 ==> 257


 */


public class 算法12串与数值转换_翻译 {
	private final static char[] CHINESE_NUMBER = {
			'零','一','二','三','四','五','六','七','八','九'
	};
	
	public static void main(String[] args) {
		String chineseCharacter = "一四零零六";
		char[] cc = chineseCharacter.toCharArray();
		if (cc.length > 9)
			System.out.println("输入数字过大");
		int ans = 0;
		for (int i = 0; i < cc.length; ++ i ) {
			for (int j = 0; j < CHINESE_NUMBER.length; ++ j) {
				if (cc[i] == CHINESE_NUMBER[j]) {
					ans = ans * 10 + j;
					break;
				}
			}
		}
		System.out.println(ans);
	}
}
