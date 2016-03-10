package bolg.july;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/*
������ַ��http://blog.csdn.net/v_july_v/article/details/6277490
		SPFA�㷨(Shortest Path Faster Algorithm)
	
������������Լ�������ȨͼG�����ڸ�Ȩ��·�������·��һ�����ڡ�
��Ȼ�����ǿ�����ִ�и��㷨ǰ��һ�������������ж��Ƿ���ڸ�Ȩ��·��

����������d��¼ÿ���������·������ֵ���������ڽӱ����洢ͼG��
���ǲ�ȡ�ķ����Ƕ�̬�ƽ���������һ���Ƚ��ȳ��Ķ�������������Ż��Ľ�㣬
�Ż�ʱÿ��ȡ�����׽��u��������u�㵱ǰ�����·������ֵ���뿪u����ָ��Ľ��v�����ɳڲ�����
���v������·������ֵ������������v�㲻�ڵ�ǰ�Ķ����У��ͽ�v������β��
�������ϴӶ�����ȡ������������ɳڲ�����ֱ�����п�Ϊֹ��

����: ֻҪ���·�����ڣ�����SPFA�㷨�ض��������Сֵ�� 
������ʱ�临�Ӷ�O(ke)�� ����kΪ���ж�����ӵ�ƽ������������֤��kһ��С�ڵ���2��	

����������
����n���㣬m������ߣ�ÿ���߶��г���d�ͻ���p���������s�յ�t��
Ҫ�������㵽�յ����̾��뼰�仨�ѣ������̾����ж���·�ߣ�������������ٵġ�

���룺����n,m����ı����1~n,Ȼ����m�У�ÿ��4���� a,b,d,p����ʾa��b֮����һ���ߣ�
���䳤��Ϊd������Ϊp�����һ���������� s,t;���s���յ�t��n��mΪ0ʱ���������
(1<n<=1000, 0<m<100000, s != t)
�����һ������������ ��̾��뼰�仨�ѡ�
	
*/

public class ����13ͨ������ϻ���������ѧSPFA�㷨 {

	private static final int INF = 0x3f3f3f3f;
	private static final int NUM = 205;
	
	static int n,m;
	static int[][] map = new int[NUM][NUM];
	static int[] dis = new int[NUM];
	static boolean[] vis = new boolean[NUM];
	
	private static void spfa(int s) {
		for (int i = 0; i < NUM; ++i) {
			vis[i] = false;
			dis[i] = INF;
		}
		dis[s] = 0;
		vis[s] = true;
		Comparator<Integer>	cmp = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int i = 01;
				int j = o2;
				if (dis[i] > dis[j]) {
					return 1;
				} else if (dis[i] == dis[j]) {
					return 0;
				} else {
					return -1;
				}
			}
		};
		Queue<Integer> q = new PriorityQueue<Integer>(205,cmp);
		q.clear();
		q.offer(s);
		while (!q.isEmpty()) {
			int head = q.poll();
			//��ע�������Щ������ظ���ӣ����Գ��ӵĵ�ҲҪ������δ��� 
			vis[head] = false;
			for (int i = 0; i < n; i ++) {
				//dis[head]��������INF��map[head][i]������INF
				int temp = dis[head] + map[head][i];
				if (temp < dis[i]) {
					dis[i] = temp;
					if (!vis[i]) {
						q.offer(i);
						vis[i] = true;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// ��¼ǰ���� ����path[i]=j,��ʾ��s��i�����·����i��ǰһ������j
		int u, v, w;
		while (sc.hasNext()) {
			n = sc.nextInt();
			m = sc.nextInt();
			for (int i = 0; i < NUM; i ++) {
				for (int j = 0; j < NUM; j ++) {
					map[i][j] = INF;
					map[j][i] = INF;
				}
			}
			for (int i = 0; i < m; i ++) {
				u = sc.nextInt();
				v = sc.nextInt();
				w = sc.nextInt();
				//���ر�
				if (map[u][v] > w) {
					map[u][v] = w;
					map[v][u] = w;
				}
			}
			int s = sc.nextInt();
			int t = sc.nextInt();
			spfa(s);
			//��Ŀ����st<n�����Բ����ж�dis[t]�Ƿ�Խ��
			//����յ���ͬ�Ļ�����0
			if (INF == dis[t]) {
				System.out.println(-1);
			} else {
				System.out.println(dis[t]);
			}
		}
		sc.close();
	}
	
}


/*


һ.����׼��

        Ϊ��ѧϰ����������ˮһ��spfa��

        SPFA�㷨��1994�����Ͻ�ͨ��ѧ�η��������ֻҪ���·�����ڣ�
        SPFA�㷨�ض��������Сֵ��SPFA��Bellman-Ford�㷨�Ż��Ĺؼ�֮��������ʶ����
        ֻ����Щ��ǰһ���ɳ��иı��˾������ֵ�ĵ㣬�ſ����������ǵ��ڽӵ�ľ������ֵ�ĸı䡣
        Ϊʲô����Ϊ�վͲ��ı����أ�������ΪҪ����һ����뾭������ǰһ���ڽӵ㡣��SPFA���Դ���Ȩ�ߡ�
        �ܶ�ʱ�򣬸�����ͼ���ڸ�Ȩ�ߣ���ʱ����Dijkstra���㷨��û��������֮�أ�
        ��Bellman-Ford�㷨�ĸ��Ӷ��ֹ��ߣ�SPFA�㷨�������ó��ˡ�
        ������������Լ�������ȨͼG�����ڸ�Ȩ��·��
        �����·��һ�����ڡ���Ȼ�����ǿ�����ִ�и��㷨ǰ��һ�������������ж��Ƿ���ڸ�Ȩ��·��

        ��ʼ���� dis����ȫ����ֵΪInf(����󣬲�����map[s][i]),
        path����ȫ����ֵΪs����Դ�㣩�����߸�ֵΪ-1��
        ��ʾ��û��֪��ǰ��,Ȼ��dis[s]=0;  ��ʾԴ�㲻�������·����
        ����˵���·����0����Դ����ӣ������ס�������㷨���ж��������Ҫ�ǵñ��vis���飬
        �ж�������˼ǵ������Ǹ����(���ܶ�����)��

        ���ģ���ȡ��ͷ����u��������ͷ����u���ӣ��ǵ�������ǣ���
        �����u���������е�v�����ɳڲ���������ܸ��¹���ֵ������d[v]��С����
        ��ô�͸��£����⣬�����vû���ڶ����У���ôҪ����v��ӣ��ǵñ�ǣ���
        ����Ѿ��ڶ������ˣ���ô�Ͳ�������Դ�ѭ����ֱ���ӿ�Ϊֹ������˵�Դ���·����⡣

        �ж����޸��������ĳ���������еĴ�������N������ڸ���(SPFA�޷������������ͼ)��
        ��������ڵ�������k(����Ȩ���������ڵ�����ӵı�)�������������г���k,
        ˵����Ȼ��ĳ�����ظ��ˣ����ɻ�����һ��˼·����DFS��
        ������ڸ���a1->a2->��->an->a1����ô����a1������ȥʱ��������a1��
        ��ôֱ�ӿ����жϸ����������á�
        ��ĳ���ڵ�n�ν�����У�����ڸ�������ʱʱ�临�Ӷ�ΪO(n*m),nΪ�ڵ㣬mΪ�ߡ�

        SPFA�㷨�������Ż��㷨 SLF �� LLL�� SLF��Small Label First ���ԣ�
        ��Ҫ����Ľڵ���j������Ԫ��Ϊi����dist(j)<dist(i)����j������ף���������β��
         LLL��Large Label Last ���ԣ������Ԫ��Ϊi������������distֵ��ƽ��ֵΪx��
         ��dist(i)>x��i���뵽��β��������һԪ�أ�ֱ���ҵ�ĳһiʹ��dist(i)<=x����i���Խ����ɳڲ����� 
         SLF ��ʹ�ٶ���� 15 ~ 20%��SLF + LLL �����Լ 50%�� 
         ��ʵ�ʵ�Ӧ����SPFA���㷨ʱ��Ч�ʲ��Ǻ��ȶ���Ϊ�˱��������ĳ��֣�
         ͨ��ʹ��Ч�ʸ����ȶ���Dijkstra�㷨�����˾���LLL�Ż�ÿ��Ҫ��ƽ��ֵ��
         ��̫�ã�Ϊ�˼򵥣����ǿ���֮����c++STL��������ȶ���������SLF�Ż���


��.�㷨ʵ��

        ֱ��ȥ��HDU1874AC�˰ɡ�

  1: import java.util.Comparator;
  2: import java.util.PriorityQueue;
  3: import java.util.Queue;
  4: import java.util.Scanner;
  5: /*
  6:  * ԭ��һֱwa����д��һ�飬AC��
  7:  * SLF�Ż�
  8:  
  9: public class HD1874 {
 10: 
 11:   static int n,m;
 12:   static int[][] map  = new int[205][205];
 13:   static int[] dis  = new int[205];
 14:   static boolean[] vis  = new boolean[205];
 15:   /*
 16:    * ·�����ֵ��10000���������ó�10005���У���Ҫ���Ǻ�
 17:    * Ҳ�������������ֵ������һ�Ӿ������
 18:    
 19:   static final int Inf = 0x3f3f3f3f;
 20:   
 21:   public static void main(String[] args) {
 22:     Scanner sc = new Scanner(System.in);
 23:     // ��¼ǰ���� ����path[i]=j,��ʾ��s��i�����·����i��ǰһ������j
 24:     //int[] path;
 25:     int u,v,w;
 26:     while(sc.hasNext()) {
 27:       n = sc.nextInt();
 28:       m = sc.nextInt();
 29:       for(int i=0; i<205; i++) {
 30:         for(int j=i; j<205; j++) {
 31:           map[i][j] = Inf;
 32:           map[j][i] = Inf;
 33:         }
 34:       }
 35:       for(int i=0; i<m; i++) {
 36:         u = sc.nextInt();
 37:         v = sc.nextInt();
 38:         w = sc.nextInt();
 39:         //���ر�
 40:         if(map[u][v]>w) {
 41:           map[v][u] = w;
 42:           map[u][v] = w;
 43:         }
 44:       }
 45:       int s = sc.nextInt();
 46:       int t = sc.nextInt();
 47:       spfa(s);
 48:       //��Ŀ����st<n�����Բ����ж�dis[t]�Ƿ�Խ��
 49:       //����յ���ͬ�Ļ�����0
 50:       if(Inf==dis[t]) {
 51:         System.out.println(-1);
 52:       }else {
 53:         System.out.println(dis[t]);
 54:       }
 55:     }
 56:   }
 57: 
 58:   private static void spfa(int s) {
 59:     
 60:     for(int i=0; i<205; i++) {
 61:       vis[i] = false;
 62:       //��ʼ��Ϊmap[s][i]��һ�����ݾʹ���
 63:       dis[i] = Inf;
 64:     }
 65:     dis[s] = 0;
 66:     vis[s] = true;
 67:     Comparator<Integer> cmp = new Comparator<Integer>() {
 68:           
 69:           public int compare(Integer o1, Integer o2) {
 70:             int i = (int)o1;
 71:             int j = (int)02;
 72:             if(dis[i]>dis[j]) {
 73:               return 1;
 74:             }else if(dis[i]==dis[j]){
 75:               return 0;
 76:             }else {
 77:               return -1;
 78:             }
 79:           }
 80:     };
 81:     //����ӿڱ�̣�205�������ȶ���(����)������
 82:     Queue<Integer> q = new PriorityQueue<Integer>(205, cmp);
 83:     q.clear();
 84:     q.offer(s);
 85:     while(!q.isEmpty()) {
 86:       int head = q.poll();
 87:       //��ע�������Щ������ظ���ӣ����Գ��ӵĵ�ҲҪ������δ��� 
 88:       vis[head] = false;
 89:       for(int i=0; i<n; i++) {
 90:         //dis[head]��������INF��map[head][i]������INF
 91:         int temp = dis[head] + map[head][i];
 92:         if(temp<dis[i]) {
 93:           //path[i] = head
 94:           dis[i] = temp;
 95:           if(!vis[i]) {
 96:             //��һ�������ڴ˼�¼��Ӵ���������n�ʹ��ڸ�������������ж�
 97:             q.offer(i);
 98:             vis[i] = true;
 99:           }
100:         }
101:       }
102:     }
103:   }
104:     
105: }


 */

