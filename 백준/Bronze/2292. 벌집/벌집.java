import java.util.Scanner;

public class Main {
	static int answer = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		find(N, 1, 1);
		System.out.println(answer);
	}
	
	private static void find(int N, int now, int multiple) {
		if(N == 1) {
			answer = 1;
			return;
		}
		
		if(N > now + (6 * multiple)) {
			int what = now + (6 * multiple);
			find(N, what, multiple+1);
		}else {
			answer = multiple+1;
		}
	}
}
