import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int a = sc.nextInt();

		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		int b = sc.nextInt();
		
		for(int i=-999; i<=999; i++) {
			for(int j=-999; j<=999; j++) {
				if((x1 * i + y1*j == a) && (x2*i + y2*j == b)) {
					System.out.println(i+" "+j);
				}
			}
		}
	}
}
