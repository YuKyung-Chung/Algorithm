
import java.util.Scanner;

public class Solution {
	static int N,K,count;
	static int[] A;
	
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			count = 0;
			
			A = new int[N];
			//수열에 값 입력받기
			for (int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}
			
			partSum(0,0);
			
			System.out.printf("#%d %d\n",tc,count);
		}//tc
	}//main
	
	public static void partSum(int idx, int sum) {
		if(idx==N) {
			if(sum == K) {
				count++;
			}
			return;
		}
		
		partSum(idx+1, sum+A[idx]);
		partSum(idx+1, sum);
	}
}
