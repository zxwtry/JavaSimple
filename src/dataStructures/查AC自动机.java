package dataStructures;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;

/*

参考博客：http://www.cnblogs.com/huangxincheng/archive/2012/12/02/2798317.html


 */
public class 查AC自动机 {
	
	public static void main(String[] args) {
		
		TrieTree trie = new TrieTree();
		trie.addTrieNode("say", 1);
		trie.addTrieNode("she", 2);
		trie.addTrieNode("shr", 3);
		trie.addTrieNode("her", 4);
		trie.addTrieNode("he", 5);
		trie.buildFailNodeBFS();
		
		String s = "yasherhs";
		
		HashSet<Integer> hs = trie.searchAC(s);
		Iterator<Integer> it = hs.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	
	// 
	static class TrieTree {
		
		// 实例化一个Trie树节点
		public TrieNode trieNode = new TrieNode ();
		
		// 用光搜的方法来构建失败指针
		public Queue<TrieNode> queue = new ArrayDeque<TrieNode> ();
		
        // Trie树节点	TrieNode
		static class TrieNode {
			
			// 26个字符，也就是26叉树
			public TrieNode[] childNodes;
			
			// 词频统计
			public int frequence;
			
			// 记录该节点的字符
			public char nodeChar;
			
			// 失败指针
			public TrieNode faliNode;
			
			// 插入记录时的编号id
			public HashSet<Integer> hashSet = new HashSet<Integer>();
			
			// 初始化
			public TrieNode () {
				childNodes = new TrieNode[26];
				frequence = 0;
			}

		// End Of ( static class TrieNode )		
		}
		
		// 插入操作
		public void addTrieNode (String word, int id) {
			
			//
			addTrieNode(trieNode, word, id);
			
		// End Of ( public void addTrieNode (String word, int id) )
		}
		
		// 插入操作
		public void addTrieNode (TrieNode trieNode, String word, int id) {
			
			//
			if (word == null || word.length() == 0)
				return;
			
			// 求字符地址，方便将该字符放入到26叉树的哪一叉中
			int k = word.charAt(0) - 'a';
			
			// 如果该叉树为空，则初始化
			if (trieNode.childNodes[k] == null) {
				
				//
				trieNode.childNodes[k] = new TrieNode();
				
				// 记录下字符
				trieNode.childNodes[k].nodeChar = word.charAt(0);
				
			// End Of ( if (trieNode.childNodes[k] == null) )
			}
			
			//
			String nextWord = word.substring(1);
			
			// 说明是最后一个字符， 统计该词出现的次数
			if (nextWord == null || nextWord.length() == 0) {
				
				//
				trieNode.childNodes[k].frequence ++;
				
				//
				trieNode.childNodes[k].hashSet.add(id);
				
			// End Of ( if (nextWord == null || nextWord.length() == 0) )
			}
			
			//
			addTrieNode(trieNode.childNodes[k], nextWord, id);
			
		// End Of ( public void addTrieNode (TrieNode trieNode, String word, int id) )
		}
		
        public void buildFailNodeBFS() {
            buildFailNodeBFS(trieNode);
        }
		
		// 构建失败指针（这里采用BFS的做法）
		public void buildFailNodeBFS (TrieNode trieNode) {
			
			// 根节点入队
			queue.add(trieNode);
			
			//
			while (!queue.isEmpty()) {
				
				// 出队
				TrieNode temp = queue.poll();
				
				// 失败节点
				TrieNode failNode = null;
				
				// 26 叉树
				for (int i = 0; i < 26; i ++) {
					
					// 代码技巧： 用BFS方式，从当前节点找其孩子节点，此时孩子节点
					//			的父亲正是当前节点，（避免了parent节点的存在）
					if (temp.childNodes[i] == null)
						continue;
					
					// 如果当前是根节点，则根节点的失败指针指向root
					if (temp == trieNode) {
						temp.childNodes[i].faliNode = trieNode;
					} else {
						
						// 获取出队节点的失败指针
						failNode = temp.faliNode;
						
						// 沿着它父节点的失败指针走，一直要找到一个节点，直到它的儿子也包含该节点。
						while (failNode != null) {
							//如果不为空，则在父亲失败节点中往子节点中深入。
                            if (failNode.childNodes[i] != null)
                            {
                                temp.childNodes[i].faliNode = failNode.childNodes[i];
                                break;
                            }
                            //如果无法深入子节点，则退回到父亲失败节点并向root节点往根部延伸，直到null
                            //（一个回溯再深入的过程，非常有意思）
                            failNode = failNode.faliNode;
						}
						
						//等于null的话，指向trieNode节点
                        if (failNode == null)
                            temp.childNodes[i].faliNode = trieNode;
					}
					
					
					queue.add(temp.childNodes[i]);
					
				// End Of ( for (int i = 0; i < 26; i ++) )
				}
				
			// End OF ( while (!queue.isEmpty()) )
			}
			
			
			
		// End Of ( public void buildFailNodeBFS (TrieNode trieNode) )
		}
		
		
		// 检索操作
		// 根据指定的主串，检索是否存在模式串
		public HashSet<Integer> searchAC (String s) {
			HashSet<Integer> hash = new HashSet<Integer>();
			searchAC(trieNode, s, hash);
			return hash;
		}
		// 根据指定的主串，检索是否存在模式串
		public void searchAC (TrieNode root , String s , HashSet<Integer> hashSet) {
			TrieNode head = root;
			char[] c = s.toCharArray();
			for (int i = 0; i < c.length; i ++) {
				// 计算位置
				int index = c[i] - 'a';
				// 如果当前匹配的字符在trie树中无子节点并且不是root，则要走失败指针
                // 回溯的去找它的当前节点的子节点
				while ((head.childNodes[index] == null) && (head != root)) {
					head = head.faliNode;
				}
				//获取该叉树
                head = head.childNodes[index];
              //如果为空，直接给root,表示该字符已经走完毕了
                if (head == null)
                    head = root;
                TrieNode temp = head;
                
                // 在trie树中匹配到了字符，标记当前节点为已访问，并继续寻找该节点的失败节点。
                // 直到root结束，相当于走了一个回旋。(注意：最后我们会出现一个freq=-1的失败指针链)
                while (temp != root && temp.frequence != -1) {
                	//将找到的id追加到集合中
                	Iterator<Integer> it = temp.hashSet.iterator();
                	while (it.hasNext()) {
                		hashSet.add(it.next());
                	}
                	temp.frequence = -1;
                	temp = temp.faliNode;
                }
                
              
                
                
                
			}
		}
		
		
	}
}
