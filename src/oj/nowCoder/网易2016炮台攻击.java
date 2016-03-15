package oj.nowCoder;

import java.util.Scanner;

/*
兰博教训提莫之后,然后和提莫讨论起约德尔人,
谈起约德尔人,自然少不了一个人,那 就是黑默丁格------
约德尔人历史上最伟大的科学家. 提莫说,黑默丁格最近在思考一个问题:
黑默丁格有三个炮台,炮台能攻击到距离它R的敌人 (两点之间的距离为两点连续的距离,例如(3,0),(0,4)之间的距离是5),
如果一个炮台能攻击 到敌人,那么就会对敌人造成1×的伤害.黑默丁格将三个炮台放在N*M方格中的点上,并且给出敌人 的坐标. 
问:那么敌人受到伤害会是多大?

输入描述:
第一行9个整数,R,x1,y1,x2,y2,x3,y3,x0,y0.R代表炮台攻击的最大距离,(x1,y1),(x2,y2),
(x3,y3)代表三个炮台的坐标.(x0,y0)代表敌人的坐标.


输出描述:
输出一行,这一行代表敌人承受的最大伤害,(如果每个炮台都不能攻击到敌人,输出0×)

输入例子:
1 1 1 2 2 3 3 1 2

输出例子:
2x
 */
public class 网易2016炮台攻击 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int r;P p1, p2, p3, p0;
		while (sc.hasNext()) {
			r = sc.nextInt();
			p1 = new P(sc.nextInt(), sc.nextInt());
			p2 = new P(sc.nextInt(), sc.nextInt());
			p3 = new P(sc.nextInt(), sc.nextInt());
			p0 = new P(sc.nextInt(), sc.nextInt());
			int times = 0; double dis ;
			dis = getDis(p1, p0);
			if (dis < r)  times ++;
//			else if ((dis - (int)dis) < 0.0000001 )
//				times ++;
			dis = getDis(p2, p0);
			if (dis < r)  times ++;
//			else if ((dis - (int)dis) < 0.0000001)
//				times ++;
			dis = getDis(p3, p0);
			if (dis < r)  times ++;
//			else if ((dis - (int)dis) < 0.0000001)
//				times ++;
			System.out.printf("%dx\n",times);
		}
		sc.close();
	}
	static class P {
		int x,y;
		public P(){}
		public P(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	private static double getDis (P p1, P p2) {
		return Math.sqrt( (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y) );
	}
}
