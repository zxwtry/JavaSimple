package gaoXiaoBang;

/*



����
ͨ�ű���
����ͨ�ŵ������豸ֻ�ܱ�ʾ1��0����״̬��
1��0״̬�����ܳ���̫�ã����������豸����ֹ��ϡ����������Ƴ�һ�ֱ�ͨ�ķ�����
���0����Ϊ�ز���һ��1
���1����Ϊ�ز���һ��0
��Ȼ���ڽ����ʱ��Ҫ��Ӧ����
���������ô���ģ������㷨��
��������Ҫͨ�ŵĴ���
String s = "1010100100100001011110100010101010100001010101111";
������3��0������Ҫ����һ��1
������3��1������Ҫ����һ��0
10101001001000101011101010001101010....
��һ�룬���봦�����Ҫ�����ٽ��������
 */
public class �㷨17ͨ�ű��� {
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
