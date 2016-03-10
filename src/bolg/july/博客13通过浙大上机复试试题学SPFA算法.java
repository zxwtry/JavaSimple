package bolg.july;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/*
博客网址：http://blog.csdn.net/v_july_v/article/details/6277490
		SPFA算法(Shortest Path Faster Algorithm)
	
简洁起见，我们约定有向加权图G不存在负权回路，即最短路径一定存在。
当然，我们可以在执行该算法前做一次拓扑排序，以判断是否存在负权回路。

我们用数组d记录每个结点的最短路径估计值，而且用邻接表来存储图G。
我们采取的方法是动态逼近法：设立一个先进先出的队列用来保存待优化的结点，
优化时每次取出队首结点u，并且用u点当前的最短路径估计值对离开u点所指向的结点v进行松弛操作，
如果v点的最短路径估计值有所调整，且v点不在当前的队列中，就将v点放入队尾。
这样不断从队列中取出结点来进行松弛操作，直至队列空为止。

定理: 只要最短路径存在，上述SPFA算法必定能求出最小值。 
期望的时间复杂度O(ke)， 其中k为所有顶点进队的平均次数，可以证明k一般小于等于2。	

问题描述：
给你n个点，m条无向边，每条边都有长度d和花费p，给你起点s终点t，
要求输出起点到终点的最短距离及其花费，如果最短距离有多条路线，则输出花费最少的。

输入：输入n,m，点的编号是1~n,然后是m行，每行4个数 a,b,d,p，表示a和b之间有一条边，
且其长度为d，花费为p。最后一行是两个数 s,t;起点s，终点t。n和m为0时输入结束。
(1<n<=1000, 0<m<100000, s != t)
输出：一行有两个数， 最短距离及其花费。
	
*/

public class 博客13通过浙大上机复试试题学SPFA算法 {

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
			//该注意的是有些点可能重复入队，所以出队的点也要重新置未标记 
			vis[head] = false;
			for (int i = 0; i < n; i ++) {
				//dis[head]不可能是INF，map[head][i]可能是INF
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
		// 记录前驱点 。若path[i]=j,表示从s到i的最短路径中i的前一个点是j
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
				//多重边
				if (map[u][v] > w) {
					map[u][v] = w;
					map[v][u] = w;
				}
			}
			int s = sc.nextInt();
			int t = sc.nextInt();
			spfa(s);
			//题目上有st<n，所以不必判断dis[t]是否越界
			//起点终点相同的话答案是0
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


一.理论准备

        为了学习网络流，先水一道spfa。

        SPFA算法是1994年西南交通大学段凡丁提出，只要最短路径存在，
        SPFA算法必定能求出最小值，SPFA对Bellman-Ford算法优化的关键之处在于意识到：
        只有那些在前一遍松弛中改变了距离估计值的点，才可能引起他们的邻接点的距离估计值的改变。
        为什么队列为空就不改变了呢？就是因为要到下一点必须经过它的前一个邻接点。。SPFA可以处理负权边。
        很多时候，给定的图存在负权边，这时类似Dijkstra等算法便没有了用武之地，
        而Bellman-Ford算法的复杂度又过高，SPFA算法便派上用场了。
        简洁起见，我们约定有向加权图G不存在负权回路，
        即最短路径一定存在。当然，我们可以在执行该算法前做一次拓扑排序，以判断是否存在负权回路。

        初始化： dis数组全部赋值为Inf(无穷大，不能是map[s][i]),
        path数组全部赋值为s（即源点），或者赋值为-1，
        表示还没有知道前驱,然后dis[s]=0;  表示源点不用求最短路径，
        或者说最短路就是0。将源点入队；另外记住在整个算法中有顶点入队了要记得标记vis数组，
        有顶点出队了记得消除那个标记(可能多次入队)。

        核心：读取队头顶点u，并将队头顶点u出队（记得消除标记）；
        将与点u相连的所有点v进行松弛操作，如果能更新估计值（即令d[v]变小），
        那么就更新，另外，如果点v没有在队列中，那么要将点v入队（记得标记），
        如果已经在队列中了，那么就不用入队以此循环，直到队空为止就完成了单源最短路的求解。

        判断有无负环：如果某个点进入队列的次数超过N次则存在负环(SPFA无法处理带负环的图)，
        假设这个节点的入度是k(无向权则就是这个节点的连接的边)如果进入这个队列超过k,
        说明必然有某个边重复了，即成环；换一种思路：用DFS，
        假设存在负环a1->a2->…->an->a1。那么当从a1深搜下去时又遇到了a1，
        那么直接可以判断负环了所有用。
        当某个节点n次进入队列，则存在负环，此时时间复杂度为O(n*m),n为节点，m为边。

        SPFA算法有两个优化算法 SLF 和 LLL： SLF：Small Label First 策略，
        设要加入的节点是j，队首元素为i，若dist(j)<dist(i)，则将j插入队首，否则插入队尾。
         LLL：Large Label Last 策略，设队首元素为i，队列中所有dist值的平均值为x，
         若dist(i)>x则将i插入到队尾，查找下一元素，直到找到某一i使得dist(i)<=x，则将i出对进行松弛操作。 
         SLF 可使速度提高 15 ~ 20%；SLF + LLL 可提高约 50%。 
         在实际的应用中SPFA的算法时间效率不是很稳定，为了避免最坏情况的出现，
         通常使用效率更加稳定的Dijkstra算法。个人觉得LLL优化每次要求平均值，
         不太好，为了简单，我们可以之间用c++STL里面的优先队列来进行SLF优化。


二.算法实现

        直接去把HDU1874AC了吧。

  1: import java.util.Comparator;
  2: import java.util.PriorityQueue;
  3: import java.util.Queue;
  4: import java.util.Scanner;
  5: /*
  6:  * 原来一直wa，重写了一遍，AC了
  7:  * SLF优化
  8:  
  9: public class HD1874 {
 10: 
 11:   static int n,m;
 12:   static int[][] map  = new int[205][205];
 13:   static int[] dis  = new int[205];
 14:   static boolean[] vis  = new boolean[205];
 15:   /*
 16:    * 路径最大值是10000，不能设置成10005就行，还要考虑和
 17:    * 也不能是整形最大值，否则一加就溢出了
 18:    
 19:   static final int Inf = 0x3f3f3f3f;
 20:   
 21:   public static void main(String[] args) {
 22:     Scanner sc = new Scanner(System.in);
 23:     // 记录前驱点 。若path[i]=j,表示从s到i的最短路径中i的前一个点是j
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
 39:         //多重边
 40:         if(map[u][v]>w) {
 41:           map[v][u] = w;
 42:           map[u][v] = w;
 43:         }
 44:       }
 45:       int s = sc.nextInt();
 46:       int t = sc.nextInt();
 47:       spfa(s);
 48:       //题目上有st<n，所以不必判断dis[t]是否越界
 49:       //起点终点相同的话答案是0
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
 62:       //初始化为map[s][i]第一组数据就错了
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
 81:     //面向接口编程；205代表优先队列(是类)的容量
 82:     Queue<Integer> q = new PriorityQueue<Integer>(205, cmp);
 83:     q.clear();
 84:     q.offer(s);
 85:     while(!q.isEmpty()) {
 86:       int head = q.poll();
 87:       //该注意的是有些点可能重复入队，所以出队的点也要重新置未标记 
 88:       vis[head] = false;
 89:       for(int i=0; i<n; i++) {
 90:         //dis[head]不可能是INF，map[head][i]可能是INF
 91:         int temp = dis[head] + map[head][i];
 92:         if(temp<dis[i]) {
 93:           //path[i] = head
 94:           dis[i] = temp;
 95:           if(!vis[i]) {
 96:             //用一个数组在此记录入队次数，大于n就存在负环；如何事先判断
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

