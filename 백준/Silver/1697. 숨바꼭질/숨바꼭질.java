import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N,K,cnt;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //수빈이 위치
		K = sc.nextInt(); //동생 위치
		visited = new boolean[300000];
		
		System.out.println(BFS(N));
//		System.out.println(cnt);
	}//main
	
	public static int BFS(int cur) {
		Queue<Integer> q = new LinkedList<>();
		q.add(cur);
		visited[cur] = true;
		
		while(!q.isEmpty()) {
			int a = q.size();
			for (int i = 0; i < a; i++) {
				int now = q.poll();
//				System.out.println(cnt+"번 사이클"+now);
				if(now == K) return cnt;
				
				if(now * 2 < K*2 && !visited[now*2]) {
					q.add(now*2);
					visited[now*2] = true;
				}
				if(now + 1 < K*2 && !visited[now+1]) {
					q.add(now + 1);
					visited[now+1] = true;
				}
				if(now -1 > 0 && !visited[now-1]) {
					q.add(now - 1);
					visited[now-1] = true;
				}
				
			}
			cnt++;
		}
		return cnt;
	}
}
