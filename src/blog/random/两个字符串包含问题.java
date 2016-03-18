package blog.random;

import java.util.Arrays;

/*


给两个char* ， A 和 B。假设A是 abcd, B是 xadbdweg, 则可以B里面是包含了A的，x“adbd”weg，顺序不管，只要包含同样多的字母就可以。
问面试官，A里面的字母会不会重复。会！
然后开始想了。知道要记录信息，但是怎么都想不到。想到的方法都是o(n^2)的。用hash，记录A里面的字母，从B开始扫，若那个字母不存在，现在不用扫，存在hash值-1。继续下一个。但是这样都是n平方啊！！
最后。迫于无奈，面试官给答案了。双指针流！！！
知道A的长度m，则从B里面截取这么长的来对比。若不合适，去除B的第一位，加上m+1位，再对比。
由于中间的m-2位情况已知，所以只要o（1）的时间。
因为一共就26个字母，所以可以用个counter，记录当前共多少个字母个数不一致。当counter为0时，就表示找到一个符合的子串。


 */
public class 两个字符串包含问题 {
	public static void main(String[] args) {
		//可以顺序不一样，先不考虑大小写问题
		String str1 = "AACD", str2="AAAADAAACAADAEEADADFF";
		System.out.println(isHas(str1.toCharArray(), str2.toCharArray()));
	}
	static int isHas (char[] shortArray, char[] longArray) {
		boolean isFound = false;
		int firstMatchBeginIndex = 0;
		final int m = shortArray.length;
		int count = 0;
		int[] mapShort = new int[26];
		int[] mapLong = new int[26];
		Arrays.fill(mapShort, 0);
		Arrays.fill(mapLong, 0);
		for (int i = 0; i < m; i ++) {
			mapShort[shortArray[i]-'A'] ++;
			mapLong[longArray[i]-'A'] ++;
		}
		for (int i = 0; i < 26; i ++) {
			count += Math.abs(mapShort[i] - mapLong[i]);
		}
		if (count == 0)
			return 0;
		for (int i = m; i < longArray.length; i ++) {
			//第一步就是将删除的弥补回来
			int indexOfToBeDeleted = longArray[i-m]-'A';
			if (mapShort[indexOfToBeDeleted] == 0) {
				count --;
			} else {
				if (mapLong[indexOfToBeDeleted] == mapShort[indexOfToBeDeleted])
					count ++;
				else if (mapLong[indexOfToBeDeleted] > mapShort[indexOfToBeDeleted])
					count --;
				else
					count ++;
			}
			mapLong[indexOfToBeDeleted] --;
			//第二步就是将要添加的添加进来
			int indexOfToBeAdded = longArray[i]-'A';
			if (mapShort[indexOfToBeAdded] == 0) {
				count ++;
			} else {
				if (mapLong[indexOfToBeAdded] == mapShort[indexOfToBeAdded])
					count ++;
				else if (mapLong[indexOfToBeAdded] > mapShort[indexOfToBeAdded])
					count ++;
				else
					count --;
			}
			mapLong[indexOfToBeDeleted] ++;
			if (count == 0) {
				isFound = true;
				firstMatchBeginIndex = i - m + 1;
				break;
			}
		} 
		if (isFound) {
			return firstMatchBeginIndex;
		} else {
			System.out.println("没有找到");
			return Integer.MAX_VALUE;
		}
	}
}
