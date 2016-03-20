package oj.nowCoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*


兰博教训提莫之后,然后和提莫讨论起约德尔人,谈起约德尔人,自然少不了一个人,
那 就是黑默丁格------约德尔人历史上最伟大的科学家. 
提莫说,黑默丁格最近在思考一个问题:黑默丁格有三个炮台,炮台能攻击到距离它R的敌人
 (两点之间的距离为两点连续的距离,例如(3,0),(0,4)之间的距离是5),
 如果一个炮台能攻击 到敌人,那么就会对敌人造成1×的伤害.
 黑默丁格将三个炮台放在N*M方格中的点上,并且给出敌人 的坐标. 问:那么敌人受到伤害会是多大?

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
public class 网易炮台 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<P> al = new ArrayList<P> ();
		
		String line = "";

		line = br.readLine().trim();
		
		String[] sp = line.split(" ");
		
		int r = Integer.parseInt(sp[0]);
		
		int index = 1;
		
		for (;index < sp.length; index += 2) {
			al.add(new P (Integer.parseInt(sp[index]), Integer.parseInt(sp[index + 1])));
		}
		
		P[] a = new P[al.size() - 1];
		for (int i = 0; i < a.length; i ++) {
			a[i] = al.get(i);
		}
		System.out.println(getAns(a, al.get(a.length), r));
		
		br.close();
	}
	static String getAns (P[] a, P my, int r) {
		int count = 0;
		for (P i : a) {
			if ( (i.x - my.x) * (i.x - my.x) + (i.y - my.y) * (i.y - my.y)  <= r*r) {
				count ++;
			}
		}
		return String.format("%dx", count);
	}
	static class P {
		int x,y;
		public P (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
