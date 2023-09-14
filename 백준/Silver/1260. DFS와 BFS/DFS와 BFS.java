import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N,M,V,idx;
	static ArrayList<Integer>[] arr;
	static boolean[] visited;
	static StringBuilder dfs, bfs;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //정점 개수
		M = sc.nextInt(); //간선 개수
		V = sc.nextInt(); //탐색 시작 정점 번호
		
		arr = new ArrayList[N+1];
		//초기화
		for (int i = 0; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		//간선 정보 입력
		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			arr[u].add(v);
			arr[v].add(u);
		}
		for (int i = 0; i <=N ; i++) {
			Collections.sort(arr[i]);
		}
		
		dfs = new StringBuilder();
		visited = new boolean[N+1];
		DFS(V);
		
		bfs = new StringBuilder();
		visited = new boolean[N+1];
		BFS(V);

		System.out.println(dfs);
		System.out.println(bfs);
		
	} //main
	
	public static void DFS(int v) {
		dfs.append(v+" ");
		visited[v] = true;
		
		for (int next : arr[v]) {
			if(visited[next]) continue;
			
			visited[next] = true;
			DFS(next);
		}
	}//DFS
	
	public static void BFS(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		visited[v] = true;
		bfs.append(v+ " ");
				
		while(!q.isEmpty()) {
			int a = q.poll();
			
			for (int next : arr[a]) {
				if(visited[next]) continue;
				
				q.offer(next);
				visited[next] = true;
				bfs.append(next+" ");
			}
		}
		
	}//BFS
}
