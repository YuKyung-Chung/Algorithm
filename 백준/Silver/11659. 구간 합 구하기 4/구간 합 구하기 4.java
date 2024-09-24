import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //수의 개수
		int M = sc.nextInt(); //합을 구해야 하는 횟수
		
		int[] nums = new int[N+1];
		int[] S = new int[N+1]; //구간합 저장할 배열
		
		S[0] = 0;
		for(int i=1; i<=N; i++) {
			nums[i] = sc.nextInt();
			S[i] = S[i-1] + nums[i]; 
		}
		
		for(int i=0; i<M; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			
			System.out.println(S[e] - S[s-1]);
		}
	}
}