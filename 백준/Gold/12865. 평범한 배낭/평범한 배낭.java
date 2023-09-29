import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //물품의 수
		int K = sc.nextInt(); //버틸 수 있는 무게
		
		int[] weights = new int[N+1]; //물건의 무게
		int[] value = new int[N+1]; //물건의 가치
		
		//값 입력받기
		for (int i = 1; i <= N; i++) {
			weights[i] = sc.nextInt();
			value[i] = sc.nextInt();
		}
		
		int[][] dp = new int[N+1][K+1];
		
		//물건 하나씩 고려해보기
		for (int i = 1; i <= N; i++) {
			//i번째 물건까지 고려한 경우
			//w: 임시 배낭의 크기
			for (int w = 0; w <= K; w++) {
				if(weights[i] <= w) {
					//해당 물건을 이제 판단해보자
					//현재 해당 무게에서의 최적 해는 dp[i-1][w]
					//이번에 물건을 고려한 최적 해는 dp[i-1][w-weights[i]]+value[i]
					//위의 두 가지 경우 중 최댓값을 저장
					dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weights[i]] +value[i]);
				}else {
					//현재 무게가 임시 무게를 넘어서 고려할 수 없을 때
					dp[i][w] = dp[i-1][w];
				}
			}
			
		}
		System.out.println(dp[N][K]);
		
	}//main
}
