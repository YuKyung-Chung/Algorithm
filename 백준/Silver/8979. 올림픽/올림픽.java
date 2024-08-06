import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //국가의 수
		int K = sc.nextInt(); //등수 알고싶은 국가
		
		int[][] medals = new int[N+1][4]; // [국가 번호][금, 은, 동, 순위]
		
		for(int i=1; i<=N; i++) {
			int country = sc.nextInt();
			medals[country][0] = country; // 국가 번호
            medals[country][1] = sc.nextInt(); // 금메달 수
            medals[country][2] = sc.nextInt(); // 은메달 수
            medals[country][3] = sc.nextInt(); // 동메달 수
		}
		
		int rank = 1;
		for(int i=1; i<=N; i++) {
			if(i == K) continue;
			
			//비교대상보다
			if((medals[i][1] > medals[K][1]) || //금메달 수가 더 많거나
				(medals[i][1] == medals[K][1] && medals[i][2] > medals[K][2]) || //은메달 수가 더 많거나
				(medals[i][1] == medals[K][1] && medals[i][2] == medals[K][2] && medals[i][3] > medals[K][3])) //동메달 수가 더 많으면
				rank++;
		}
		
		System.out.println(rank);
	}
}
