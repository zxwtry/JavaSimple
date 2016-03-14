package book.algorithmsInJava;
/*
 * 邻接表表示
 */
public class Graph {
	public static void main(String[] args) {
		
	}
	private int vcnt, ecnt;
	private boolean digraph;
	private Node[] adj;
	class Node {
		int v;
		Node next;
		Node (int v, Node next) {
			this.v = v;
			this.next = next;
		}
	}
	Graph (int vcnt, boolean flag) {
		this.vcnt = vcnt;
		this.ecnt = 0;
		digraph = flag;
		adj = new Node[vcnt];
	}
	int getVcnt () {	return vcnt;}
	int getEcnt () {	return ecnt;}
	boolean directed () {	return digraph;}
	void insert(Edge e) {
		int v = e.v, w = e.w;
		adj[v] = new Node (w, adj[v]);
		if (!digraph)	adj[w] = new Node(v, adj[w]);
		ecnt ++;
	}
	AdjList getAdjList (int v) {
		return null;
	}
}
