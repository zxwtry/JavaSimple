package gaoXiaoBang;

/*


����
����
�Ѵ�д���ַ���Ϊ������
һ�������� ==> 14006
������ ==> 257


 */


public class �㷨12������ֵת��_���� {
	private final static char[] CHINESE_NUMBER = {
			'��','һ','��','��','��','��','��','��','��','��'
	};
	
	public static void main(String[] args) {
		String chineseCharacter = "һ��������";
		char[] cc = chineseCharacter.toCharArray();
		if (cc.length > 9)
			System.out.println("�������ֹ���");
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
