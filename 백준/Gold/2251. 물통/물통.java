import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] Sender = {0,0,1,1,2,2};
	static int[] Receiver = {1,2,0,2,0,1};
	static boolean visited[][]; //A,B 무게만 있으면 C 무게 고정되므로 2개만 체크
	static boolean answer[];
	static int now[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		now = new int[3]; //A,B,C 물의 양 저장하는 배열
		now[0] = sc.nextInt(); //A
		now[1] = sc.nextInt(); //B
		now[2] = sc.nextInt(); //C
		visited = new boolean[201][201];
		answer = new boolean[201];
		BFS();
		for(int i=0; i<answer.length; i++) {
			if(answer[i]) {
				System.out.print(i + " ");
			}
		}
	}
	public static void BFS() {
		Queue<AB> q = new LinkedList<>();
		q.add(new AB(0,0));
		visited[0][0] = true;
		answer[now[2]] = true; //현재 C값 정답 배열에 체크
		
		while(!q.isEmpty()) {
			AB p = q.poll();
			int A = p.A;
			int B = p.B;
			int C = now[2] - A - B;
			
			//6가지 경우의 수 탐색
			for (int k = 0; k < 6; k++) {
				int[] next = {A, B, C};
				next[Receiver[k]] += next[Sender[k]];
				next[Sender[k]] = 0;
				
				//물이 넘칠 때
				if(next[Receiver[k]] > now[Receiver[k]]) {
					//초과하는 만큼 다시 이전 물통에 넣어줌
					next[Sender[k]] = next[Receiver[k]] - now[Receiver[k]];
					next[Receiver[k]] = now[Receiver[k]]; //대상 물통은 최대로 채워줌
				}
				//A와 B의 물의 양으로 방문 배열 체크
				if(!visited[next[0]][next[1]]) {
					visited[next[0]][next[1]] = true;
					q.add(new AB(next[0], next[1]));
					//A의 물의 양이 0일때, C의 물의 무게를 정답 변수에 저장
					if(next[0] == 0) {
						answer[next[2]] = true;
					}
				}
			}
		}
		
		
		
	}
}

// AB 클래스 선언 -> A,B만 알면 C는 유추할 수 있으므로 두 변수만 사용
class AB{
	int A;
	int B;
	
	public AB(int A, int B){
		this.A = A;
		this.B = B;
	}
}
