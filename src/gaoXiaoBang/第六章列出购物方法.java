/*
公司发了某商店的购物券1000元，
限定只能购买店中的m种商品。
每种商品的价格分别为m1,m2,…，
要求程序列出所有的正好能消费完该购物券的不同购物方法。
程序输入：
第一行是一个整数m，代表可购买的商品的种类数。
接下来是m个整数，每个1行，分别代表这m种商品的单价。
程序输出：
第一行是一个整数，表示共有多少种方案
第二行开始，每种方案占1行，表示对每种商品购买的数量，中间用空格分隔。
例如：
输入：
2
200
300
则应输出：
2
2 2
5 0
输入：
2
500
800
则应输出：
1
2 0
 */

package gaoXiaoBang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class 第六章列出购物方法 {
	private static final int MONEY = 1000;
	private static int minPrice = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine().trim());
		int[] price = new int[num];
		int[] count = new int[num];
		Arrays.fill(count, 0);
		for (int i = 0; i < num; ++ i) {
			price[i] = Integer.parseInt(br.readLine().trim());
			if(minPrice > price[i]) {
				minPrice = price[i];
			}
		}
		ArrayList<int[]> list = new ArrayList<int[]>();
		
		search(price, list, MONEY, count);
		System.out.println(list.size());
		Iterator<int[]> it = list.iterator();
		while(it.hasNext()) {
			int[] temp = it.next();
			for (int i = 0; i < temp.length - 1; ++ i) {
				System.out.print(temp[i] + " ");
			}
			System.out.println(temp[temp.length-1]);
		}
		br.close();
	}
	private static void search(int[] price, ArrayList<int[]> list, int money, int[] count) {
		if (money == 0) {
			Iterator<int[]> it = list.iterator();
			boolean isFound = false;
			while(it.hasNext()) {
				int temp [] = it.next();
				boolean isTheSame = true;
				for (int i = 0; i < temp.length; ++ i) {
					isTheSame = isTheSame && (count[i] == temp[i]);
				}
				if (isTheSame) {
					isFound = true;
					break;
				}
			}
			if (!isFound) {
				int[] m = new int[count.length];
				for (int i = 0; i < count.length; ++ i) {
					m[i] = count[i];
				}
				list.add(m);
			}
			return;
		} else if (money < minPrice) {
			return;
		}
		for (int i = 0; i < count.length; i ++) {
			money -= price[i];
			count[i] ++;
				search(price, list, money, count);
			count[i] --;
			money += price[i];
		}
	}
	
//	@Test
//	public void test() {
//		ArrayList<int[]> list = new ArrayList<int[]>();
//		list.add(new int[]{1,2,3});
//		list.add(new int[]{1,2,3,4});
//		list.add(new int[]{1,2,3,5});
//		list.add(new int[]{1,2,3,6});
//		Iterator<int[]> it = list.iterator();
//		while(it.hasNext()) {
//			int[] temp = it.next();
//			for (int i = 0; i < temp.length - 1; ++ i) {
//				System.out.print(temp[i] + " ");
//			}
//			System.out.println(temp[temp.length-1]);
//		}
//	}

}
