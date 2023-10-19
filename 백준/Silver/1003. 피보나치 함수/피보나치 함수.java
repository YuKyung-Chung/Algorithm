import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int[][] dp = new int[N+1][2];
			
			dp[0][0] = 1;
			dp[0][1] = 0;
			if(N>=1) {
				dp[1][0] = 0;
				dp[1][1] = 1;
				for (int i = 2; i <= N; i++) {
					for (int j = 0; j < 2; j++) {
						dp[i][j] = dp[i-1][j] + dp[i-2][j];
					}
				}
			}
			System.out.println(dp[N][0] + " " + dp[N][1]);
		}//tc
	}//main
}
