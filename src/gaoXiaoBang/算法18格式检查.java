package gaoXiaoBang;

import java.util.Stack;

/*


问题
格式检查
xml 文件主要是由标签构成的。
类似：
<a>
          <b>.....</b>
          <b>
                .dfsfs
          </b>
          <c .... />
          <d> kkkk </d>
       </a>
请编写一个程序，能够发现其中匹配不完整的标签。
例如：
<a>
          <b>sdfsfs
      </a>
此时，<b> 标签的匹配就是不完整的。

 */


public class 算法18格式检查 {
	public static void main(String[] args) {
		String str = "<a>\n<b>sdfsfs\n</b></a>";
		char[] cStr = str.toCharArray();
		Stack<String> stk = new Stack<String>();
		for (int i = 0; i < cStr.length; ++ i) {
			if (cStr[i] == '<') {
				if (cStr[i+1] != '/') {
					int j = i+1;
					for (; j < cStr.length; ++ j) {
						if (cStr[j] == '>')
							break;
					}
					stk.push(String.copyValueOf(cStr, i+1, j-i-1));
					i = j;
				} else {
					int j = i+2;
					for (; j < cStr.length; ++ j) {
						if (cStr[j] == '>')
							break;
					}
					if (String.copyValueOf(cStr, i+2, j-i-2).equals(stk.peek())) {
						stk.pop();
					}
					i = j;
				}
			}
		}
		System.out.println(stk.isEmpty());
//		System.out.println(str);
	}
}
