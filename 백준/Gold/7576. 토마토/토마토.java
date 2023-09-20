import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N,M, cnt, result;
	static int[][] arr;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean[][] visited;
	static Queue<int[]> q;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt(); //가로
		N = sc.nextInt(); //세로
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		q = new LinkedList<>();
		visited = new boolean[N][M];
		cnt = -1;
		result = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j] == 1) {
					q.add(new int[] {i,j});
					visited[i][j] = true;
					
					//불일치하면 방문못하는거임
				}
			}
		}
		BFS();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j] == 0 && visited[i][j] == false) {
					cnt = -1;
				}
			}
		}

		System.out.println(cnt);
		
	}//main
	
	public static void BFS() {
		while(!q.isEmpty()) {
			int a = q.size();
			for (int k = 0; k < a; k++) {
				int[] cur = q.poll();
				
				for (int i = 0; i < 4; i++) {
					int nx = dx[i] + cur[0];
					int ny = dy[i] + cur[1];
					
					if(nx < 0 || ny <0 || nx >= N || ny >= M || visited[nx][ny] || arr[nx][ny] == -1) continue;
					
					if(arr[nx][ny] == 0 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						q.add(new int[] {nx,ny});
					}
				}
			}
			cnt++;
		}
		
	}
}
