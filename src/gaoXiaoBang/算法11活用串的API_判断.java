package gaoXiaoBang;

/*


问题
以下哪个全路径名是在c盘且是.ini扩展名。
"c:\\xyz\\bak\\x.ini" 复合标准
"ccc\\ttt\\kk\\ini" 则不是

 */

public class 算法11活用串的API_判断 {
	public static void main(String[] args) {
		final String forTest = "c:\\xyz\\bak\\AAAA.Ini";
//		final String forTest = "c:\\xyz\\bak\\x.ini";
//		final String forTest = "ccc\\ttt\\kk\\ini";
		System.out.println(isInCAndIni(forTest));
	}
	
	private static boolean isInCAndIni(String forTest) {
		String[] splitForTest = forTest.split("\\\\");
		if ((splitForTest[0].equals("c:")||splitForTest[0].equals("C:") )) {
			String judgeTemp = splitForTest[splitForTest.length-1];
			if (judgeTemp.length() >= 5) {
				if ( judgeTemp.substring(judgeTemp.length()-4).toLowerCase().equals(".ini") ) {
					return true;
				}
			}
		}
		return false;
	}
}
