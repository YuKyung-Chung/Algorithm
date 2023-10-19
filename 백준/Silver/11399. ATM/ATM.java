import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class People implements Comparable<People>{
		int num, P;
		
		public People(int num, int P) {
			this.num = num;
			this.P = P;
		}

		@Override
		public int compareTo(People o) {
			return this.P - o.P;
		}
	}
	
	static int N;
	static int[] sum;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); //사람의 수
		sum = new int[N+1]; //누적합 저장할 배열
		PriorityQueue<People> pq = new PriorityQueue<>();
		
		for (int i = 1; i <= N; i++) {
			pq.add(new People(i,sc.nextInt()));
		}
		
		sum[1] = pq.poll().P;
		
		List<Integer> list = new ArrayList<>();
		while(!pq.isEmpty()){
			for (int i = 2; i <= N; i++) {
				People now = pq.poll();
				
				int num = now.num;
				int P = now.P;
				sum[i] = sum[i-1] + P;
			}
		}
		
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			answer += sum[i];
		}
		System.out.println(answer);
	}
}
