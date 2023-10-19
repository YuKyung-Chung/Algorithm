import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] dp = new int[N+1];
		
		if(N<M) {
			dp[N] = 1;
		}else {
			for (int i = 1; i < M; i++) {
				dp[i] = 1;
			}
			dp[M] = 2;
				
			if(M+1 <= N) {
				for (int i = M+1; i <= N; i++) {
					dp[i] = (dp[i-M] + dp[i-1]) % 1000000007;
				}
			}
		}
		
		
		
		System.out.println(dp[N] % 1000000007);
	}
}
