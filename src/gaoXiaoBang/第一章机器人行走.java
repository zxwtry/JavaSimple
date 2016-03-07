package gaoXiaoBang;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*




某少年宫引进了一批机器人小车。可以接受预先输入的指令，按指令行动。小车的基本动作很简单，只有3种：左转（记为L），右转（记为R），向前走若干厘米（直接记数字）。

例如，我们可以对小车输入如下的指令：

15L10R5LRR10R20

则，小车先直行15厘米，左转，再走10厘米，再右转，...

不难看出，对于此指令串，小车又回到了出发地。

你的任务是：编写程序，由用户输入指令，程序输出每条指令执行后小车位置与指令执行前小车位置的直线距离。

【输入、输出格式要求】

用户先输入一个整数n（n<100），表示接下来将有n条指令。

接下来输入n条指令。每条指令只由L、R和数字组成（数字是0~100之间的整数）

每条指令的长度不超过256个字符。

程序则输出n行结果。

每条结果表示小车执行相应的指令前后位置的直线距离。要求四舍五入到小数后2位。

例如：用户输入：
5
L100R50R10
3LLL5RR4L12
LL
100R
5L5L5L5

则程序输出：
102.96
9.06
0.00
100.00
0.00



 */



public class 第一章机器人行走 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numOfTest = Integer.parseInt(br.readLine().trim());
		while (numOfTest-- > 0) {
			char[] robotRoute = br.readLine().trim().toCharArray();
			System.out.printf("%.2f\n",getLengthFromBeginToEnd(robotRoute));
		}
	}

	private static double getLengthFromBeginToEnd(char[] robotRoute) {
		int theLengthTemp = 0;
		Location locationNow = new Location(0, 0);
		Location directionNow = new Location(1, 0);
		for (int i = 0; i < robotRoute.length; ++ i) {
			switch (robotRoute[i]) {
			case 'L':
				locationNow.abscissa += theLengthTemp*directionNow.abscissa;
				locationNow.ordinate += theLengthTemp*directionNow.ordinate;
				theLengthTemp = 0;
				if (directionNow.ordinate == 0) {
					if (directionNow.abscissa > 0) {
						directionNow.abscissa = 0;
						directionNow.ordinate = 1;
					} else {
						directionNow.abscissa = 0;
						directionNow.ordinate = -1;
					}
				} else {
					if (directionNow.ordinate > 0) {
						directionNow.abscissa = -1;
						directionNow.ordinate = 0;
					} else {
						directionNow.abscissa = 1;
						directionNow.ordinate = 0;
					}
				}
				break;
			case 'R':
				locationNow.abscissa += theLengthTemp*directionNow.abscissa;
				locationNow.ordinate += theLengthTemp*directionNow.ordinate;
				theLengthTemp = 0;
				if (directionNow.ordinate == 0) {
					if (directionNow.abscissa > 0) {
						directionNow.abscissa = 0;
						directionNow.ordinate = -1;
					} else {
						directionNow.abscissa = 0;
						directionNow.ordinate = 1;
					}
				} else {
					if (directionNow.ordinate > 0) {
						directionNow.abscissa = 1;
						directionNow.ordinate = 0;
					} else {
						directionNow.abscissa = -1;
						directionNow.ordinate = 0;
					}
				}
				break;
			default:
				theLengthTemp = theLengthTemp*10 + robotRoute[i] - '0';
				break;
			}
			if (i == robotRoute.length-1) {
				locationNow.abscissa += theLengthTemp*directionNow.abscissa;
				locationNow.ordinate += theLengthTemp*directionNow.ordinate;
			}
		}
		double re = Math.sqrt(locationNow.abscissa*locationNow.abscissa
				+ locationNow.ordinate*locationNow.ordinate);
		return re;
	}
	static class Location {
		int abscissa; //横坐标
		int ordinate; //纵坐标
		public Location () {}
		public Location (int abscissa, int ordinate) {
			this.abscissa = abscissa;
			this.ordinate = ordinate;
		}
	}
}
