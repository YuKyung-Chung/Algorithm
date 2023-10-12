import java.util.Scanner;

public class Solution {
	static int N,M,C,answer;
	static int[][] arr,selected;
	static boolean[][] visited;
	static int[] max = new int[3];
	
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //테스트 케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); //벌통 크기
			M = sc.nextInt(); //선택할 수 있는 벌통 개수
			C = sc.nextInt(); //꿀 채취할 수 있는 최대 양
			answer = 0; //최대 수익 저장할 변수
			selected = new int[N][N];
			
			arr = new int[N][N];
			//벌꿀 배열 입력받기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			visited = new boolean[N][N];
			find(1,0);
			
			System.out.printf("#%d %d\n",tc,answer);
		}//tc
		
	}//main
	
	public static void find(int cnt,int idx) {
		//벌통이 2개 선택되었으면
		if(cnt == 3) {
			//최댓값 초기화
			max[1] = max[2] = 0;
			//최댓값 찾기
			setMax();
			//최댓값 갱신
			answer = Math.max(answer, max[1] + max[2]);
			return;
		}
		
		int r = idx/N;
		int c = idx%N;
		
		//그래프 끝에 도달하면 
		if(idx>=N*N) return;
		
		//벌통 2개 선택하기
		//그래프 넘어가면 다음 행으로
		if(c + M > N) {
			find(cnt, idx+M -(idx+M)%N);
		}else {
			//선택하고 다음 팀 고르기
			select(cnt,r,c);
			find(cnt+1,idx+M);
			select(cnt,r,c);
			//선택하지 않고 다음 칸에서 현재 팀 고르기
			find(cnt,idx+1);
		}
		
	}//find
	
	public static void select(int cnt, int r, int c) {
		for (int i = 0; i < M; i++) {
			//select 설정
			if(selected[r][c+i] == 0) {
				selected[r][c+i] = cnt;
			}
			//select 해제
			else {
				selected[r][c+i] = 0;
			}
		}
	}
	
	public static void setMax() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(selected[i][j] == 1) {
					if(max[1] != 0) continue;
					combination(1,i,j,0,0);
				}
				else if(selected[i][j] == 2) {
					if(max[2] != 0) continue;
					combination(2,i,j,0,0);
				}
			}
		}
	}
	
	public static void combination(int cnt, int r, int c, int sum, int cost) {
		if(sum > C) {
			return;
		}
		
		max[cnt] = Math.max(max[cnt],cost);
		
		if(c>=N) return;
		if(selected[r][c] != cnt) return;
		
		combination(cnt, r, c+1, sum+arr[r][c], cost+arr[r][c]*arr[r][c]);
		combination(cnt, r, c+1, sum, cost);
		
	}
}
