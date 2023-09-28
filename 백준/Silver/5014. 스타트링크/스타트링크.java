import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int F,S,G,U,D,cnt;
	static boolean[] visited;
	static boolean isTrue;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		F = sc.nextInt(); //총 층수
		S = sc.nextInt(); //출발
		G = sc.nextInt(); //도착
		U = sc.nextInt(); //위
		D = sc.nextInt(); //아래
		visited = new boolean[F+1];
		
		isTrue = false;
		cnt = 0;
		
		BFS(S);
		
		if(!isTrue) {
			System.out.println("use the stairs");
		}else {
			System.out.println(cnt);
		}
	}//main
	
	public static int BFS(int cur) {
		visited[cur] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(cur);
		
		while(!q.isEmpty()) {
			int a = q.size();
			for (int i = 0; i < a; i++) {
				int now = q.poll();
				
				if(now == G) {
					isTrue = true;
					return cnt;
				}
				
				//위로 올라가야 하는데 U가 0이면
				if(now < G && U <= 0) {
					return cnt;
				}
				//아래로 내려가야 하는데 D가 0이면
				if(now > G && D <= 0) {
					return cnt;
				}
				
				//위층으로 올라갈 수 있을 때
				if(now + U <= F && !visited[now+U]) {
					visited[now + U] = true;
					q.add(now + U);
				}
				//아래층으로 내려갈 수 있을 때
				if(now - D > 0 && !visited[now-D]) {
					visited[now - D] = true;
					q.add(now - D);
				}
				
			}
			cnt++;
		}
		return cnt;
		
	}//BFS
}
