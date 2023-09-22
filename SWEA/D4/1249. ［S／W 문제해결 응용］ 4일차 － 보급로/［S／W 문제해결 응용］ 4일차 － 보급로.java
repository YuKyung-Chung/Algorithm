import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	static class Node implements Comparable<Node>{
		int r; //행
		int c; //열
		int dist; //거리
		
		public Node(int r, int c, int dist){
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
		
		//가중치 기준으로 오름차순 정렬
		@Override
		public int compareTo(Node o) {
			return (this.dist > o.dist) ? 1 : -1;
		}
		
	}
	private static final int INF = Integer.MAX_VALUE;
	static int N;
	static Node[][] arr;
	static int[][] dist;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static void main(String[] args)   {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //테스트 케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			arr = new Node[N][N];
			//배열 정보 저장
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++) {
					arr[i][j] =  new Node(i, j, Integer.parseInt(str.substring(j, j+1)));
				}
			}
			dist = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			
			//다익스트라 알고리즘
			PriorityQueue<Node> q = new PriorityQueue<>();
			q.add(new Node(0,0,0));
			
			while(!q.isEmpty()) {
				Node cur = q.poll();
					
				for (int i = 0; i < 4; i++) {
					int nx = dx[i] + cur.r;
					int ny = dy[i] + cur.c;
						
					if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
						
					if(dist[nx][ny] > cur.dist + arr[nx][ny].dist) {
						dist[nx][ny] = cur.dist + arr[nx][ny].dist;
						q.add(new Node(nx, ny, dist[nx][ny]));
					}
				}
				if(cur.r == N-1 && cur.c == N-1) break;
			}
			System.out.printf("#%d %d\n",tc,dist[N-1][N-1]);
		}//tc
	}//main
}