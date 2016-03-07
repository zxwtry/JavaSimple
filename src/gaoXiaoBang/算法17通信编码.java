package gaoXiaoBang;

/*



问题
通信编码
假设通信的物理设备只能表示1和0两种状态。
1和0状态都不能持续太久，否则物理设备会出现故障。因而人们设计出一种变通的方法：
多个0后人为地补入一个1
多个1后人为地补入一个0
当然，在解码的时候，要相应处理。
下面我们用串来模拟这个算法。
假设有需要通信的串：
String s = "1010100100100001011110100010101010100001010101111";
连续的3个0，后需要插入一个1
连续的3个1，后需要输入一个0
10101001001000101011101010001101010....
想一想，加码处理后，需要把它再解码出来。
 */
public class 算法17通信编码 {
	private static char c1, c2;
	public static void main(String[] args) {
		String s = "1010100100100001011110100010101010100001010101111";
		char[] sChar = s.toCharArray();
		StringBuffer st = new StringBuffer();
		if (sChar.length < 3) {
			System.out.println(s);
			return;
		}
		c1 = sChar[0];
		c2 = sChar[1];
		st.append(c1);
		st.append(c2);
		for (int i = 2; i < sChar.length; ++ i) {
			st.append(sChar[i]);
			if (c1 == c2 && c1 == sChar[i]) {
				if (c1 == '0') {
					c1 = c2;
					c2 = '1';
					st.append('1');
				} else {
					c1 = c2;
					c2 = '0';
					st.append('0');
				}
			} else {
				c1 = c2;
				c2 = sChar[i];
			}
		}
		System.out.println(st.toString());
		System.out.println(decodeString(st.toString()));
	}
	private static String decodeString (String str) {
		StringBuffer st = new StringBuffer();
		char[] cStr = str.toCharArray();
		if (cStr.length < 3) {
			return str;
		}
		c1 = cStr[0];
		c2 = cStr[1];
		st.append(c1);
		st.append(c2);
		for (int i = 2; i < cStr.length; ++ i) {
			st.append(cStr[i]);
			if (c1 == c2 && c1 == cStr[i]) {
				c1 = c2;
				if (c1 == '0') {
					c2 = '1';
				} else {
					c2 = '0';
				}
				++ i;
			} else {
				c1 = c2;
				c2 = cStr[i];
			}
		}
		return st.toString();
	}
}
