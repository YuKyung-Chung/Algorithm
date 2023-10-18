import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N,K;
	static int[] C;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); //커피 개수
		K = sc.nextInt(); //섭취해야 할 카페인 양
		C = new int[N]; //카페인 함유량
		for (int i = 0; i < N; i++) {
			C[i] = sc.nextInt();
		}
		int init = 1001;
		int[][] dp = new int[N+1][K+1];
		//dp배열 초기화
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i],init);
		}
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 0;
		}
		
		
		for (int i = 1; i <= N; i++) {
			int coffee = C[i-1];
			for (int j = 1; j <= K; j++) {
				if(j >= coffee) {
					dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-coffee]+1);
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		if(dp[N][K] == init) System.out.println(-1);
		else System.out.println(dp[N][K]);
		
		
		
	}//main
}
