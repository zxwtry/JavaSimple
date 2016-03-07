/*
���νṹӦ��ʮ�ֹ㷺��

������δ�������û���ӵ����ݣ����ڴ��й���һ���߼��ϵȼ۵����νṹ��

ͨ��ShowTree() ���԰�����ʾΪ�����е����ӡ�

���У�
a.add('a', 'b');
a.add('b', 'e');
��ʾ��'b' ��Ϊ 'a' �ĺ��ӽڵ㣻'e' ��Ϊ 'b'�ĺ��ӽڵ㡣
������и�����ʾ�����ݣ�������Ӧ��Ϊ��

a--b--e
|  |--f--j
|    |--k
|--c
|--d--g--h
  |--i



���Ķ�����Ĵ��룬��дȱʧ�Ĳ��֣��»��߲��֣���

ע�⣺�����յĴ𰸣�����մ��Ĵ𰸣����������棩���뿼���ļ����¶�Ӧ��ŵġ����.txt���м��ɡ�
ֱ��д�������в��ܵ÷֡�

 

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
                                  ____________________; // ���1
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
                                                       if(i==__________________) // ���2
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
                                  
                                  map.put(parent, t); // ���1
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
                                                       if(i==t.size()-1) // ���2
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
public class ��������д����ȱʧ���� {
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