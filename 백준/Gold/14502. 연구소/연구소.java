
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N,M,maxCnt;
	static int[][] arr;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //가로길이
		M = sc.nextInt(); //세로길이
		maxCnt = -1; //최대값 저장할 변수
		
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		DFS(0);
		
		System.out.println(maxCnt);
		
	}//main
	
	public static void DFS(int cnt) {
		if(cnt == 3) {
			//BFS 통해 2가 갈수 있는 곳 모두 2로 채우기
			BFS();
			return;
		}
		
		//0인 곳 중에서 3개 골라서 1로 바꾸기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j] == 0) {
					arr[i][j] = 1;
					DFS(cnt+1);
					arr[i][j] = 0;
				}
			}
		}
		
	}//DFS
	
	//2가 갈 수 있는 곳 모두 2로 채우기
	public static void BFS() {
		Queue<int[]> q = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				//바이러스 있는 곳부터 탐색 시작
				if(arr[i][j] == 2) {
					q.add(new int[] {i,j});
				}
			}
		}
		
		//원본 배열 복사하기
		int[][] tmp = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			tmp[i] = arr[i].clone();
		}
		
		//바이러스 퍼질 수 있는 곳까지 퍼뜨리기
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + cur[0];
				int ny = dy[i] + cur[1];
				
				if(nx <0 || ny <0 || nx >= N || ny >= M) continue;
				
				if(tmp[nx][ny] == 0) {
					tmp[nx][ny] = 2; //빈 칸 바이러스로 채우기
					q.add(new int[] {nx,ny});
				}
			}
		}
		
		int cnt = 0;
		//남은 안전구역 카운트 하기(0의 개수)
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(tmp[i][j] == 0) {
					cnt++;
				}
			}
		}
		//안전구역 최대값 갱신
		maxCnt = Math.max(maxCnt, cnt);
	}//BFS
}
