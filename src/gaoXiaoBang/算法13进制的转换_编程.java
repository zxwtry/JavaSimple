package gaoXiaoBang;

/*

编程
Excel 单元格地址有两种格式：
普通格式，如：A5, BC12
对应的RC格式：R5C1, R12C55
显然，RC格式是直接给出行号和列号
请编程在两种地址格式间转换。

 */

public class 算法13进制的转换_编程 {
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
