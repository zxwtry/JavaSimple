package gaoXiaoBang;

/*


��������
���뱸�����ҷ�
���ǵ���������ܳ��ܸ��ӣ��������ǡ����̫�򵥣�����ȫ��
 �������¼�ڱ����ϣ�������й�ܣ�
����������ô���취��������Ƕ��һ������������С�
��Ϊÿ���˶�������ȫ��ס���ѣ�����һЩ�����л�������ͺ����ס�
���룺75383
3 5 6 4 7 2 8 6
5 4 7 2 7 0 7 4
1 6 5 9 5 8 0 3
1 6 7 0 3 6 8 9
3 6 4 7 8 0 9 4
3 4 6 9 3 6 8 9
2 1 3 6 7 8 1 3
2 7 3 9 4 6 3 5
Ƕ��ʱ�����Ժ������������ٸ��ӵ㣬������ƶԽ���

 */



public class �㷨07������ {
	//�趨���򣺴��������볤��Ϊ��Ϊ��ľ���
	//ÿ�����,��10ȡ��õ��ľ��Ǹ�λ�õ�����
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
