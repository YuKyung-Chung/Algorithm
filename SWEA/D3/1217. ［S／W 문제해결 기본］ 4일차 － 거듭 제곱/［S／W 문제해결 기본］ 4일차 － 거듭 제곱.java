import java.util.Scanner;

public class Solution {
	static int N,M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();
			N = sc.nextInt();
			M = sc.nextInt();
			
			System.out.printf("#%d %d\n",tc,pow(M)); //출력
		}//tc
	}//main
	
	//거듭제곱 구하는 메서드
	public static int pow(int M) {
		if(M == 1) {
			return N;
		}
		return N * pow(M-1);
	}
}