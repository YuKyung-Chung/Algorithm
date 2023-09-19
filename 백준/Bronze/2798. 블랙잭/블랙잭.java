import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N,M, sum, answer, minSum;
	static int[] cards;
	static int[] temp; //임시 조합한 카드 저장할 배열
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		//합이 M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합 출력
		cards = new int[N];
		for (int i = 0; i < N; i++) {
			cards[i] = sc.nextInt();
		}
		
		temp = new int[3];
		visited = new boolean[N];
		answer=Integer.MAX_VALUE;
		minSum = Integer.MAX_VALUE;
		
		combination(0,0);
		System.out.println(answer);
	}
	
	public static void combination(int idx, int sidx) {
		sum = 0;
		
		if(sidx == 3) {
			for (int i = 0; i < temp.length; i++) {
				sum += temp[i];
			}
			
			if(sum <= M && Math.abs(sum-M) <= minSum) {
				minSum = Math.abs(sum-M);
				answer = sum;
			}
			return;
		}
		
		if(idx == N) return;
		
		temp[sidx] = cards[idx];
		combination(idx+1, sidx+1);
		combination(idx+1, sidx);
	}
}
