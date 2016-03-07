package gaoXiaoBang;

import java.util.Arrays;
import java.util.Scanner;

/*

 移动字母
2x3=6个方格中放入ABCDE五个字母，右下角的那个格空着。如图所示
1.jpg
和空格子相邻的格子中的字母可以移动到空格中，
比如，图中的C和E就可以移动，移动后的局面分别是：
A B
D E C
A B C
D E
为了表示方便，我们把6个格子中字母配置用一个串表示出来
，比如上边的两种局面分别表示为：
AB*DEC
ABCD*E
题目的要求是：请编写程序，由用户输入若干表示局面的串，
程序通过计算，输出是否能通过对初始状态经过若干次移动到达该状态。
可以实现输出1，否则输出0。初始状态为：ABCDE*
用户输入的格式是：先是一个整数n，表示接下来有n行状态。
程序输出也应该是n行1或0
例如，用户输入：/p>
3
ABCDE*
AB*DEC
CAED*B
则程序应该输出：
1
1
0 
 */

public class 算法39移动字母 {
	private static int[][] map = {
			{1, 3},
			{0, 2, 4},
			{1, 5},
			{0, 4},
			{1, 3, 4},
			{2, 4}
	};
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		while (num-- > 0) {
			System.out.println(travel(scan.nextLine().trim().toCharArray(), null));
		}
		scan.close();
	}
	private static boolean travel (char[] c, boolean[] isHere) {
		if (isHere == null) {
			isHere = new boolean [c.length];
			Arrays.fill(isHere, false);
		} else {
			boolean isAll = true;
			for (int i = 0; i < isHere.length; ++ i) {
				isAll &= isHere[i];
			}
			if (isAll) {
				return true;
			}
		}
		if (String.valueOf(c).equals("ABCDE*")) {
			return true;
		}
		int indexOfStar = 0;
		for (indexOfStar = 0; indexOfStar < c.length; indexOfStar ++) {
			if (c[indexOfStar] == '*')
				break;
		}
		isHere[indexOfStar] = true;
		for (int indexOfAvail = 0; indexOfAvail < map[indexOfStar].length; ++ indexOfAvail) {
			char tmp = c[map[indexOfStar][indexOfAvail]];
			c[map[indexOfStar][indexOfAvail]] = c[indexOfStar];
			c[indexOfStar] = tmp;
			travel(c, isHere);
			tmp = c[map[indexOfStar][indexOfAvail]];
			c[map[indexOfStar][indexOfAvail]] = c[indexOfStar];
			c[indexOfStar] = tmp;
		}
		return travel(c, isHere);
	}
}
