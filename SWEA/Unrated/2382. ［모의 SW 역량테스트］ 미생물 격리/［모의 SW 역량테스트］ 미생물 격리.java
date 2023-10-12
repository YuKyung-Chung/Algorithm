import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static class Cell implements Comparable<Cell>{
		int num,r,c,cnt,dir;
		
		//dir 1:상 2:하 3:좌 4:우
		public Cell(int num, int r, int c, int cnt, int dir) {
			this.num = num;
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.dir = dir;
		}
		
		@Override
		public int compareTo(Cell o) {
			if(this.num == o.num) {
				return this.cnt - o.cnt;
			}
			return this.num - o.num;
		}
	}
	
	static int N,M,K;
	static List<Cell> cells;
	static int[] dr = {-1,1,0,0}; //상하좌우
	static int[] dc = {0,0,-1,1};

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); //셀의 개수
			M = sc.nextInt(); //격리 시간
			K = sc.nextInt(); //군집 개수
			
			cells = new ArrayList<>();
			
			for (int i = 0; i < K; i++) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				int cnt = sc.nextInt();
				int dir = sc.nextInt();
				
				cells.add(new Cell(r*N+c, r,c,cnt,dir));
			}
			
			for (int time = 0; time < M; time++) {
				//이동
				for (int idx = 0; idx < cells.size(); idx++) {
					Cell cell = cells.get(idx);
					cell.r = dr[cell.dir-1] + cell.r;
					cell.c = dc[cell.dir-1] + cell.c;
					cell.num = (cell.r * N) + cell.c;
					
					
					//약품 처리된 구역이면
					//미생물 수 반으로 줄고 방향 바꾸기
					if(cell.r == 0 || cell.c == 0 || cell.r == N-1 || cell.c == N-1) {
						//미생물 수 반으로 줄이기
						cell.cnt = cell.cnt/2;
						
						//방향 바꾸기
						cell.dir = changeDir(cell.dir);
						
						if(cell.cnt == 0) {
							cells.remove(idx);
							idx--;
						}
					}
				}
				Collections.sort(cells);
				
				//이동 후 두 개 이상의 군집이 한 셀에 모이면 군집 합치기
				for (int idx = 0; idx < cells.size()-1; idx++) {
					Cell now = cells.get(idx);
					Cell next = cells.get(idx+1);
					
					if(now.num == next.num) {
						next.cnt = now.cnt + next.cnt;
						cells.remove(idx);
						idx--;
					}
					
				}
			}
			
			int total = 0;
			for (int i = 0; i < cells.size(); i++) {
				total += cells.get(i).cnt;
			}
			
			System.out.printf("#%d %d\n",tc,total);
		}//tc
	}//main
	
	
	public static int changeDir(int d) {
		if(d == 1) return 2;
		else if(d == 2) return 1;
		else if(d == 3) return 4;
		else if(d == 4) return 3;
		return -1;
	}
}
