/*
BMP�ǳ�����ͼ��洢��ʽ��
���������ڰ�ͼ����ɫ���=1����������Ϣ�Ƚ����׶�ȡ��

��֮��ص����ݣ�

������ƫ�ƾ��Ǵ��ļ�ͷ��ʼ��
ƫ�ƣ�10�ֽ�, ����4�ֽڣ� ͼ������������ʼ��λ�á�
ƫ�ƣ�18�ֽ�, ����4�ֽڣ� λͼ�Ŀ�ȣ���λ�����ء�
ƫ�ƣ�22�ֽ�, ����4�ֽڣ� λͼ�ĸ߶ȣ���λ�����ء�

��ͼ�����ݿ�ʼ����ÿ��������1��������λ��ʾ��
��ͼƬ�ĵ��п�ʼ��һ��һ�����ϴ洢��

Windows�涨ͼ���ļ���һ��ɨ������ռ���ֽ���������4�ֽڵı�����
�����λ���� 0 ��䡣���磬ͼƬ���Ϊ45���أ�ʵ����ÿ�л�ռ��
8���ֽڡ�

����ͨ��Windows�Դ��Ļ�ͼ�������ɺͱ༭������ͼ��
��Ҫ�ڡ����ԡ���ѡ�񡰺ڰס���ָ��Ϊ��ֵͼ��
������Ҫͨ���鿴 | ���� | �Զ���... ��ͼ�������һЩ��
�����ڲ�����

ͼ������½�Ϊͼ�����ݵĿ�ʼλ�á���ɫ��Ӧ1����ɫ��Ӧ0


���ǿ��Զ��壺������������С��2�����أ�����Ϊ����������ͨ��
Ҳ����˵����һ����Ϊ���ĵľŹ����У�Χ������8��������������ͨ�ġ�
�磺t1.bmp ��ʾ�����½ǵĵ����һ����ͨ��Ⱥ�壻
�����Ͻǵĵ㶼�ǹ����ġ�

�����Ŀ���ǣ����ݸ����ĺڰ�λͼ�����������ж�����ͨ��Ⱥ�壬���ÿ����ͨȺ��������
��ν��������������е����صĸ�����

�������ݹ̶�����in.bmp�С�

��ʾ����in.bmp,
����Ӧ�������
12
81
52
133

�������ʾ������4����ͨȺ�塣
�������ͨ��������˳��������⡣

���̽���������⡣

���ǲ��Գ����ʱ�򣬻�ʹ�ò�ͬ��in.bmp�ļ���
 */

package gaoXiaoBang;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;

public class �����±�̽������ {
	//64 * 64       �ϱ� 64*32 ȫ�ڣ��±�64*32ȫ��  ���Լ���õ��ܹ�64*64=4096������λ ��512�ֽڡ�
	//��ɫ 1    ��ɫ 0
	//�ļ��ܹ�574 �ֽڣ�����֪����574-512=62λ�ÿ�ʼ��������(��Ӧbyte[]��62��ʼ)
	//byte[]�У�18λ ���ÿ��       22λ ���ø߶�
	private static int pxCount = 0;
	public static void main(String[] args) throws IOException {
		final String[] file = {"c:\\1.bmp", "c:\\data\\123m123.bmp", "c:\\data\\200m200.bmp", "c:\\data\\255m255.bmp", "c:\\data\\256m256.bmp",
				"c:\\data\\100m200.bmp", "c:\\data\\257m257.bmp", "c:\\data\\259m259.bmp"};
		final int select = 7;
		InputStream fis = new FileInputStream(file[select]);
		byte[] tmp = new byte[62];
		fis.read(tmp);
		final int width = fourToOne(new int[]{convertByte(tmp[18]), convertByte(tmp[19]), 
				convertByte(tmp[20]), convertByte(tmp[21])});
		final int height = fourToOne(new int[]{convertByte(tmp[22]), convertByte(tmp[23]), 
				convertByte(tmp[24]), convertByte(tmp[25])});
		final int buffWidth = getByteLength(width);
		byte[][] img  = new byte[height][buffWidth];
		byte[] buff = new byte[buffWidth];
		int count = 0;
		while ( fis.read(buff) != -1 ) {
			img[count] = buff.clone();
			count ++;
		}
//		for (int i = 0; i < height; ++ i) {
//			System.out.printf("%d :   ", i);
//			for (int j = 0; j < buffWidth; ++ j) {
//				System.out.print(img[i][j]+"\t");
//			}
//			System.out.printf("\n");
//		}
		boolean[][] isCounted = new boolean[height][width];
		for (int i = 0; i < isCounted.length; ++ i) {
			Arrays.fill(isCounted[i], false);
		}
		Vector<Integer> v = getAns(img, width, isCounted);
		Iterator<Integer> it = v.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		fis.close();
//		byte[][] img2 = new byte[24][3];
//		for (int i = 0; i < 24; ++ i) {
//			for (int j = 0; j < 3; ++ j) {
//				img2[i][j] = -1;
//			}
//		}
//		img2[0][0] = 0;
//		img2[2][0] = 0;
//		pxCount = 0;
//		getTheDrawPX(img2, width, isCounted, 0, 0);
//		System.out.println(pxCount);
		
		
//		for (int i = 0; i < 24; ++ i) {
//			System.out.print(i+":"+getBitLoc(img2, 1, i) + "  ");
//		}
//		System.out.printf("\n%X",(byte)-32);
		
		
//		ArrayList<Pot> re = getAround(6, 7, 5, 3);
//		Iterator<Pot> itPot = re.iterator();
//		while (itPot.hasNext()) {
//			Pot p = itPot.next();
//			System.out.println(p.loc1+" "+p.loc2);
//		}
		
		
		
	}
	
	
	
	private static Vector<Integer> getAns(byte[][] img, int width, boolean[][] isCounted) {
		Vector<Integer> ans = new Vector<Integer>();
		for (int loc1 = 0; loc1 < img.length; ++ loc1) {
			for (int loc2 = 0; loc2 < width; ++ loc2) {
				if( getBitLoc(img, loc1, loc2) == 0  &&  !isCounted[loc1][loc2]) {
					//��������������������ʣ����ǽ��õ�һ��ͼ��
					pxCount = 0;
					getTheDrawPX(img, width, isCounted, loc1, loc2);
					ans.add(pxCount);
					pxCount = 0;
				}
			}
		}
		return ans;
	}
	
	private static void getTheDrawPX(byte[][] img, int width, boolean[][] isCounted, int loc1, int loc2) {
		//������������ͱض�����һ��ͼ�Σ�Ҳ����˵Vector<Integer> ans�ͱ������һ������
		//������������þ��ǣ�	ͨ���������п��ܵ����������ε�ͼ���е������������
		//					�����������������isCounted = true�����ı����оͲ����ٷ��ʸõ㡣
		if ( !isCounted[loc1][loc2] && getBitLoc(img, loc1, loc2) == 0) {
			isCounted[loc1][loc2] = true;
			pxCount ++;
		}
		ArrayList<Pot> re = getAround(img.length, width, loc1, loc2);
		Iterator<Pot> it = re.iterator();
		boolean isAllNotSuit = false;
		while (it.hasNext()) {
			Pot tmp = it.next();
			boolean boTemp = !isCounted[tmp.loc1][tmp.loc2] && getBitLoc(img, tmp.loc1, tmp.loc2) == 0;
			isAllNotSuit |= boTemp;
			if (!boTemp) {
				it.remove();
			}
		}
		if (!isAllNotSuit) {
			return;
		} else {
			it = re.iterator();
			while (it.hasNext()) {
				Pot tmp = it.next();
				getTheDrawPX(img, width, isCounted, tmp.loc1, tmp.loc2);
			}
		}
	}
	
	private static ArrayList<Pot> getAround(int imgLength, int width, int loc1, int loc2) {
		//����һ�����ص���ܱ�8���㡣�����б߽磬���ص�ArrayList��������8��
		ArrayList<Pot> re = new ArrayList<Pot>();
		if (loc1 == 0) {
			if (loc2 == 0) {
				re.add(new Pot(0, 1));
				re.add(new Pot(1, 0));
				re.add(new Pot(1, 1));
			} else if (loc2 == width-1) {
				re.add(new Pot(0, width-2));
				re.add(new Pot(1, width-1));
				re.add(new Pot(1, width-2));
			} else {
				re.add(new Pot(loc1, loc2-1));
				re.add(new Pot(loc1, loc2+1));
				re.add(new Pot(loc1+1, loc2-1));
				re.add(new Pot(loc1+1, loc2));
				re.add(new Pot(loc1+1, loc2+1));
			}
		} else if (loc1 == imgLength-1) {
			if (loc2 == 0) {
				re.add(new Pot(loc1, 1));
				re.add(new Pot(loc1-1, 0));
				re.add(new Pot(loc1-1, 1));
			} else if (loc2 == width-1) {
				re.add(new Pot(loc1, width-2));
				re.add(new Pot(loc1-1, width-1));
				re.add(new Pot(loc1-1, width-2));
			} else {
				re.add(new Pot(loc1, loc2-1));
				re.add(new Pot(loc1, loc2+1));
				re.add(new Pot(loc1-1, loc2-1));
				re.add(new Pot(loc1-1, loc2));
				re.add(new Pot(loc1-1, loc2+1));
			}
		} else {
			if (loc2 == 0) {
				re.add(new Pot(loc1-1, loc2));
				re.add(new Pot(loc1+1, loc2));
				re.add(new Pot(loc1-1, loc2+1));
				re.add(new Pot(loc1, loc2+1));
				re.add(new Pot(loc1+1, loc2+1));
			} else if (loc2 == width-1) {
				re.add(new Pot(loc1-1, loc2));
				re.add(new Pot(loc1+1, loc2));
				re.add(new Pot(loc1-1, loc2-1));
				re.add(new Pot(loc1, loc2-1));
				re.add(new Pot(loc1+1, loc2-1));
			} else {
				re.add(new Pot(loc1-1,loc2-1));
				re.add(new Pot(loc1-1,loc2));
				re.add(new Pot(loc1-1,loc2+1));
				re.add(new Pot(loc1,loc2-1));
				re.add(new Pot(loc1,loc2+1));
				re.add(new Pot(loc1+1,loc2-1));
				re.add(new Pot(loc1+1,loc2));
				re.add(new Pot(loc1+1,loc2+1));
			}
		}
		return re;
	}
	
	static class Pot {
		int loc1,loc2;
		public Pot() {
		}
		public Pot(int loc1, int loc2) {
			this.loc1 = loc1;
			this.loc2 = loc2;
		}
	}
	
	private static int getBitLoc(byte[][]img, int loc1, int loc2) {
		//���ص�ֵ��0 ���� 1
		//��ʾ���ǣ������ص�(loc1, loc2)��0����1
		return ( ( img[loc1][loc2>>3] >>  ( 7 - (loc2 & 0x7) ) ) ) & 0x1 ;
	}

	private static int getByteLength(int len) {
		//���صڶ��δ��ļ�ʱ���byte[] buff �Ĵ�С
		int depth = (len & 0x31) == 0 ? (len >> 5) : ((len >> 5) + 1);
		return depth << 2;
	}
	
	private static int fourToOne(int[] data) {
		//�����ֻ�����ĸ���byte��ǿ�������ͼ�0-255��ת��������int����
		//�±�Խ�ߣ�λ��Խ�ߣ�������256
		int re = 0;
		for (int i = data.length-1; i >= 0; i --) {
			re = ( re << 8 ) + data[i];
		}
		return re;
	}
	
	private static int convertByte(byte b) {
		if (b < 0)
			return 256+b;
		else 
			return b;
	}
}
