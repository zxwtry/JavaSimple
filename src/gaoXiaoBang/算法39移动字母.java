package gaoXiaoBang;

import java.util.Arrays;
import java.util.Scanner;

/*

 �ƶ���ĸ
2x3=6�������з���ABCDE�����ĸ�����½ǵ��Ǹ�����š���ͼ��ʾ
1.jpg
�Ϳո������ڵĸ����е���ĸ�����ƶ����ո��У�
���磬ͼ�е�C��E�Ϳ����ƶ����ƶ���ľ���ֱ��ǣ�
A B
D E C
A B C
D E
Ϊ�˱�ʾ���㣬���ǰ�6����������ĸ������һ������ʾ����
�������ϱߵ����־���ֱ��ʾΪ��
AB*DEC
ABCD*E
��Ŀ��Ҫ���ǣ����д�������û��������ɱ�ʾ����Ĵ���
����ͨ�����㣬����Ƿ���ͨ���Գ�ʼ״̬�������ɴ��ƶ������״̬��
����ʵ�����1���������0����ʼ״̬Ϊ��ABCDE*
�û�����ĸ�ʽ�ǣ�����һ������n����ʾ��������n��״̬��
�������ҲӦ����n��1��0
���磬�û����룺/p>
3
ABCDE*
AB*DEC
CAED*B
�����Ӧ�������
1
1
0 
 */

public class �㷨39�ƶ���ĸ {
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
