import java.util.Scanner;

public class Solution {
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //테스트 케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); //배열의 크기
			int[][] arr = new int[N][N];
			
			//배열에 값 입력받음
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(str.substring(j,j+1));
				}
			}
			
			int sum = 0;
			int mid = N/2;
			int step = 0;
			for (int i = 0; i < N; i++) {
				for (int j = mid-step; j <= mid+step; j++) {
					sum += arr[i][j];
				}
				if(i<mid) step++;
				else step--;
			}
			
			System.out.printf("#%d %d\n",tc,sum);
		}
	}
}