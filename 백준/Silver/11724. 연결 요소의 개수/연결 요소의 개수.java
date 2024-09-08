import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N,M,cnt;
	static ArrayList<Integer>[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); //정점의 개수
		M = sc.nextInt(); //간선의 개수
		arr = new ArrayList[N+1];
		
		for(int i=0; i<=N; i++) {
			//초기화
			arr[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			//무방향 그래프
			arr[u].add(v);
			arr[v].add(u);
		}
		
		cnt = 0;
		visited = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			//연결요소 개수 찾기
			if(!visited[i]) {				
				DFS(i);
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}//main
	
	public static void DFS(int node) {
		visited[node] = true;
		
		for(int i: arr[node]) {
			if(!visited[i]) {
				visited[i] = true;
				DFS(i);
			}
		}
	}
}
