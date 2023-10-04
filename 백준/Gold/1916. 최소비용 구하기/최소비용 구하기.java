import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Node implements Comparable<Node>{
		int ed, cost;
	
		public Node(int ed, int cost) {
			this.ed = ed;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	static int N,M,start, end;
	static List<Node>[] list;
	static int[] dist;
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); //도시의 개수
		M = sc.nextInt(); //버스의 개수
		
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		
		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int c = sc.nextInt();
			
			list[A].add(new Node(B,c));
		}//입력 끝
		
		start = sc.nextInt(); //출발 도시번호
		end = sc.nextInt(); //도착 도시번호
		
		
		dijkstra(start);
		
		System.out.println(dist[end]);
		
	}//main
	
	public static void dijkstra(int start) {
		boolean[] visited = new boolean[N+1];
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		q.add(new Node(start,0));
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			Node curNode = q.poll();
			int cur = curNode.ed;
			
			if(visited[cur]) continue;
			visited[cur] = true;
			
			for (Node node : list[cur]) {
				if(!visited[node.ed] && dist[node.ed] > dist[cur] + node.cost) {
					dist[node.ed] = dist[cur] + node.cost;
					q.add(new Node(node.ed, dist[node.ed]));
				}
			}
		}
		
	}//dijkstra
}
