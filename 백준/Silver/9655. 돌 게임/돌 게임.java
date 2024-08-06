import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		boolean[] win = new boolean[N+1];
		
		if(N>=1) win[1] = true; //상근 win
		if(N>=2) win[2] = false;
		if(N>=3) win[3] = true;
		if(N>=4) win[4] = false;
		
		for(int i=5; i<=N; i++) {
			win[i] = !win[i-1] || !win[i-3];
		}
		
		if(win[N]) System.out.println("SK");
		else System.out.println("CY");
	}
}
