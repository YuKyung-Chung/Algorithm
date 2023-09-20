import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, max;
	static int[][] arr;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		

			N = sc.nextInt(); //치즈 한 변의 길이
			arr = new int[N][N]; //치즈 정보 저장할 배열
			
			//치즈 정보 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			max = -1; //최대 덩어리 개수 저장할 변수 초기화
			//100일 동안 변화 진행
			for (int day = 0; day <= 100; day++) {
				//X번째 날일 때 X보다 작은 칸 0으로 초기화
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(arr[i][j] <= day) {
							arr[i][j] = 0;
						}
					}
				}
				
				//날짜 바뀔때마다 visited 배열 초기화
				visited = new boolean[N][N];
				int cnt = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(arr[i][j] != 0 && !visited[i][j]) {
							cnt++;
//							DFS(i,j,day);
							BFS(i,j,day);
						}
					}
				}
				max = Math.max(max, cnt); //최대 덩어리 개수 갱신
				
			}
			
			System.out.println(max);

	} //main
	
	public static void BFS(int x, int y, int day) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		//현재 좌표 방문처리
		visited[x][y] = true;

		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			//좌우상하 4방향 탐색
			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + cur[0];
				int ny = dy[i] + cur[1];
						
				//경계조건
				if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || arr[nx][ny] == 0) continue;
						
				visited[nx][ny] = true; //방문처리
				BFS(nx,ny,day); //day별로 DFS로 덩어리 탐색 진행
			}
		}
	} //BFS
	
	public static void DFS(int x, int y, int day) {
		//현재 좌표 방문처리
		visited[x][y] = true;

		//좌우상하 4방향 탐색
		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			
			//경계조건
			if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || arr[nx][ny] == 0) continue;
			
			visited[nx][ny] = true; //방문처리
			DFS(nx,ny,day); //day별로 DFS로 덩어리 탐색 진행
		}
		
	} //DFS
}