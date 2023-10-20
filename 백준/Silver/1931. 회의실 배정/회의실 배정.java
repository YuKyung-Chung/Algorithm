import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Rooms implements Comparable<Rooms>{
		int st, ed;
		
		public Rooms(int st, int ed) {
			this.st = st;
			this.ed = ed;
		}
		
		//끝나는 시간 순서대로 오름차순 정렬
		@Override
		public int compareTo(Rooms o) {
			if(this.ed == o.ed) {
				return this.st - o.st;
			}
			return this.ed - o.ed;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		PriorityQueue<Rooms> q = new PriorityQueue<>();
		//회의실 정보 입력받기
		for (int i = 0; i < N; i++) {
			q.add(new Rooms(sc.nextInt(), sc.nextInt()));
		}
		
		int cnt = 1;
		Rooms now = q.poll();
//		System.out.println(now.st);
		while(!q.isEmpty()) {
			Rooms r = q.poll();
//			System.out.println(r.st);
			//그 다음 회의 시작시간이 끝나는 시간 이후이면 가능
			if(r.st >= now.ed) {
				cnt++;
				now = r; //현재 회의내용 갱신
//				System.out.println(now.ed);
			}
			
		}
		System.out.println(cnt);
	}//main
	
}
