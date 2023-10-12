import java.util.Scanner;

public class Solution {
	static int N,answer;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {1,1,-1,-1};
	static int[] dy = {1,-1,-1,1};
	static int start, end;
	static boolean[] dessert;
	
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			answer = 0;
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			//d 0:오른쪽아래 1:왼쪽 아래 2:왼쪽 위 3:오른쪽 위
			for (int i = 0; i < N-2; i++) {
				for (int j = 1; j < N-1; j++) {
					visited = new boolean[N][N];
					dessert = new boolean[101];
					start = i;
					end = j;
					visited[i][j] = true;
					dessert[arr[i][j]] = true;
					DFS(i,j,0,1);
				}
			}
			
			if(answer == 0) {
				System.out.printf("#%d %d\n",tc,-1);
			}else {
				System.out.printf("#%d %d\n", tc, answer);
			}
		}//tc
	}//main
	
	public static void DFS(int x, int y,int d,int cnt) {
		
		//이전 방향으로는 안 돌아감
		for (int i = d; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if(nx>=0 && ny>=0 && nx<N && ny <N) {
				if(nx == start && ny == end && cnt > 2) {
					answer = Math.max(answer,cnt);
					return;
				}
				
				if(!visited[nx][ny] && !dessert[arr[nx][ny]]) {
					visited[nx][ny] = true;
					dessert[arr[nx][ny]] = true;
					DFS(nx,ny,i,cnt+1);
					visited[nx][ny] = false;
					dessert[arr[nx][ny]] = false;
				}
			}
		}
		
	}//DFS
}