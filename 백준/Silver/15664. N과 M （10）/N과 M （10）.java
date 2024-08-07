import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
	static int N,M;
	static int[] arr;
	static int[] sel;
	static boolean[] visited;
	static LinkedHashSet<String> set;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		sel = new int[M];
		visited = new boolean[N];
		set = new LinkedHashSet<>();
		
		perm(0,0);
		for(String val:set) {
			System.out.println(val);
		}
	}//main
	
	public static void perm(int idx, int depth) {
		//기저부분
		if(depth == M) {
			StringBuilder sb = new StringBuilder();
			for (int val : sel) {
				sb.append(val).append(" ");
			}
			set.add(sb.toString());
			sb.append("\n");
			return;
		}
//		if(idx == M) return;
						
		//재귀부분
		for (int i = idx; i < N; i++) {
			if(!visited[i]) {
				for(int j=0; j<=i; j++) {
					visited[j] = true;
				}
				sel[idx] = arr[i];
				perm(idx+1, depth+1);
				for(int j=i; j<N; j++) {
					visited[j] = false;
				}
			}
		}
	}//perm
}

