package gaoXiaoBang;

import java.util.Stack;

/*


����
��ʽ���
xml �ļ���Ҫ���ɱ�ǩ���ɵġ�
���ƣ�
<a>
          <b>.....</b>
          <b>
                .dfsfs
          </b>
          <c .... />
          <d> kkkk </d>
       </a>
���дһ�������ܹ���������ƥ�䲻�����ı�ǩ��
���磺
<a>
          <b>sdfsfs
      </a>
��ʱ��<b> ��ǩ��ƥ����ǲ������ġ�

 */


public class �㷨18��ʽ��� {
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
