package oj.hdu;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class hdu1874畅通工程续 {
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
