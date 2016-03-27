package oj.hdu;

import java.util.Scanner;

/*


吉哥还是那个吉哥
　　那个江湖人称“叽叽哥”的基哥
　　
　　每当节日来临，女友众多的叽叽哥总是能从全国各地的女友那里收到各种礼物。
　　有礼物收到当然值得高兴，但回礼确是件麻烦的事！
　　无论多麻烦，总不好意思收礼而不回礼，那也不是叽叽哥的风格。
　　
　　现在，即爱面子又抠门的叽叽哥想出了一个绝妙的好办法：
他准备将各个女友送来的礼物合理分配，再回送不同女友，这样就不用再花钱买礼物了！
　　
　　假设叽叽哥的n个女友每人送他一个礼物（每个人送的礼物都不相同），
现在他需要合理安排，再回送每个女友一份礼物，重点是，
回送的礼物不能是这个女友之前送他的那个礼物，不然，叽叽哥可就摊上事了，摊上大事了......
　　
　　现在，叽叽哥想知道总共有多少种满足条件的回送礼物方案呢？


 */
public class hdu4535吉哥系列故事之礼尚往来 {
	static final long l = 1000000007l;
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int times = -1;
//		while(in.hasNext()) {
			times = in.nextInt();
			for (int i = 0; i < times; i ++) {
				System.out.println(getAns(in.nextInt())%l);
			}
//		}
		in.close();
	}
	private static long getAns(int num) {
		if (num == 1) {
			return 0l;
		} else if (num == 2) {
			return 1l;
		} else if (num == 3) {
			return 2l;
		}
		long n2 = 2l, n1 = 9l, ans = 9l;
		for (int i = 4; i < num; i ++) {
			ans = (i) * (n2 + n1) % l;
			n2 = n1;
			n1 = ans;
		}
		return ans;
	}
}
