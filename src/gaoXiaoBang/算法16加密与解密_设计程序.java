package gaoXiaoBang;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*

问题
设计程序
一种Playfair密码变种加密方法如下：
首先选择一个密钥单词（称为pair）（字母不重复，且都为小写字母）
，然后与字母表中其他字母一起填入至一个5x5的方阵中，填入方法如下：
1.首先按行填入密钥串。
2.紧接其后，按字母序按行填入不在密钥串中的字母。
3.由于方阵中只有25个位置，最后剩下的那个字母则不需变换。
如果密钥为youandme，则该方阵如下：
y o u a n
d m e b c
f g h i j
k l p q r
s t v w x
在加密一对字母时，如am，在方阵中找到以这两个字母为顶点的矩形（红色字体）：
y o u a n
d m e b c
f g h i j
k l p q r
s t v w x
这对字母的加密字母为该矩形的另一对顶点，如本例中为ob。
请设计程序，使用上述方法对输入串进行加密，并输出加密后的串。
另外有如下规定：
1、一对一对取字母，如果最后只剩下一个字母，则不变换，直接放入加密串中；
2、如果一对字母中的两个字母相同，则不变换，直接放入加密串中；
3、如果一对字母中有一个字母不在正方形中，则不变换，直接放入加密串中；
4、如果字母对出现在方阵中的同一行或同一列，如df或hi，
则只需简单对调这两个字母，即变换为fd或ih；
5、如果在正方形中能够找到以字母对为顶点的矩形，假如字母对为am，
则该矩形的另一对顶点字母中，与a同行的字母应在前面，在上例中应是ob；
同样若待变换的字母对为ta，则变换后的字母对应为wo；
6、本程序中输入串均为小写字母，并不含标点、空格或其它字符。
解密方法与加密相同，即对加密后的字符串再加密，将得到原始串。
要求输入形式如下：
从控制台输入两行字符串，第一行为密钥单词（长度小于等于25），
第二行为待加密字符串（长度小于等于50），
两行字符串末尾都有一个回车换行符，并且两行字符串均为小写字母，
不含其它字符。

在标准输出上输出加密后的字符串。
例如，若输入：
youandme
welcometohangzhou
则表示输入的密钥单词为youandme，
形成的正方形如上所示；待加密字符串为welcometohangzhou。
在正方形中可以找到以第一对字母we为顶点的矩形，
对应另一对顶点字母为vb，因此加密后为vb，
同理可找到与字母对lc,et,oh,ho对应的顶点字母对。
而字母对om位于上述正方形中的同一列，
所以直接以颠倒这两个字母来加密，即为mo，字母对an同理。
字母对gz中的z不在上述正方形中，因此原样放到加密串中。
最后剩一个字母u也原样输出。

因此输出的结果为：
vbrmmomvugnagzguu
 */


public class 算法16加密与解密_设计程序 {
	private static char cUnUsed;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String pair = br.readLine().trim();
		String secrectString = br.readLine().trim();
		char[] pairChar = pair.toCharArray();
		char[] strChar  = secrectString.toCharArray();
		char[][] matrix = new char[5][5];
		boolean[] isExists = new boolean[26];
		Arrays.fill(isExists, false);
		for (int i = pairChar.length-1; i >=0; -- i) {
			isExists[pairChar[i]-'a'] = true;
		}
		for (int i = 0; i < pairChar.length/5; ++ i) {
			System.arraycopy(pairChar, i*5, matrix[i], 0, 5);
		}
		System.arraycopy(pairChar, (pairChar.length/5)*5, matrix[pairChar.length/5], 0, pairChar.length-(pairChar.length/5)*5);
		int index = pairChar.length;
		for (int i = 0;i < 26; ++ i) {
			if (!isExists[i] && index<25) {
				matrix[index/5][index%5] = (char)('a'+i);
				isExists[i] = true;
				index ++;
			}
		}
		for (int i = 0; i < 26; ++ i) {
			if (!isExists[i]) {
				cUnUsed = (char)('a'+i);
			}
		}
//		System.out.println(cUnUsed);
		for (int i = 0; i < strChar.length-1; i+=2) {
			getTheEncrypt(strChar,i,matrix);
		}
		for (int i = 0; i < 5; i ++) {
			for (int j = 0; j < 5; j ++) {
//				System.out.printf("%c ",matrix[i][j]);
			}
//			System.out.println();
		}
		br.close();
		System.out.println(String.valueOf(strChar));
	}
	private static void getTheEncrypt(char[] strChar, int i, char[][] matrix) {
		char c3 = strChar[i], c4 = strChar[i+1];
		if (c3 == c4) {
			return;
		}
		if (c3 == cUnUsed || c4 == cUnUsed) {
			return;
		}
		Point p1 = getPoint(c3,matrix);
		Point p2 = getPoint(c4,matrix);
		if (p1.x == p2.x || p1.y == p2.y) {
			strChar[i] = c4;
			strChar[i+1] = c3;
			return;
		}
		strChar[i] = matrix[p1.x][p2.y];
		strChar[i+1] = matrix[p2.x][p1.y];
	}
	private static Point getPoint (char c, char[][] matrix) {
		Point re = new Point();
		for (int i = 0; i < 5; i ++) {
			for (int j = 0; j < 5; ++ j) {
				if (matrix[i][j] == c) {
					re.x = i;
					re.y = j;
				}
			}
		}
		return re;
	}
	static class Point {
		int x,y;
	}
}
