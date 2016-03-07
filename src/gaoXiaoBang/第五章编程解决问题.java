/*
BMP是常见的图像存储格式。
如果用来存黑白图像（颜色深度=1），则其信息比较容易读取。

与之相关的数据：

（以下偏移均是从文件头开始）
偏移：10字节, 长度4字节： 图像数据真正开始的位置。
偏移：18字节, 长度4字节： 位图的宽度，单位是像素。
偏移：22字节, 长度4字节： 位图的高度，单位是像素。

从图像数据开始处，每个像素用1个二进制位表示。
从图片的底行开始，一行一行向上存储。

Windows规定图像文件中一个扫描行所占的字节数必须是4字节的倍数，
不足的位均以 0 填充。例如，图片宽度为45像素，实际上每行会占用
8个字节。

可以通过Windows自带的画图工具生成和编辑二进制图像。
需要在“属性”中选择“黑白”，指定为二值图像。
可能需要通过查看 | 缩放 | 自定义... 把图像变大比例一些，
更易于操作。

图像的左下角为图像数据的开始位置。白色对应1，黑色对应0


我们可以定义：两个点距离如果小于2个像素，则认为这两个点连通。
也就是说：以一个点为中心的九宫格中，围绕它的8个点与它都是连通的。
如：t1.bmp 所示，左下角的点组成一个连通的群体；
而右上角的点都是孤立的。

程序的目标是：根据给定的黑白位图，分析出所有独立连通的群体，输出每个连通群体的面积。
所谓面积，就是它含有的像素的个数。

输入数据固定存在in.bmp中。

如示例的in.bmp,
程序应该输出：
12
81
52
133

该输出表示：共有4个连通群体。
输出的连通体面积间的顺序可以随意。

请编程解决上述问题。

我们测试程序的时候，会使用不同的in.bmp文件。
 */

package gaoXiaoBang;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;

public class 第五章编程解决问题 {
	//64 * 64       上边 64*32 全黑，下边64*32全白  可以计算得到总共64*64=4096个数据位 即512字节。
	//白色 1    黑色 0
	//文件总共574 字节，可以知道从574-512=62位置开始计算数据(对应byte[]是62开始)
	//byte[]中，18位 放置宽度       22位 放置高度
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
					//如果程序进入这里，毫无疑问，我们将得到一个图形
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
		//这样的情况，就必定会有一个图形，也就是说Vector<Integer> ans就必须加入一个数据
		//这个函数的作用就是：	通过遍历所有可能的情况，将这次的图形中的像素数算出，
		//					并将算出的像素设置isCounted = true，今后的遍历中就不会再访问该点。
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
		//返回一个像素点的周边8个点。由于有边界，返回的ArrayList可能少于8个
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
		//返回的值是0 或者 1
		//表示的是：在像素点(loc1, loc2)是0还是1
		return ( ( img[loc1][loc2>>3] >>  ( 7 - (loc2 & 0x7) ) ) ) & 0x1 ;
	}

	private static int getByteLength(int len) {
		//返回第二次打开文件时候的byte[] buff 的大小
		int depth = (len & 0x31) == 0 ? (len >> 5) : ((len >> 5) + 1);
		return depth << 2;
	}
	
	private static int fourToOne(int[] data) {
		//传入的只会是四个由byte（强制无类型即0-255）转换过来的int数组
		//下标越高，位数越高，进制是256
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
