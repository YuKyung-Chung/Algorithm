import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //표의크기
		int M = sc.nextInt(); //합 구해야 하는 횟수
		
		int[][] arr = new int[N+1][N+1];
		int[][] S = new int[N+1][N+1]; //구간합 저장할 배열
		//배열 값 채우기
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				arr[i][j] = sc.nextInt();
				S[i][j] = S[i][j-1] + S[i-1][j] - S[i-1][j-1] + arr[i][j];
				
			}
		}
		
		for(int i=0; i<M; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			System.out.println(S[x2][y2] - S[x1-1][y2] - S[x2][y1-1] + S[x1-1][y1-1]);
		}
	}
}
