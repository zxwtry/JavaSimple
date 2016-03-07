/*
这是一个纵横火柴棒游戏。如图，在3x4的格子中，游戏的双方轮流放置火柴棒。其规则是：

1. 不能放置在已经放置火柴棒的地方（即只能在空格中放置）。

2. 火柴棒的方向只能是竖直或水平放置。

3. 火柴棒不能与其它格子中的火柴“连通”。所谓连通是指两根火柴棒可以连成一条直线，且中间没有其它不同方向的火柴“阻拦”。

例如：图所示的局面下，可以在C2位置竖直放置（为了方便描述格子位置，图中左、下都添加了标记），但不能水平放置，因为会与A2连通。同样道理，B2，B3，D2此时两种方向都不可以放置。但如果C2竖直放置后，D2就可以水平放置了，因为不再会与A2连通（受到了C2的阻挡）。

4. 游戏双方轮流放置火柴，不可以弃权，也不可以放多根。直到某一方无法继续放置，则该方为负（输的一方）。

游戏开始时可能已经放置了多根火柴。

你的任务是：编写程序，读入初始状态，计算出对自己最有利的放置方法并输出。

如图的局面表示为：

00-1

-000

0100

即用“0”表示空闲位置，用“1”表示竖直放置，用“-”表示水平放置。

【输入、输出格式要求】

用户先输入整数 n（n<100）， 表示接下来将输入 n 种初始局面，每种局面占3行(多个局面间没有空白行)。

程序则输出：每种初始局面情况下计算得出的最佳放置法（行号+列号+放置方式）。

例如：用户输入：

2
0111
-000
-000
1111
----
0010

则程序可以输出：

00-

211

不难猜出，输出结果的含义为：

对第一个局面，在第0行第0列水平放置

对第二个局面，在第2行第1列垂直放置

注意：

行号、列号都是从0开始计数的。

对每种局面可能有多个最佳放置方法（解不唯一），只输出一种即可。

例如，对第一个局面，001 也是正解；对第二个局面，201也是正解。

1
1011
-000
-000

 */
package gaoXiaoBang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 第六章博弈树_火柴棒游戏的实现 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i< num; ++ i) {
			solve(changeToInt(br.readLine().trim()), 
					changeToInt(br.readLine().trim()), 
					changeToInt(br.readLine().trim()));
		}
		br.close();
	}
	
	private static void solve(int[] c1, int[] c2, int[] c3) {
		for (int i = 0; i < c1.length; ++ i) {
			if (c1[i] != 0)
				continue;
			int index1 = i, index2 = i;
			int state1 = 0, state2 = 0;
			if (i != 0) {
				while (index1>=0 && c1[index1] == 0) {
					index1 --;
				}
				state1 = c1[index1];
			}
			if (i != c1.length-1) {
				while (index2<c1.length && c1[index2] == 0) {
					index2 ++;
				}
				state2 = index2==c1.length ? 0 :c1[index2];
			}
			int state3 = 0, state4 = c2[i] != 0 ? c2[i] : (c3[i] != 0 ? c3[i] : 0);
			if (state3 == 1 || state4 == 1) {
				if (state1 == -1 || state2 == -1) {
					continue;
				} else {
					System.out.println(0+""+i+"-");
					return;
				}
			} else {
				System.out.println(0+""+i+"1");
				return;
			}
		}
		for (int i = 0; i < c2.length; ++ i) {
			if (c2[i] != 0)
				continue;
			int index1 = i, index2 = i;
			int state1 = 0, state2 = 0;
			if (i != 0) {
				while (index1>=0 && c2[index1] == 0) {
					index1 --;
				}
				state1 = c2[index1];
			}
			if (i != c2.length-1) {
				while (index2<c2.length && c2[index2] == 0) {
					index2 ++;
				}
				state2 = index2==c2.length ? 0 :c2[index2];
			}
			int state3 = c1[i], state4 = c3[i];
			if (state3 == 1 || state4 == 1) {
				if (state1 == -1 || state2 == -1) {
					continue;
				} else {
					System.out.println(1+""+i+"-");
					return;
				}
			} else {
				System.out.println(1+""+i+"1");
				return;
			}
		}
		for (int i = 0; i < c3.length; ++ i) {
			if (c3[i] != 0)
				continue;
			int index1 = i, index2 = i;
			int state1 = 0, state2 = 0;
			if (i != 0) {
				while (index1>=0 && c3[index1] == 0) {
					index1 --;
				}
				state1 = c3[index1];
			}
			if (i != c3.length-1) {
				while (index2<c3.length && c3[index2] == 0) {
					index2 ++;
				}
				state2 = index2==c3.length ? 0 :c3[index2];
			}
			int state4 = 0, state3 = c2[i] != 0 ? c2[i] : (c1[i] != 0 ? c1[i] : 0);
			if (state3 == 1 || state4 == 1) {
				if (state1 == -1 || state2 == -1) {
					continue;
				} else {
					System.out.println(2+""+i+"-");
					return;
				}
			} else {
				System.out.println(2+""+i+"1");
				return;
			}
		}
	}	
	private static int[] changeToInt(String str) {
		int[] re = new int[str.length()];
		char[] c = str.toCharArray();
		for (int i = 0; i < c.length; ++ i) {
			switch(c[i]) {
			case '0':
				re[i] = 0;
				break;
			case '1':
				re[i] = 1;
				break;
			case '-':
				re[i] = -1;
				break;
			}
		}
		return re;
	}
}
