package gaoXiaoBang;

/*

 ��ɢ�ַ���

��������ַ�����ɢΪ���ֺ��ַ����ɵĴ�

String s1 = "abc1234xyz667kkmd764tttt";

������ĸ�����ּ�����ɣ�Ҫ��������е���ĸ�κ����ֶΣ�����

abc

1234

xyz

667

kkmd

764

tttt 


" {1,}"
" +"

s.matchs("[A-Z]{1,2}[0-9]{1,5}")

?{0,1} 
+{1,}
*{1,}

replaceAll
replaceFirst
s.replaceAll("([0-9]{4})-([0-9]{2})-([0-9]{2})","$3/$2 $1��")


 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class �㷨14������ʽ����_��ɢ�ַ��� {
	public static void main(String[] args) {
		String s = "abc1234xyz667kkmd764tttt";
		Pattern pt1 = Pattern.compile("[a-z]*");
		Pattern pt2 = Pattern.compile("[0-9]*");
		boolean isChar = true;


		while (s.length()>0) {
			if (isChar) {
				Matcher mc1 = pt1.matcher(s);
				if (mc1.find()) {
					System.out.println(mc1.group());
					s = s.substring(mc1.end());
					isChar = !isChar;
				}
			} else {
				Matcher mc2 = pt2.matcher(s);
				if (mc2.find()) {
					System.out.println(mc2.group());
					s = s.substring(mc2.end());
					isChar = !isChar;
				}
			}
		}
	}
}
