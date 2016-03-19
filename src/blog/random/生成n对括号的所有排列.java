package blog.random;

import java.util.LinkedList;
import java.util.ListIterator;

/*

生成n对括号的所有合法排列

实例

n = 3，所有的合法序列

((()))  (()()) (())() ()(()) ()()()     

思路

针对一个长度为2n的合法排列，第1到2n个位置都满足如下规则

1
左括号的个数≥右括号的个数
所以，我们就可以按照这个规则去打印括号

假设在位置k我们还剩余left个左括号和right个右括号

如果left和right均为零，则说明我们已经完成一个合法排列，可以将其打印出来
如果left>0，打印左括号
如果right>0 并且 right>left 打印右括号

 */
public class 生成n对括号的所有排列 {
	public static void main(String[] args) {
		ListIterator<String> it = generateAllMatching(3).listIterator();
		while (it.hasNext())
			System.out.println(it.next());
	}
	static LinkedList<String> generateAllMatching (int n) {
		LinkedList<String> result = new LinkedList<String>();
		generateAllMatching (n, n, "", result);
		return result;
	}
	static void generateAllMatching (int leftNum, int rightNum, String s, LinkedList<String> result) {
		if (leftNum == 0 && rightNum == 0)
			result.add(s);
		if (leftNum > 0)
			generateAllMatching (leftNum-1, rightNum, s + '(', result);
		if (rightNum > 0 && leftNum < rightNum)
			generateAllMatching (leftNum, rightNum-1, s + ')', result);
	}
}
