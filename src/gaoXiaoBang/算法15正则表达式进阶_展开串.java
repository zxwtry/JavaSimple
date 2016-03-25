package gaoXiaoBang;






/*

Pattern : 
	1,	代表正则表达式本身
	2，	对正则进行预先的编译处理
	3，	提高处理的效果

Matcher
	1,	代表正则匹配的结果
	2,	实现更加复杂的管理
		（如：进行子组的管理）


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



问题
展开串
实际开发中，常常会出现用到一批文件，而这些文件的文件名有某种规律，
我们在表述的时候，往往习惯简写，但这样程序又不好识别。
比如：
c:/abc/xyz/k[11..19].dat
实际表示的就是：
c:/abc/xyz/k11.dat
c:/abc/xyz/k12.dat
c:/abc/xyz/k13.dat
c:/abc/xyz/k14.dat
c:/abc/xyz/k15.dat
c:/abc/xyz/k16.dat
c:/abc/xyz/k17.dat
c:/abc/xyz/k18.dat
c:/abc/xyz/k19.dat
本题目要求是：给定一个含有简写的串，要求展开为所有文件名。
简写的格式为：[整数..整数]
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class 算法15正则表达式进阶_展开串 {
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
