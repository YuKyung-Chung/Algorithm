
import java.util.Scanner;

public class Solution {
	public static int N,L, maxScore;
	public static int[] score;
	public static int[] calorie;
	
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //테스트 케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); //점수
			L = sc.nextInt(); //제한 칼로리
			maxScore = 0;
			
			score = new int[N]; //점수 저장 배열
			calorie = new int[N]; //칼로리 저장 배열
			
			//각각의 배열에 값 저장
			for (int i = 0; i < N; i++) {
				score[i] = sc.nextInt();
				calorie[i] = sc.nextInt();
			}

			diet(0,0,0);
			
			System.out.printf("#%d %d\n",tc,maxScore);
		}//tc
	}//main
	
	public static void diet(int idx, int calsum, int scoresum) {
		//마지막까지 탐색 시 비교
		if(idx == N) {
			if(scoresum > maxScore && calsum < L) maxScore = scoresum;
			return;
		}
		
		diet(idx+1, calsum+calorie[idx], scoresum+score[idx]); //뽑았을 때
		diet(idx+1, calsum, scoresum); //안뽑았을 때
	}
}
