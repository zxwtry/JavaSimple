package dianXingSuanFa;


/*
问题介绍：
河内塔是根据一个传说形成的一个问题：
有三根杆子A，B，C。A杆上有N个(N>1)穿孔圆盘，盘的尺寸由下到上依次变小。
要求按下列规则将所有圆盘移至C杆：提示：可将圆盘临时置于B杆，
也可将从A杆移出的圆盘重新移回A杆，但都必须尊循上述两条规则。
问：如何移？最少要移动多少次？

 */

/*

问题分析（三个盘子方式）：
	1，	char[] locationOfPlate = new char[N];
		初始化   locationOfPlate 全部设置为A
		
	2，	结束条件+结束：
		a，locationOfPlate 全部是C，并储存交换的次数
		b，如果交换的次数大于等于现在已经存储次数
	
	3，	肯定有回溯
	
	4，	如果上次交换的是locationOfPlate中的i号
		下一次绝对不能再移动i号

 */


public class 汉诺塔问题 {
	
//	private static int changedTimesSaved = Integer.MAX_VALUE;
//	private static int lastMovedPlate = -1;
	
	public static void main(String[] args) {
		hanoi360Baike(2, 'A', 'B', 'C');
	}
	
	//这是Hanoi问题360百科上面的解法
	private static void hanoi360Baike (int numOfPlate, char a, char b, char c) {
		if (numOfPlate == 1) {
			System.out.printf("Move plate %d from %c to %c\n", numOfPlate, a, c);
		} else {
			hanoi360Baike(numOfPlate-1, a, c, b);
			System.out.printf("Move plate %d from %c to %c\n", numOfPlate, a, c);
			hanoi360Baike(numOfPlate-1, b, a, c);
		}
	}
	
	
	
	//开始Hanoi
//	private static void hanoiTry (char[] locationOfPlate, int changedTimes) {
//		//结束条件
//		if (changedTimes >= changedTimesSaved)   return;
//		boolean isAllInC = true;
//		for (int i = 0; i < locationOfPlate.length; ++ i) {
//			isAllInC &= (locationOfPlate[i] == 'C');
//		}
//		if (isAllInC) {
//			changedTimesSaved = changedTimes;
//			return;
//		}
//		
//		//求出可以进行交换的所有选择
//		int[] minLocationIndex = new int[3];
//		Arrays.fill(minLocationIndex, Integer.MAX_VALUE);
//		for (int i = locationOfPlate.length-1; i >= 0; -- i) {
//			switch(locationOfPlate[i]) {
//			case 'A':
//				minLocationIndex[0] = i;
//				break;
//			case 'B':
//				minLocationIndex[1] = i;
//				break;
//			default:
//				minLocationIndex[2] = i;
//				break;
//			}
//		}
//	}
	
	
//	private static int[] getMinToMaxIndex (int[] minLocationIndex) {
//		//要求不改变原minLocationIndex
//		//这个函数只是自己想去这么做，在这个问题中，完全没有必要采用这种难度
//		//minLocationIndex中的是每位的值，如果是Interger.MAX_VALUE表示不参与讨论
//		//并用minToMaxIndex的最后一位标识不参与讨论的第一位
//		int[] minToMaxIndex = new int[minLocationIndex.length+1];
//		
//	}
	
}
