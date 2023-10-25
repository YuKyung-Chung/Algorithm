import java.util.Scanner;

public class Main {
	static int N, S, answer;
	static int[] num;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		
		num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		
		dfs(0,0);
		
		//공집합일때 0인경우 하나 제외
		if(S==0)
			System.out.println(answer-1);
		else
			System.out.println(answer);
		
	}//main
	
	public static void dfs(int depth,int sum) {
		if(depth==N) {
			if(sum==S) answer++;
			return;
		}
		
		dfs(depth+1, sum+num[depth]);
		dfs(depth+1, sum);
	}
}
