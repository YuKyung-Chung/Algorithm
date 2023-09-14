import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N,M,V,idx;
	static ArrayList<Integer>[] arr;
	static boolean[] visited;
	static StringBuilder sb, sb2;
	
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
		
		sb = new StringBuilder();
		idx = 1;
		visited = new boolean[N+1];
		DFS(V);
		
		sb2 = new StringBuilder();
		idx = 1;
		visited = new boolean[N+1];
		BFS(V);

		System.out.println(sb);
		System.out.println(sb2);
		
	} //main
	
	public static void DFS(int v) {
		sb.append(v+" ");
		visited[v] = true;
		
		for (int next : arr[v]) {
			if(visited[next]) continue;
			
			idx++;
			visited[next] = true;
			DFS(next);
		}
	}//DFS
	
	public static void BFS(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		visited[v] = true;
		sb2.append(v+ " ");
				
		while(!q.isEmpty()) {
			int a = q.poll();
			
			for (int next : arr[a]) {
				if(visited[next]) continue;
				
				q.offer(next);
				visited[next] = true;
				sb2.append(next+" ");
			}
		}
		
	}//BFS
}
