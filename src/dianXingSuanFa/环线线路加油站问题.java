package dianXingSuanFa;

/*


问题：某环线上若干加油站，已知各站油量及各站间耗油量，求汽车从某一站出发能够绕一圈。

最容易想到的方法是先从第0个位置开始试探，看是否能绕一圈。否则从下一个位置接着试探。
复杂度为O(n^2)。设A[i]为加油站油量，B[i]为第i站到第i+1站所要耗费的油量。算法分步骤如下：

1.令C[i] = A[i] – B[i] 表示从i到i+1所获得的“净“油量。
2.计算SUM（C[0:N-1])，若存在解，继续；否则返回。
3.令i=0。
4.令j=i。
5.计算sum(C[i:j])。
6.若sum（C[i:j])小于0，i加1，转4；
7.若j小于N-1，j加1，转5；否则返回i，算法结束。

上面 第6步“i加1”为试探失败时，从下一个位置接着试探。这里面可以做优化。因为试探失败意味着：
1.sum(C[i:j])<0
2.sum[C[i:k])>=0 i<=k<=j-1。
因为sum(C[i:j])=sum(C[i:k])+sum(C[k+1:j])。所以sum(C[k+1:j])<0， i<=k<=j-1。
因此从i+1到j都无需试探，接下来试探的位置可以直接是j+1。最终算法的复杂度为O(n)。


 */



public class 环线线路加油站问题 {
	public static void main(String[] args) {
		int[] oilMassOfPort    = {200, 200, 200, 200, 200, 200};
//		int[] oilConsumeStartI = {201};
//		int[] oilConsumeStartI = null;
//		int[] oilConsumeStartI = {201, 201, 201, 201, 201, 195};
		int[] oilConsumeStartI = {200, 200, 203, 200, 200, 197};
		System.out.println(findThePort(oilMassOfPort, oilConsumeStartI));
	}
	
	//这是找到一个可以完成找到开始加油站的方法
	private static int findThePort (int[] oilMassOfPort, int[] oilConsumeStartI) {
		//返回-1表示输入数据为空，或者两个数据不是同长度
		if (oilMassOfPort == null || oilConsumeStartI == null || 
				oilMassOfPort.length != oilConsumeStartI.length)	return -1;
		
		//返回-2表示全部的油储量达不到要求
		int[] massMinusConsume = new int[oilMassOfPort.length];
		int massMinusConsumeSum = 0;
		for (int i = oilMassOfPort.length-1; i >= 0; -- i) {
			massMinusConsume[i] = oilMassOfPort[i] - oilConsumeStartI[i];
			massMinusConsumeSum += massMinusConsume[i];
		}
		if (massMinusConsumeSum < 0)   return -2;
		
		//开始计算
		for (int selectStartPort = 0; selectStartPort < oilMassOfPort.length; ++ selectStartPort) {
			int selectMassMinusConsumeSum = 0;
			for (int nowPortPre = selectStartPort; nowPortPre < selectStartPort+oilMassOfPort.length; ++ nowPortPre) {
				int nowPort = getNowPort(oilMassOfPort.length, nowPortPre);
				selectMassMinusConsumeSum += massMinusConsume[nowPort];
				if (selectMassMinusConsumeSum < 0) {
					selectStartPort = nowPort;
					break;
				}
				if (nowPortPre == selectStartPort+oilMassOfPort.length-1)
					return selectStartPort;
			}
		}
		
		
		//最总计算得到的结果是：没有结果；则返回-3
		return -3;
	}
	
	//这是求findThePort方法中，nowPort的计算方法
	private static int getNowPort(int oilMassOfPortLength, int nowPortPre) {
		return nowPortPre >= oilMassOfPortLength ? nowPortPre-oilMassOfPortLength : nowPortPre;
	}
}
