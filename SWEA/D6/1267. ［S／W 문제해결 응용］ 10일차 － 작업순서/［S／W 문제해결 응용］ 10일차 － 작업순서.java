
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args)   {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int V = sc.nextInt(); //정점 개수
			int E = sc.nextInt(); //간선 개수
			
			//인접행렬
			int[][] adjArr = new int[V+1][V+1]; //1번 정점부터 V번까지
			int[] degree = new int[V+1]; //진입차수 저장할 배열 생성
			
			for (int i = 0; i < E; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				
				//유향그래프 A -> B
				adjArr[A][B] = 1; //가중치 따로 주어지지 않았기 때문에
				//진입차수 증가
				degree[B]++;
			}//입력 완료
			
			//degree가 0인 친구만 넣을 수 있는 큐 생성
			Queue<Integer> q = new LinkedList<>();
			
			List<Integer> list = new ArrayList<>();
			
			//초기에 진입차수가 0인 것들 몽땅 넣기
			for (int i = 1; i <= V; i++) {
				if(degree[i] == 0)
					q.add(i);
			}
			
			while(!q.isEmpty()) {
				int cur = q.poll(); //현재 정점 하나 꺼내기
				list.add(cur);
				//연결 끊는 작업
				for (int i = 1; i <= V; i++) {
					//연결확인
					if(adjArr[cur][i] == 1) {
						adjArr[cur][i] = 0; //간선 제거
						degree[i]--; //진입차수 감소
						
						//진입차수가 0이 되었다는 것은 선행작업이 완료됨을 의미
						//큐에 삽입
						if(degree[i] == 0)
							q.add(i);
					}
				}
			}
			
			System.out.print("#"+tc+" ");
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
			
		}//tc
	}//main
}
