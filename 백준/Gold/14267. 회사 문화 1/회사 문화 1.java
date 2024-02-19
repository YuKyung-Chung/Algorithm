import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static List<Integer>[] workers;
	static int[] praise; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //직원수
		int M = sc.nextInt(); //칭찬 횟수
		
		workers = new ArrayList[N+1];
		//ArrayList 초기화
		for (int i = 0; i < N+1; i++) {
			workers[i] = new ArrayList<>();
		}
		
		//직속 부하 정보 입력
		for (int i = 1; i <= N; i++) {
			int j = sc.nextInt();
			if(j != -1) {
				workers[j].add(i);
			}
		}
		
		praise = new int[N+1];
		for (int i = 0; i < M; i++) {
			int cur = sc.nextInt(); //칭찬 받은 직원 번호
			int w = sc.nextInt(); //칭찬 수치
			
			praise[cur] += w;
		}
		
		dfs(1);
		for (int i = 1; i < praise.length; i++) {
			System.out.print(praise[i] + " ");
		}
		
		
	}//main
	
	static void dfs(int idx) {
		for(int i : workers[idx]) {
			praise[i] += praise[idx];
			dfs(i);
		}
	}
}
