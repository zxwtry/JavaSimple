package gaoXiaoBang;

/*


����
�����ĸ�ȫ·��������c������.ini��չ����
"c:\\xyz\\bak\\x.ini" ���ϱ�׼
"ccc\\ttt\\kk\\ini" ����

 */

public class �㷨11���ô���API_�ж� {
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
