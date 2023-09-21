import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	private static final Object INF = Integer.MAX_VALUE;
	static int N, min;
	static int[][] arr;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[][] dist;
		
	
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //테스트 케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			arr = new int[N][N];
			//배열 정보 저장
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(str.substring(j,j+1));
				}
			}
			dist = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			
			//다익스트라 알고리즘
			PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
			});
			q.add(new int[] {arr[0][0], 0, 0});
			
			while(!q.isEmpty()) {
				int[] cur = q.poll();
					
				for (int i = 0; i < 4; i++) {
					int nx = dx[i] + cur[1];
					int ny = dy[i] + cur[2];
						
					if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
						
					if(dist[nx][ny] > cur[0] + arr[nx][ny]) {
						dist[nx][ny] = cur[0] + arr[nx][ny];
						q.add(new int[] {dist[nx][ny], nx, ny});
					}
				}
				if(cur[1] == N-1 && cur[2] == N-1) break;
			}
			System.out.printf("#%d %d\n",tc,dist[N-1][N-1]);
		}//tc
	}//main
	
}
