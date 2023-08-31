
import java.util.Scanner;

public class Solution {
	static int N,M;
	static int answer;
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();
			
			N = sc.nextInt();
			M = sc.nextInt();
			answer = pow(M);
			
			System.out.printf("#%d %d\n",tc,answer);
			
		}//tc
	}//main
	
	public static int pow(int M) {
		if(M == 1) {
			return N;
		}
		return N * pow(M-1);
	}
}
