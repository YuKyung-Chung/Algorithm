import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //배달할 설탕 무게
		//3킬로, 5킬로 봉지
		int[] dp = new int[5001];
		//dp 배열 초기화
		dp[1] = -1;
		dp[2] = -1;
		dp[3] = 1;
		dp[4] = -1;
		dp[5] = 1;
		for (int i = 6; i <= N; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		
		//dp
		for (int i = 6; i <= N; i++) {
			if(dp[i-3] == -1 && dp[i-5] == -1) {
				dp[i] = -1;
			}
			else if(dp[i-3] == -1) {
				dp[i] = dp[i-5] + 1;
			}
			else if(dp[i-5] == -1) {
				dp[i] = dp[i-3] + 1;
			}else {
				dp[i] = Math.min(dp[i-3], dp[i-5]) + 1;
			}
		}
		
		System.out.println(dp[N]);
	}
}
