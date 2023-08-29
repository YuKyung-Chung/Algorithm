
import java.util.Scanner;

public class Solution {
	static char[][] flags;
	static int N,M;
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //테스트 케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); //행
			M = sc.nextInt(); //열
			
			flags = new char[N][M];
			//국기 모양 입력받기
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < M; j++) {
					flags[i][j] = str.charAt(j);
				}
			}
			int min = Integer.MAX_VALUE;
			
			//0에서 N-1까지 두개 수 뽑아서
			//첫번째 수는 W의 마지막행
			//두번째 수는 B의 마지막행
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N-1; j++) {
					int tmp = check(i,j);
					min = Math.min(tmp, min); //최솟값 갱신
				}
			}
			System.out.printf("#%d %d\n",tc,min);
		}//tc
	}//main
	
	public static int check(int a, int b) {
		int count = 0;
		//W 체크
		for (int i = 0; i <= a; i++) {
			for (int j = 0; j < flags[i].length; j++) {
				if(flags[i][j] != 'W') {
					count++;
				}
			}
		}
		
		//B 체크
		for (int i = a+1; i <= b; i++) {
			for (int j = 0; j < flags[i].length; j++) {
				if(flags[i][j] != 'B') {
					count++;
				}
			}
		}
		
		//R 체크
		for (int i = b+1; i < N; i++) {
			for (int j = 0; j < flags[i].length; j++) {
				if(flags[i][j] != 'R') {
					count++;
				}
			}
		}
		
		return count;
	}
}