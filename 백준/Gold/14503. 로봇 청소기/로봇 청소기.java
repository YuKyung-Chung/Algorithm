import java.util.Scanner;

public class Main {
	static int N,M,r,c,d,cnt;
	static int[][] arr;
	static int[] dr = {-1,0,1,0}; //북동남서
	static int[] dc = {0,1,0,-1};
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		r = sc.nextInt(); //처음 행
		c = sc.nextInt(); //처음 열
		d = sc.nextInt(); //방향 0:북 1:동 2:남 3: 서
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		visited = new boolean[N][M];
		cnt=1;
		DFS(r,c,d);
		System.out.println(cnt);
	}//main
	
	public static void DFS(int r, int c,int dir) {
		visited[r][c] = true;
		
		//현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
		for (int i = 0; i < 4; i++) {
			//반시계 방향으로 90도 회전
			dir = (dir+3)%4;
			
			int nr = dr[dir] + r;
			int nc = dc[dir] + c;
			
			if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
			
			//청소되지 않은 빈 칸일 경우
			if(!visited[nr][nc] && arr[nr][nc] == 0) {
				cnt++;
				DFS(nr,nc,dir);
				
				//여기서 return 안하면 복귀하는 도중 뒤로가서 다른 곳을 청소할 수 있음!!!
				return;
			}
					
		}

		//현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
		//반대방향 후진
		int dir2 = (dir+2) % 4;
		int nr2 = dr[dir2] + r;
		int nc2 = dc[dir2] + c;
		
		if(nr2 >= 0 && nc2 >= 0 && nr2 < N && nc2 < M && arr[nr2][nc2] != 1) {
			DFS(nr2,nc2,dir); //후진이니까 바라보는 방향 유지
		}
		
	}//DFS
}
