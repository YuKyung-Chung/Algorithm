import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N, cnt, town;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //지도 크기
		map = new int[N][N];
		
		//지도 정보 입력받기
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str.substring(j,j+1));
			}
		}
		List<Integer> list = new ArrayList<>();
		visited = new boolean[N][N];
		town = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					cnt=1;
					town++;
					DFS(i,j);
					list.add(cnt);
				}
			}
		}
		System.out.println(town);
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	} //main
	
	public static void DFS(int x, int y) {
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			
			//edge case
			if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || map[nx][ny] == 0) continue;
			
			if(!visited[nx][ny] && map[nx][ny] == 1) {
				visited[nx][ny] = true;
				cnt++;
				DFS(nx,ny);
			}
			
		}
		
	}//DFS
}
