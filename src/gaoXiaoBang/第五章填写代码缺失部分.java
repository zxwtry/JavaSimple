/*
树形结构应用十分广泛。

下面这段代码根据用户添加的数据，在内存中构建一个逻辑上等价的树形结构。

通过ShowTree() 可以把它显示为控制中的样子。

其中：
a.add('a', 'b');
a.add('b', 'e');
表示：'b' 作为 'a' 的孩子节点；'e' 作为 'b'的孩子节点。
如代码中给出的示例数据，输出结果应该为：

a--b--e
|  |--f--j
|    |--k
|--c
|--d--g--h
  |--i



请阅读下面的代码，填写缺失的部分（下划线部分）。

注意：请把填空的答案（仅填空处的答案，不包括题面）存入考生文件夹下对应题号的“解答.txt”中即可。
直接写在题面中不能得分。

 

import java.util.*;

class MyTree
{
            private Map map = new HashMap();
            public void add(char parent, char child)
            {
                       List t = (List)map.get(parent);
                       if(t==null)
                       {
                                  t = new Vector();
                                  ____________________; // 填空1
                        }
                        t.add(child);
            }
            public List getChild(char x)
            {
                       return (List)map.get(x);
            }
}

public class My
{
            public static List showTree(MyTree tree, char x)
            {
                       List t = tree.getChild(x);
                       List r = new Vector();
                       if(t==null)
                        {
                                   r.add("" + x);
                                   return r;
                         }
                         for(int i=0; i<t.size(); i++)
                         {
                                   List ri = showTree(tree, t.get(i));
                                   for(int j=0; j<ri.size(); j++)
                                   {
                                             String pre = "| ";
                                             if(j==0)
                                             {
                                                       if(i==0)
                                                                    pre = x + "--";
                                                       else 
                                                                    pre = "|--";
                                             }
                                            else
                                             {
                                                       if(i==__________________) // 填空2
                                                       pre = " ";
                                                       else
                                                       pre = "| ";
                                             }
                                             r.add(pre + ri.get(j));
                            }
                }
               return r;
}
public static void main(String[] args)
{
               MyTree a = new MyTree();
               a.add('a', 'b');
               a.add('b', 'e');
               a.add('b', 'f');
               a.add('a', 'c');
               a.add('a', 'd');
               a.add('d', 'g');
               a.add('d', 'i');
               a.add('g', 'h');
               a.add('f', 'j');
               a.add('f', 'k');
               List lst = showTree(a, 'a');
               for(int i=0; i<lst.size(); i++)
               {
                            System.out.println(lst.get(i));
               }
       }
}
 */

package gaoXiaoBang;
import java.util.*;

class MyTree
{
            private Map<Character, List<Character>> map 
            = new HashMap<Character, List<Character>>();
            public void add(char parent, char child)
            {
                       List<Character> t = map.get(parent);
                       if(t==null)
                       {
                                  t = new Vector<Character>();
                                  
                                  map.put(parent, t); // 填空1
                        }
                        t.add(child);
            }
            public List<Character> getChild(char x)
            {
                       return map.get(x);
            }
}

class My
{
            public static List<String> showTree(MyTree tree, char x)
            {
                       List<Character> t = tree.getChild(x);
                       List<String> r = new Vector<String>();
                       if(t==null)
                        {
                                   r.add("" + x);
                                   return r;
                         }
                         for(int i=0; i<t.size(); i++)
                         {
                                   List<String> ri = showTree(tree, t.get(i));
                                   for(int j=0; j<ri.size(); j++)
                                   {
                                             String pre = "| ";
                                             if(j==0)
                                             {
                                                       if(i==0)
                                                                    pre = x + "--";
                                                       else 
                                                                    pre = "|--";
                                             }
                                            else
                                             {
                                                       if(i==t.size()-1) // 填空2
                                                       pre = " ";
                                                       else
                                                       pre = "| ";
                                             }
                                             r.add(pre + ri.get(j));
                            }
                }
               return r;
            }
}
public class 第五章填写代码缺失部分 {
	public static void main(String[] args) {
	    MyTree a = new MyTree();
	    
	    a.add('a', 'b');
	    a.add('b', 'e');
	    a.add('b', 'f');
	    a.add('a', 'c');
	    a.add('a', 'd');
	    a.add('d', 'g');
	    a.add('d', 'i');
	    a.add('g', 'h');
	    a.add('f', 'j');
	    a.add('f', 'k');
	    
	    List<String> lst = My.showTree(a, 'a');
	    for(int i=0; i<lst.size(); i++)
	    {
	                 System.out.println(lst.get(i));
	    }
		
	}
}