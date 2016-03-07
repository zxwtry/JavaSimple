/*
小明开了一家糖果店。他别出心裁：把水果糖包成4颗一包和7颗一包的两种。糖果不能拆包卖。

小朋友来买糖的时候，他就用这两种包装来组合。
当然有些糖果数目是无法组合出来的，比如要买 10 颗糖。

你可以用计算机测试一下，在这种包装情况下，最大不能买到的数量是17。
大于17的任何数字都可以用4和7组合出来。

本题的要求就是在已知两个包装的数量时，求最大不能组合出的数字。

输入：
两个正整数，表示每种包装中糖的颗数(都不多于1000)

要求输出：
一个正整数，表示最大不能买到的糖数

例如：
用户输入：
4 7
程序应该输出：
17

再例如：
用户输入：
3 5
程序应该输出：
7
 */

package gaoXiaoBang;

public class 第五章分酒问题_求最大不能组合出的数字 {
	public static void main(String[] args) {
		myCom my = new myCom(4,7);
		System.out.println(my.getMaxUn());
		my.set(3, 5);
		System.out.println(my.getMaxUn());
		my.set(4, 5);
		System.out.println(my.getMaxUn());
		my.set(10, 15);
		System.out.println(my.getMaxUn());
	}
	static class myCom {
		int a, b;
		boolean isFinished;
		public myCom(int a, int b) {
			this.a = a;
			this.b = b;
		}
		public void set(int a, int b) {
			this.a = a;
			this.b = b;
		}
		public int getMaxUn() {
			int i = a*b-1;
			for (; i>a && i>b; -- i) {
				isFinished = false;
				if (i%a==0 || i%b==0)    continue;
				bfs(i);
				if (!isFinished) {
					break;
				}
			}
			return i;
		}
		private void bfs(int data) {
			if (isFinished || (data<a&&data<b))    return;
			if (data==a || data==b)    isFinished = true;
			bfs(data-a);
			bfs(data-b);
		}
	}
}
