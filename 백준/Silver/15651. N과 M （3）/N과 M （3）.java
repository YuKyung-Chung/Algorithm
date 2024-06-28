import java.util.Scanner;

public class Main {
	//1부터 N까지 자연수 중 M개 고른 수열
	//같은 수 중복 가능
	static int[] selected;
	static StringBuilder sb;
	static int N,M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		selected = new int[M];
		sb = new StringBuilder();
		
		perm(0);
		System.out.println(sb);	
	}
	public static void perm(int depth) {
		if(depth == M) {
			for(int val : selected) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			selected[depth] = i+1;
			perm(depth+1);
		}
	}
}
