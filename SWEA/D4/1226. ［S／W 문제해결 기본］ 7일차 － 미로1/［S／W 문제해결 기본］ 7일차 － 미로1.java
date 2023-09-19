import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int result;
	static int[][] arr;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean[][] visited;
	static boolean isTrue;
	
	public static void main(String[] args)   {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();
			
			arr = new int[16][16];
			visited = new boolean[16][16];
			//미로 정보 입력
			for (int i = 0; i < 16; i++) {
				String str = sc.next();
				for (int j = 0; j < 16; j++) {
					arr[i][j] = Integer.parseInt(str.substring(j,j+1));
				}
			}
			isTrue = false;
			BFS(1,1);
			
			if(isTrue) result = 1;
			else result = 0;
			
			System.out.printf("#%d %d\n",tc,result);
		}//tc
	}//main
	
	public static void BFS(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + cur[0];
				int ny = dy[i] + cur[1];
				
				if(visited[nx][ny]) continue;
				
				if(nx < 0 || ny < 0 || nx >= 16 || ny >= 16 || arr[nx][ny] == 1) continue;
				
				if(arr[nx][ny] == 3) {
					isTrue = true;
					return;
				}
				
				if(arr[nx][ny] == 0) {
					visited[nx][ny] = true;
					q.add(new int[] {nx,ny});
				}
			}
		}
	}
}
