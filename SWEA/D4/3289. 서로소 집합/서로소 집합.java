import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	static int[] p;
	
	public static void main(String[] args)   {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			int N = sc.nextInt();
			int M = sc.nextInt();
			p = new int[N+1];
			
			//makeSet
			for (int i = 1; i <= N; i++) {
				p[i] = i;
			}
			
			for (int i = 0; i < M; i++) {
				int order = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				//부모 찾기
				int px = find(p[a]); 
				int py = find(p[b]);
				
				//union
				if(order == 0) {
					union(px,py);
				} 
				//find
				else if(order == 1) {
					if(px != py) {
						sb.append(0);
					} else {
						sb.append(1);
					}
				}

			}
			System.out.printf("#%d %s\n",tc,sb);
		}//tc
	}//main
	
	public static void union(int x, int y) {
		p[y] = x;
	}
	
	public static int find(int x) {
		if (x != p[x])
			p[x] = find(p[x]);
		return p[x];
	}
}
