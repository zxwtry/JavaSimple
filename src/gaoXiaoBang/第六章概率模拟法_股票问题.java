/*
股票交易上的投机行为往往十分危险。假设某股票行为十分怪异，
每天不是涨停（上涨10%）就是跌停（下跌10%）。
假设上涨和下跌的概率均等（都是50%）。
再假设交易过程没有任何手续费。
某人在开始的时候持有总价值为x的该股股票，那么100个交易日后，
他盈利的可能性是多少呢？
 */


package gaoXiaoBang;

public class 第六章概率模拟法_股票问题 {
	static final int NUM = 10000;
	public static void main(String[] args) {
		double money = 1;
		int count = 0;
		for (int j = 0; j < NUM; ++ j) {
			money = 1;
			for (int i = 0; i < 100; ++ i) {
				if ((int)(Math.random()+0.5)==0) {
//					money *= 1.1;
					money *= 0.9;
				} else {
//					money *= 0.9;
					money *= 1.1;
				}
			}
			if (money > 1) {
				count ++;
			}
		}
		System.out.println((double)count/NUM);
	}
}
