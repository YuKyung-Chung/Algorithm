import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node>{
	int x;
	double w; //두 정점 사이 가중치
	
	Node(int x, double w){
		this.x = x;
		this.w = w;
	}
	
	//가중치 기준으로 정렬
	public int compareTo(Node o) {
		return Double.compare(this.w, o.w);
	}
	
}

public class Solution {
	static final int INF = Integer.MAX_VALUE;
	static int N;
	static int[][] island;
	static double[][] tunel;
	
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //테스트 케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); //섬 개수(정점)
			island = new int[N][2]; //섬의 좌표
			
			//두 연결 섬의 번호와 터널 환경 부담금 가중치 저장
			//정점의 수가 N이면 모든 간선의 경우의 수는 N(N-1)/2
			int V = N*(N-1)/2;
			tunel = new double[V][3];
			List<Node>[] graph = new ArrayList[N]; //노드 정보 담을 그래프
			for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();
			
			//섬 좌표 입력
			for (int i = 0; i < N; i++) island[i][0] = sc.nextInt();
			for (int i = 0; i < N; i++) island[i][1] = sc.nextInt();
			
			double E = sc.nextDouble(); //환경 부담 세율 실수
			
			int idx = 0; //tunel에 넣을 인덱스 갱신시킬 번호
			//N개중에서 2개의 섬 조합 뽑기
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					//0인덱스 : 섬의 번호, 1인덱스 : 섬의 번호 (순서 상관 X)
					tunel[idx][0] = i;
					tunel[idx][1] = j;
					//2인덱스 : 가중치
					double tmp = E*(Math.pow(island[i][0] - island[j][0], 2) +Math.pow(island[i][1] - island[j][1], 2));
					tunel[idx][2] = tmp;
					
					//정점 정보와 가중치 추가
					graph[i].add(new Node(j, tmp));
					graph[j].add(new Node(i, tmp));
					idx++;
				}
			}//조합 끝
			
			boolean[] visited = new boolean[N];
			
			//프림 알고리즘을 위한 우선순위 큐
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(0,0));
			
			double ans = 0;
			
			while(!pq.isEmpty()) {
				Node node = pq.poll();
				int x = node.x;
				double w = node.w;
				
				if(visited[x]) continue;
				
				visited[x] = true;
				ans += w;
				
				for(Node n:graph[x]) {
					//해당 정점과 연결된 정점들 중 방문하지 않은 정점들 큐에 추가
					if(!visited[n.x]) pq.add(n);
				}
			}
			System.out.printf("#%d %d\n",tc,Math.round(ans));
		}//tc
	}//main
}
