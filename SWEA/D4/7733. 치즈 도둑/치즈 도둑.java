import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	static int N, max;
	static int[][] arr;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean[][] visited;
	
	public static void main(String[] args)   {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //테스트 케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); //치즈 한 변의 길이
			arr = new int[N][N]; //치즈 정보 저장할 배열
			
			//치즈 정보 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			max = -1;
			tmp: for (int day = 0; day <= 100; day++) {
				
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(arr[i][j] <= day) {
							arr[i][j] = 0;
						}
					}
				}
				
				visited = new boolean[N][N];
				int cnt = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(arr[i][j] != 0 && !visited[i][j]) {
							cnt++;
							DFS(i,j,day);
						}
					}
				}
				max = Math.max(max, cnt);
				
			}
			
			System.out.printf("#%d %d\n", tc, max);
		}//tc
	} //main
	
	public static void DFS(int x, int y, int day) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
					
			if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || arr[nx][ny] == 0) continue;
			
			visited[nx][ny] = true;
			DFS(nx,ny,day);
		}
		
	} //DFS
}
