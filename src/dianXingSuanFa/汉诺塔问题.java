package dianXingSuanFa;


/*
������ܣ�
�������Ǹ���һ����˵�γɵ�һ�����⣺
����������A��B��C��A������N��(N>1)����Բ�̣��̵ĳߴ����µ������α�С��
Ҫ�����й�������Բ������C�ˣ���ʾ���ɽ�Բ����ʱ����B�ˣ�
Ҳ�ɽ���A���Ƴ���Բ�������ƻ�A�ˣ�����������ѭ������������
�ʣ�����ƣ�����Ҫ�ƶ����ٴΣ�

 */

/*

����������������ӷ�ʽ����
	1��	char[] locationOfPlate = new char[N];
		��ʼ��   locationOfPlate ȫ������ΪA
		
	2��	��������+������
		a��locationOfPlate ȫ����C�������潻���Ĵ���
		b����������Ĵ������ڵ��������Ѿ��洢����
	
	3��	�϶��л���
	
	4��	����ϴν�������locationOfPlate�е�i��
		��һ�ξ��Բ������ƶ�i��

 */


public class ��ŵ������ {
	
//	private static int changedTimesSaved = Integer.MAX_VALUE;
//	private static int lastMovedPlate = -1;
	
	public static void main(String[] args) {
		hanoi360Baike(2, 'A', 'B', 'C');
	}
	
	//����Hanoi����360�ٿ�����Ľⷨ
	private static void hanoi360Baike (int numOfPlate, char a, char b, char c) {
		if (numOfPlate == 1) {
			System.out.printf("Move plate %d from %c to %c\n", numOfPlate, a, c);
		} else {
			hanoi360Baike(numOfPlate-1, a, c, b);
			System.out.printf("Move plate %d from %c to %c\n", numOfPlate, a, c);
			hanoi360Baike(numOfPlate-1, b, a, c);
		}
	}
	
	
	
	//��ʼHanoi
//	private static void hanoiTry (char[] locationOfPlate, int changedTimes) {
//		//��������
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
//		//������Խ��н���������ѡ��
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
//		//Ҫ�󲻸ı�ԭminLocationIndex
//		//�������ֻ���Լ���ȥ��ô��������������У���ȫû�б�Ҫ���������Ѷ�
//		//minLocationIndex�е���ÿλ��ֵ�������Interger.MAX_VALUE��ʾ����������
//		//����minToMaxIndex�����һλ��ʶ���������۵ĵ�һλ
//		int[] minToMaxIndex = new int[minLocationIndex.length+1];
//		
//	}
	
}
