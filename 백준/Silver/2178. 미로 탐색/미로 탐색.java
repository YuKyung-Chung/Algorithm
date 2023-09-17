import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N,M,min;
	static int[][] arr;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		
		//배열에 값 채우기
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(str.substring(j,j+1));
			}
		}
	
		visited = new boolean[N][M];
		min = Integer.MAX_VALUE;
		
		BFS(0,0);
		System.out.println(arr[N-1][M-1]);
	}//main
	
	public static void BFS(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i,j});
		visited[i][j] = true;
		int cnt = 1;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			
			//인접한 4칸으로만 이동 가능
			for (int k = 0; k <4; k++) {
				int nx = dx[k] + cur[0];
				int ny = dy[k] + cur[1];
					
				if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if(visited[nx][ny] || arr[nx][ny] == 0) continue;
							
					if(arr[nx][ny] == 1 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						q.add(new int[] {nx,ny});
						arr[nx][ny] = arr[x][y] + 1;
					} 
				}
					
			}
		}
		
	}//BFS
}

