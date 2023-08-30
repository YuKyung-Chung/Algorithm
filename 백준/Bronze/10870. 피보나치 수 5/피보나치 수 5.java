import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] num = new int[21];
		num[0] = 0;
		num[1] = 1;
		
		for (int i = 2; i <= N; i++) {
			num[i] = num[i-1] + num[i-2];
		}
		System.out.println(num[N]);
	}
}