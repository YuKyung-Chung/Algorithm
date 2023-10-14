
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static class People{
		int r,c;
		
		public People(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
	static class Stairs{
		int r,c,val;
		
		public Stairs(int r, int c, int val) {
			this.r = r;
			this.c = c;
			this.val = val;
		}
	}
	
	static int N;
	static int[][] arr;
	static List<Stairs> stairs;
	static List<People> people;
	static int[] info;
	static int answer, max;
	
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			arr = new int[N][N];
			//지도 입력받기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			stairs = new ArrayList<>();
			people = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					//계단 정보 입력받기
					if(arr[i][j] != 1 && arr[i][j] != 0) {
						stairs.add(new Stairs(i,j,arr[i][j]));
					}
					//사람 정보 입력받기
					if(arr[i][j] == 1) {
						people.add(new People(i,j));
					}
				}
			}
			answer = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			
			info = new int[people.size()+1]; //계단 정보
			
			//조합을 통해 어떤 사람이 어떤 계단을 내려갈지 정하기
			comb(0);
			
			System.out.printf("#%d %d\n",tc,answer);
		}//tc
	}//main
	
	public static void comb(int cnt) {
		
		if(cnt >= people.size()) {
			max = calc();
			answer = Math.min(answer, max);
			return;
		}
		
		for(int i=0; i<2; i++) {
			info[cnt] = i;
			comb(cnt+1);
		}
		
	}
	//계산
	public static int calc() {
		List<Integer> people1 = new ArrayList<Integer>();
		List<Integer> people2 = new ArrayList<Integer>();
		
		for (int i = 0; i < people.size(); i++) {
			Stairs s = stairs.get(info[i]);
			int d = Math.abs(s.c - people.get(i).c) + Math.abs(s.r - people.get(i).r)+1;
			if(info[i] == 0) {
				people1.add(d);
			}
			else if(info[i] == 1) {
				people2.add(d);
			}
		}
		//가까운 순으로 정렬
		Collections.sort(people1);
		Collections.sort(people2);
		
		//한 계단 씩 사람들 내려보내면서 모든 사람들이 내려가는 최소 시간 찾기
		int val1 = Down(people1, stairs.get(0));
		int val2 = Down(people2, stairs.get(1));
		
		return val1>val2?val1:val2;
	}
	
	public static int Down(List<Integer> people, Stairs s) {
		if(people.size() == 0) return 0;
		for (int i = 0; i < people.size(); i++) {
			if(i<3) {
				people.set(i,people.get(i)+s.val);
			}
			else {
				int bef = people.get(i-3);
				if(bef > people.get(i)) {
					people.set(i,bef+s.val);
				}else {
					people.set(i, people.get(i)+s.val);
				}
			}
		}
		return people.get(people.size()-1);
	}
	
}
