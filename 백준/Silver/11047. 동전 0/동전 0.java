import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		List<Integer> coins = new ArrayList<Integer>();
		
		for (int i = 0; i < N; i++) {
			coins.add(sc.nextInt());
		}
		
		Collections.reverse(coins); //내림차순 정렬
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int now = coins.get(i); //현재 고려할 동전
			
			if(K==0) break;
			
			if(now <= K) {
				cnt = cnt + (K / now); //동전 개수
				K = K % now; //잔돈 갱신
			}
		}
		
		System.out.println(cnt);
		
	}//main
}
