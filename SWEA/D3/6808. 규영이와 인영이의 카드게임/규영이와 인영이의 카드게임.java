
import java.util.Scanner;

public class Solution {
	static int[] gy;
	static int[] yy;
	static boolean[] visited;
	static int gyWinCount;
	static int gyLoseCount;
	static int[] cards;
	static int[] yyperm;
	
	public static void main(String[] args)   {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //테스트 케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			cards = new int[19]; //카드 총 개수
			
			gy= new int[9]; //규영이가 내는 카드 저장 배열
			for (int i = 0; i < 9; i++) {
				gy[i] = sc.nextInt();
			}
			
			for (int i = 0; i < gy.length; i++) {
				cards[gy[i]]++;
			}
		
			
			yy = new int[9];
			yyperm = new int[9];
			int idx = 0;
			for (int i = 1; i < cards.length; i++) {
				if(cards[i] == 0) {
					yy[idx++] = i;
				}
			}
			
			gyWinCount = 0;
			gyLoseCount = 0;
			visited = new boolean[9];
			
			perm(0);
			
			System.out.printf("#%d %d %d\n",tc,gyWinCount,gyLoseCount);
			
		}//tc
	}//main
	
	public static void perm(int idx) {
		int gyWinSum=0;
		int yyWinSum=0;
		//9장 뽑으면 종료
		if(idx == 9) {
			//아홉라운드 게임 진행
			for (int i = 0; i < 9; i++) {
				//규영이가 이기면
				if(gy[i] > yyperm[i]) {
					gyWinSum += (gy[i] + yyperm[i]);
				}
				//인영이가 이기면
				else if(gy[i] < yyperm[i]) {
					yyWinSum += (gy[i] + yyperm[i]);
				}
			}
			//승자 정하기
			//규영이가 승자일때
			if(gyWinSum > yyWinSum) {
				gyWinCount++;
			}
			//인영이가 승자일때
			else if(gyWinSum < yyWinSum) {
				gyLoseCount++;
			}
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if(visited[i]) continue;
			
			yyperm[idx] = yy[i];
			visited[i] = true;
			perm(idx+1);
			visited[i] = false;
		}
		
	}
}
