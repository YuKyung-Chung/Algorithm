import java.util.Scanner;

public class Main {
	static int[] p;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		p = new int[N+1];
		
		//makeset
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}
		
		for (int i = 0; i < M; i++) {
			int order = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int pa = find(p[a]);
			int pb = find(p[b]);
			
			if(order == 0) {
				union(pa,pb);
			} else if(order == 1) {
				if(pa != pb) {
					System.out.println("NO");
				}else
					System.out.println("YES");
			}
		}
		
	}//main
	
	public static void union(int x, int y) {
		p[y] = x;
	}
	
	public static int find(int x) {
		if(p[x] != x) {
			p[x] = find(p[x]);
		}
		
		return p[x];
	}
}
