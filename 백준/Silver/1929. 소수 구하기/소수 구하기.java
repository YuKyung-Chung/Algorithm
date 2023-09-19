import java.util.Scanner;

public class Main {
	static int M,N;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		sb = new StringBuilder();
		
		for (int i = M; i <= N; i++) {
			isPrime(i);
		}
		
		System.out.println(sb);
	}//main
	
	public static void isPrime(int num) {
		if(num == 1) return;
		
//		if(num == 2 || num == 3 || num == 5 || num == 7) {
//			sb.append(num+"\n");
//			return;
//		}
//		
//		//1이거나 짝수인 경우 리턴
//		if(num != 2 && num % 2 == 0) return;
		
		for (int i = 2; i <= (int) Math.sqrt(num); i++) {
			if(num % i == 0) return;
		}
		sb.append(num + "\n");
	}
}
