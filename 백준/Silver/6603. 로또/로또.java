import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N = 6;
	static int K;
	static int[] temp, S;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean isTrue = true;
		while(isTrue) {
			K = sc.nextInt();
			if(K != 0) {
				S = new int[K];
				for (int i = 0; i < K; i++) {
					S[i] = sc.nextInt();
				}
				temp = new int[6];
				
				combination(0,0);
				System.out.println();
				
			}else {
				isTrue = false;
			}
		}
		
	}//main
	
	public static void combination(int cur,int idx) {
		if(idx == 6) {
			for (int i = 0; i < temp.length; i++) {
				System.out.print(temp[i] + " ");
			}
			System.out.println();
			return;
		}
		
		if(cur == K) return;
		
		temp[idx] = S[cur];
		combination(cur+1, idx+1);
		combination(cur+1, idx);
	}
}
