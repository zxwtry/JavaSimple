package gaoXiaoBang;






/*

Pattern : 
	1,	����������ʽ����
	2��	���������Ԥ�ȵı��봦��
	3��	��ߴ����Ч��

Matcher
	1,	��������ƥ��Ľ��
	2,	ʵ�ָ��Ӹ��ӵĹ���
		���磺��������Ĺ���


String s = "2+3*(5*(12-6))"
Pattern pt = Pattern.compile("\\(([^\\(\\)]*)\\)"); // (12-6)


import java.util.regex.*;

Pattern pt = Pattern.compile("\\([^\\(\\)]*\\)")

Matcher mc =  pt.matcher(s);

if (mc.find()) {
	syso(mc.group())
	syso(mc.group(1))
	syso(mc.start())
	syso(mc.end())

}

Pattern pt = Pattern.compile("([0-9]+)\\*([0-9]+)");



 */

/*



����
չ����
ʵ�ʿ����У�����������õ�һ���ļ�������Щ�ļ����ļ�����ĳ�ֹ��ɣ�
�����ڱ�����ʱ������ϰ�߼�д�������������ֲ���ʶ��
���磺
c:/abc/xyz/k[11..19].dat
ʵ�ʱ�ʾ�ľ��ǣ�
c:/abc/xyz/k11.dat
c:/abc/xyz/k12.dat
c:/abc/xyz/k13.dat
c:/abc/xyz/k14.dat
c:/abc/xyz/k15.dat
c:/abc/xyz/k16.dat
c:/abc/xyz/k17.dat
c:/abc/xyz/k18.dat
c:/abc/xyz/k19.dat
����ĿҪ���ǣ�����һ�����м�д�Ĵ���Ҫ��չ��Ϊ�����ļ�����
��д�ĸ�ʽΪ��[����..����]
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class �㷨15������ʽ����_չ���� {
	public static void main(String[] args) {
		String s = "c:/abc/xyz/k[11..19].dat";
		Pattern pt = Pattern.compile("\\[([0-9]*)[.]*([0-9]*)\\]");
		Matcher mc = pt.matcher(s);
		int start = 0, end = 0;
		if (mc.find()) {
			start = Integer.parseInt(mc.group(1));
			end = Integer.parseInt(mc.group(2));
		}
		for (int i = start; i <= end; ++ i) {
			System.out.println(s.replaceAll("\\[([0-9]*)[.]*([0-9]*)\\]", String.valueOf(i)));
		}
	}
}
