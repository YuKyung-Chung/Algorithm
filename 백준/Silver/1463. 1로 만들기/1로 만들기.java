import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		int[] dp = new int[N+1];
		
		BFS(N);
		
		System.out.println(cnt);
	}//main
	
	public static void BFS(int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		
		while(!q.isEmpty()) {
			int a = q.size();
			for (int i = 0; i < a; i++) {
				int now = q.poll();
				
				if(now == 1) return;
				
				if(now % 3 == 0) {
					if(now % 2 == 0) {
						q.add(now/3);
						q.add(now-1);
						q.add(now/2);
					}else if(now % 2 != 0) {
						q.add(now/3);
						q.add(now-1);
					}
				}else if(now % 2 == 0) {
					if(now % 3 == 0) {
						q.add(now-1);
						q.add(now/2);
						q.add(now/3);
					}else if(now % 3 != 0) {
						q.add(now/2);
						q.add(now-1);
					}
				}else if(now % 3 != 0 && now % 2 != 0) {
					q.add(now-1);
				}
			}
			cnt++;
		}
		
		
	}
}
