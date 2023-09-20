import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int N,M,cnt;
	static int[][] arr;
	static int[][] result;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //세로크기
		M = Integer.parseInt(st.nextToken()); //가로크기
		arr = new int[N][M];
		result = new int[N][M];
		visited = new boolean[N][M];
		
		//배열 정보 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cnt = 1;
		//목표지점에서부터 BFS 탐색 시작
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j] == 2) {
					result[i][j] = 0;
					BFS(i,j);
				}
			}
		}
		//갈수없는 땅인 경우 0 저장
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j] == 0 && visited[i][j] == false) {
					result[i][j] = 0;
				}
				if(arr[i][j] == 1 && visited[i][j] == false) {
					result[i][j] = -1;
				}
			}
		}
		
		//출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}//main
	
	public static void BFS(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int a = q.size();
			for (int k = 0; k < a; k++) {
				int[] cur = q.poll();
				for (int i = 0; i < 4; i++) {
					int nx = dx[i] + cur[0];
					int ny = dy[i] + cur[1];
					
					if(nx < 0 || ny < 0 || nx >= N || ny >= M ||visited[nx][ny]) continue;
					
					if(arr[nx][ny] == 1) {
						visited[nx][ny] = true;
						q.add(new int[] {nx,ny});
						result[nx][ny] = cnt;
					}
				}
			}
			cnt++;
		}
	}//BFS
}
