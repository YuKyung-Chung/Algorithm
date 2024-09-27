import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //맵 길이
		int M = sc.nextInt(); //주사위 던진 횟수
		
		int[] map = new int[N+1];
		for(int i=1; i<=N; i++) {
			map[i] = sc.nextInt();
		}
		
		int now = 1; //시작 지점
		int result = 0;
		for(int i=1; i<=M; i++) {
			int dice = sc.nextInt();
			
			now = now + dice;
			if(now >= N) {
				result = i;
				break;
			}
			now = now + map[now];
			if(now < 1) {
				now = 1;
			}
			if(now >= N) {
				result = i;
				break;
			}		
		}
		System.out.println(result);
	}//end of main
}
