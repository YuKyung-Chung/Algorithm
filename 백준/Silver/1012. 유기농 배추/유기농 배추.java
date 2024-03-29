import java.util.Scanner;

public class Main {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] arr;
	static boolean[][] visited;
	static int M,N,K;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			M = sc.nextInt(); //가로길이
			N = sc.nextInt(); //세로길이
			K = sc.nextInt(); //위치개수

			arr = new int[M][N];
			visited = new boolean[M][N];
			
			for (int j = 0; j < K; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				arr[x][y] = 1; //배추 심기
			}
			int cnt = 0;
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < N; k++) {
					if(arr[j][k] == 1 && !visited[j][k]) {
						cnt++;
						DFS(j,k,cnt);
						
					}
				}
			}
			
			System.out.println(cnt);
			
		}//tc
	}//main
	
	public static void DFS(int x, int y,int cnt) {
		if(cnt == K) return;
		if(x==M && y==N) return;
		
		visited[x][y] = true;
		

		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			
			if(nx < 0 || ny < 0 || nx >= M || ny >= N || visited[nx][ny] || arr[nx][ny] == 0) continue;
			
			if(arr[nx][ny] == 1) {
				visited[nx][ny] = true;
				DFS(nx,ny, cnt+1);
			}
		}
	}
}
