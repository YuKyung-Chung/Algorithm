import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N,M,p1,p2,cnt;
	static ArrayList<Integer>[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //전체 사람 수
		p1 = sc.nextInt();
		p2 = sc.nextInt();
		M = sc.nextInt(); //관계 수
		arr = new ArrayList[N+1];
		cnt = -1;
		
		//arr 초기화
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new ArrayList<>();
		}
		
		//촌수 관계 입력 받기
		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			arr[u].add(v);
			arr[v].add(u);
		}
		
		visited = new boolean[N+1];
		DFS(p1,0);
		
		System.out.println(cnt);
	}//main
	
	public static void DFS(int cur,int depth) {
		visited[cur] = true;
		
		//촌수 찾았으면 리턴
		if(cur == p2) {
			cnt = depth;
			return;
		}
		
		for (int val : arr[cur]) {
			if(!visited[val]) {
				visited[val] = true;
				DFS(val,depth+1);
			}
		}
		
	}//DFS
}
