import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < n; i++) {
			int now = sc.nextInt();
			if(now >= max) {
				max = now;
			}
			if(now <= min) {
				min = now;
			}
		}
		
		System.out.println(min + " " + max);
	}
}
