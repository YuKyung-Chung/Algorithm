import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //거스름돈 액수
		int[] dp = new int[100001];
		//dp 배열 초기화
		dp[0] = 0;
		dp[1] = -1;
		dp[2] = 1;
		dp[3] = -1;
		dp[4] = 2;
		dp[5] = 1;
		for (int i = 6; i <= N; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		
		//2원, 5원으로 최소 동전 개수 구하는 DP
		for (int i = 6; i <= N; i++) {
			if(dp[i-2] == -1 && dp[i-5] == -1) {
				dp[i] = -1;
			} else if(dp[i-2] == -1) {
				dp[i] = dp[i-5] + 1;
			}else if(dp[i-5] == -1) {
				dp[i] = dp[i-2] + 1;
			}else {
				dp[i] = Math.min(dp[i-2], dp[i-5]) + 1;
			}
			
		}
		System.out.println(dp[N]);
	}//main
}
