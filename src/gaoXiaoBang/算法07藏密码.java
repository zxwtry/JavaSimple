package gaoXiaoBang;

/*


隐藏密码
密码备忘扰乱法
我们的密码如果很长很复杂，容易忘记。如果太简单，不安全。
 把密码记录在本子上，更容易泄密！
有人想了这么个办法，把密码嵌入一堆随机的数字中。
因为每个人对密码完全记住困难，但从一些线索中回忆出来就很容易。
密码：75383
3 5 6 4 7 2 8 6
5 4 7 2 7 0 7 4
1 6 5 9 5 8 0 3
1 6 7 0 3 6 8 9
3 6 4 7 8 0 9 4
3 4 6 9 3 6 8 9
2 1 3 6 7 8 1 3
2 7 3 9 4 6 3 5
嵌入时，可以横向或纵向。如果再复杂点，可以设计对角线

 */



public class 算法07藏密码 {
	//设定规则：创建以密码长度为长为宽的矩阵
	//每行相加,对10取余得到的就是该位置的密码
	public static void main(String[] args) {
		String passwordToSave = "75383";
		char[] passwordChar = passwordToSave.toCharArray();
		int[][] anotherPassword = new int[passwordChar.length][passwordChar.length];
		for (int i = 0 ; i < passwordChar.length; ++ i) {
			int sumOfThisRow = 0;
			for (int j = 0; j < passwordChar.length - 1; ++ j) {
				anotherPassword[i][j] = getRandomInt();
				sumOfThisRow += anotherPassword[i][j];
			}
			anotherPassword[i][passwordChar.length-1] =
					(sumOfThisRow%10-passwordChar[i] +'0' > 0 ? 
							10 + passwordChar[i] - '0' - sumOfThisRow%10 : 
								passwordChar[i] - '0' - sumOfThisRow%10);
		}
		for (int i = 0; i < anotherPassword.length; ++ i) {
			for (int j = 0; j < anotherPassword[0].length; ++ j) {
				System.out.printf("%d ", anotherPassword[i][j]);
			}
			System.out.println();
		}
	}
	
	private static int getRandomInt () {
		return (int)(Math.random()*10);
	}
}
