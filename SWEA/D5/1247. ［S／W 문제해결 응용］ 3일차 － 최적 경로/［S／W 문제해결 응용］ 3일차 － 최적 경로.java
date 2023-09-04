
import java.util.Scanner;

public class Solution {
	static class Pos{
		int x,y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	} //Pos
	
	static int N, ans;
	static Pos comp, home;
	static Pos[] cust;
	static boolean[] visited;
	
	public static void main(String[] args)   {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //테스트 케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); //고객의 수
			
			comp = new Pos(sc.nextInt(), sc.nextInt()); //회사 좌표
			home = new Pos(sc.nextInt(), sc.nextInt()); //집 좌표
			cust = new Pos[N];
			visited = new boolean[N];
			ans = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				cust[i] = new Pos(sc.nextInt(), sc.nextInt());
			} //고객 좌표 입력받기
			
			find(0,comp,0);
			
			System.out.println("#"+tc+" "+ans);
		} //tc
	} //main
	
	public static void find(int idx, Pos curr, int sum) {
		if(sum > ans) return; 
		
		if(idx == N) { //N번째 고객에게 도착했을 때
			ans = Math.min(ans, sum + distance(home, curr));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				find(idx+1, cust[i], sum + distance(curr, cust[i]));
				visited[i] = false;
			}
		}
	}
	//거리의 절댓값 구하는 함수
	public static int distance(Pos cust1, Pos cust2) {
		int dist = Math.abs(cust1.x - cust2.x) + Math.abs(cust1.y - cust2.y);
		return dist;
	}
	
}
