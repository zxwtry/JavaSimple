package dataStructures;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;

/*

�ο����ͣ�http://www.cnblogs.com/huangxincheng/archive/2012/12/02/2798317.html


 */
public class ��AC�Զ��� {
	
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
		
		// ʵ����һ��Trie���ڵ�
		public TrieNode trieNode = new TrieNode ();
		
		// �ù��ѵķ���������ʧ��ָ��
		public Queue<TrieNode> queue = new ArrayDeque<TrieNode> ();
		
        // Trie���ڵ�	TrieNode
		static class TrieNode {
			
			// 26���ַ���Ҳ����26����
			public TrieNode[] childNodes;
			
			// ��Ƶͳ��
			public int frequence;
			
			// ��¼�ýڵ���ַ�
			public char nodeChar;
			
			// ʧ��ָ��
			public TrieNode faliNode;
			
			// �����¼ʱ�ı��id
			public HashSet<Integer> hashSet = new HashSet<Integer>();
			
			// ��ʼ��
			public TrieNode () {
				childNodes = new TrieNode[26];
				frequence = 0;
			}

		// End Of ( static class TrieNode )		
		}
		
		// �������
		public void addTrieNode (String word, int id) {
			
			//
			addTrieNode(trieNode, word, id);
			
		// End Of ( public void addTrieNode (String word, int id) )
		}
		
		// �������
		public void addTrieNode (TrieNode trieNode, String word, int id) {
			
			//
			if (word == null || word.length() == 0)
				return;
			
			// ���ַ���ַ�����㽫���ַ����뵽26��������һ����
			int k = word.charAt(0) - 'a';
			
			// ����ò���Ϊ�գ����ʼ��
			if (trieNode.childNodes[k] == null) {
				
				//
				trieNode.childNodes[k] = new TrieNode();
				
				// ��¼���ַ�
				trieNode.childNodes[k].nodeChar = word.charAt(0);
				
			// End Of ( if (trieNode.childNodes[k] == null) )
			}
			
			//
			String nextWord = word.substring(1);
			
			// ˵�������һ���ַ��� ͳ�Ƹôʳ��ֵĴ���
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
		
		// ����ʧ��ָ�루�������BFS��������
		public void buildFailNodeBFS (TrieNode trieNode) {
			
			// ���ڵ����
			queue.add(trieNode);
			
			//
			while (!queue.isEmpty()) {
				
				// ����
				TrieNode temp = queue.poll();
				
				// ʧ�ܽڵ�
				TrieNode failNode = null;
				
				// 26 ����
				for (int i = 0; i < 26; i ++) {
					
					// ���뼼�ɣ� ��BFS��ʽ���ӵ�ǰ�ڵ����亢�ӽڵ㣬��ʱ���ӽڵ�
					//			�ĸ������ǵ�ǰ�ڵ㣬��������parent�ڵ�Ĵ��ڣ�
					if (temp.childNodes[i] == null)
						continue;
					
					// �����ǰ�Ǹ��ڵ㣬����ڵ��ʧ��ָ��ָ��root
					if (temp == trieNode) {
						temp.childNodes[i].faliNode = trieNode;
					} else {
						
						// ��ȡ���ӽڵ��ʧ��ָ��
						failNode = temp.faliNode;
						
						// ���������ڵ��ʧ��ָ���ߣ�һֱҪ�ҵ�һ���ڵ㣬ֱ�����Ķ���Ҳ�����ýڵ㡣
						while (failNode != null) {
							//�����Ϊ�գ����ڸ���ʧ�ܽڵ������ӽڵ������롣
                            if (failNode.childNodes[i] != null)
                            {
                                temp.childNodes[i].faliNode = failNode.childNodes[i];
                                break;
                            }
                            //����޷������ӽڵ㣬���˻ص�����ʧ�ܽڵ㲢��root�ڵ����������죬ֱ��null
                            //��һ������������Ĺ��̣��ǳ�����˼��
                            failNode = failNode.faliNode;
						}
						
						//����null�Ļ���ָ��trieNode�ڵ�
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
		
		
		// ��������
		// ����ָ���������������Ƿ����ģʽ��
		public HashSet<Integer> searchAC (String s) {
			HashSet<Integer> hash = new HashSet<Integer>();
			searchAC(trieNode, s, hash);
			return hash;
		}
		// ����ָ���������������Ƿ����ģʽ��
		public void searchAC (TrieNode root , String s , HashSet<Integer> hashSet) {
			TrieNode head = root;
			char[] c = s.toCharArray();
			for (int i = 0; i < c.length; i ++) {
				// ����λ��
				int index = c[i] - 'a';
				// �����ǰƥ����ַ���trie�������ӽڵ㲢�Ҳ���root����Ҫ��ʧ��ָ��
                // ���ݵ�ȥ�����ĵ�ǰ�ڵ���ӽڵ�
				while ((head.childNodes[index] == null) && (head != root)) {
					head = head.faliNode;
				}
				//��ȡ�ò���
                head = head.childNodes[index];
              //���Ϊ�գ�ֱ�Ӹ�root,��ʾ���ַ��Ѿ��������
                if (head == null)
                    head = root;
                TrieNode temp = head;
                
                // ��trie����ƥ�䵽���ַ�����ǵ�ǰ�ڵ�Ϊ�ѷ��ʣ�������Ѱ�Ҹýڵ��ʧ�ܽڵ㡣
                // ֱ��root�������൱������һ��������(ע�⣺������ǻ����һ��freq=-1��ʧ��ָ����)
                while (temp != root && temp.frequence != -1) {
                	//���ҵ���id׷�ӵ�������
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
