import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		
		for (int i = 0; i < n; i++) {
			int score = 0;
			int now = 0;
			String str = sc.next();
			
			for (int j = 0; j < str.length(); j++) {
				if(str.substring(j,j+1).equals("X")) {
					now = 0;
				} else if(str.substring(j,j+1).equals("O")) {
					now += 1;
					score = score+now;
				}
			}
			System.out.println(score);
		}
	}
}
