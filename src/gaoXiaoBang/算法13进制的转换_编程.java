package gaoXiaoBang;

/*

���
Excel ��Ԫ���ַ�����ָ�ʽ��
��ͨ��ʽ���磺A5, BC12
��Ӧ��RC��ʽ��R5C1, R12C55
��Ȼ��RC��ʽ��ֱ�Ӹ����кź��к�
���������ֵ�ַ��ʽ��ת����

 */

public class �㷨13���Ƶ�ת��_��� {
	public static void main(String[] args) {
		final String inExcel = "BC12";
		char[] inExcelChar = inExcel.toCharArray();
		boolean isRowNow = true;
		int row = 0, column = 0;
		for (int i = 0; i < inExcelChar.length; i ++) {
			if (isRowNow) {
				if (inExcelChar[i]>='0' && inExcelChar[i]<='9') { 
					isRowNow = false;
				} else {
					column = column * 26 + inExcelChar[i] - 'A' + 1;
				}
			}
			if (!isRowNow) {
				row = row * 10 + inExcelChar[i] - '0';
			}
		}
		String newForm = new String("R"+row+"C"+column);
		System.out.println(newForm);
	}
}
