/*
������ȱ����ĵݹ������Ժ����ԡ�

������ȱ��������õݹ�Ľⷨ���԰ѿγ��нⷨ����Ϊ�ݹ鷽ʽ
 */

package gaoXiaoBang;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class �����¹�����ȱ���_����Ϊ�ݹ鷽ʽ {
	/*
	 * ����ѭ���ĵط��У�
	 * 1����ArrayList��������ʹ��
	 * 2��
	 * 
	 */
	public static void main(String[] args) {
		int[][] a = {
				{0,1,1,0,0,0,0},
				{1,0,0,1,0,0,1},
				{1,0,0,0,0,1,1},
				{0,1,0,0,1,0,0},
				{0,0,0,1,0,1,1},
				{0,0,1,0,1,0,0},
				{0,1,1,0,1,0,0}
			};
		Set<Integer> tag = new HashSet<Integer>();
		ArrayList<Integer> layer = new ArrayList<Integer>();
		layer.add(0);
		bfs(a, tag, layer);
		
		
	}
	private static void bfs(int[][]a, Set<Integer> tag, ArrayList<Integer> currentLayer) {
//		int temp;
		
		//current layer
		//�Ե�����1��ѭ���Ĵ���
//		Iterator<Integer> it = currentLayer.iterator(); 
//		while(it.hasNext()) {
//			temp = it.next();
//			System.out.print(temp+" ");
//			tag.add(temp);
//		}
		iterator1(currentLayer, 0, tag);
		//�Ե�����1��ѭ���Ĵ���   ��ɣ�����һ��
		
		//next layer
		//�Ե�����2��ѭ���Ĵ���
//		it = currentLayer.iterator();
//		ArrayList<Integer> arrayListNextLayer = new ArrayList<Integer>();
//		while (it.hasNext()) {
//			temp = it.next();
//			for (int j = 0; j < a[temp].length; ++ j) {
//				if (a[temp][j] == 1 && arrayListNextLayer.indexOf(j) < 0)
//					arrayListNextLayer.add(j);
//			}
//		}
		ArrayList<Integer> arrayListNextLayer = new ArrayList<Integer>();
		iterator2(currentLayer, 0, arrayListNextLayer, a);
		//�Ե�����2��ѭ���Ĵ���   ��ɣ�����һ��
		
		arrayListNextLayer.removeAll(tag);
		if(!arrayListNextLayer.isEmpty())
			bfs(a, tag, arrayListNextLayer);
	}
	
	private static void iterator1(ArrayList<Integer> currentLayer, 
			int clIndex, Set<Integer> tag) {
		if (clIndex >= currentLayer.size())    return;
		tag.add(currentLayer.get(clIndex));
		System.out.print(currentLayer.get(clIndex) + " ");
		iterator1(currentLayer, ++ clIndex, tag);
	}
	private static void iterator2(ArrayList<Integer> currentLayer,
			int clIndex, ArrayList<Integer> arrayListNextLayer, int[][] a) {
		if (clIndex >= currentLayer.size())    return;
		for1(a, 0, currentLayer.get(clIndex), arrayListNextLayer);
		iterator2(currentLayer, ++ clIndex, arrayListNextLayer, a);
	}
	private static void for1(int[][] a, int fIndex, int tempIndex,
			ArrayList<Integer> arrayListNextLayer) {
		if (fIndex >= a[tempIndex].length)   return;
		if (a[tempIndex][fIndex] == 1 && arrayListNextLayer.indexOf(fIndex) < 0)
			arrayListNextLayer.add(fIndex);
		for1(a, ++ fIndex, tempIndex, arrayListNextLayer);
	}
	
//	@Test
//	public void test () {
//		ArrayList<Integer> arrayList = new ArrayList<Integer>();
//		arrayList.add(0);  arrayList.add(1);
//		arrayList.add(2);  arrayList.add(3);
//		arrayList.add(4);  arrayList.add(5);
//		Iterator<Integer> it = arrayList.iterator();
//		while(it.hasNext()) {
//			System.out.print(it.next()+" ");
//		}
//		System.out.println();
//		it = arrayList.iterator();
//		while(it.hasNext()) {
//			System.out.print(it.next()+" ");
//		}
//		System.out.println();
//	} 
}
