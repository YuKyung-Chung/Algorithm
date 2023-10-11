import java.util.Scanner;

public class Main {
	static int N,cnt;
	static int[][] arr;
	static int[] dx = {0,1,1}; //오른쪽 아래 대각선아래
	static int[] dy = {1,0,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		//d=방향  1:가로 2:세로 3:대각선
		DFS(0,1,1);
		
		System.out.println(cnt);
	}//main
	
	public static void DFS(int x, int y, int d) {
		//파이프가 끝에 도달하면 방법 수 증가
		if(x == N-1 && y == N-1) {
			cnt++;
			return;
		}
		
		//가로 방향이면
		if(d==1) {
			//그 다음 칸도 가로 방향인 경우
			//벽이 있는지, 경계조건 확인
			int nx = dx[0] + x;
			int ny = dy[0] + y;
			
			if(nx>=0 && ny>=0 && nx<N && ny<N && arr[nx][ny] != 1) {
				DFS(nx,ny,1);
			}
			
			//그 다음 칸은 대각선 방향인 경우
			int nx2 = dx[2] + x;
			int ny2 = dy[2] + y;
			
			if(nx2>=0 && ny2>=0 && nx2<N && ny2<N && arr[x+1][y] != 1 && arr[x][y+1] != 1 && arr[nx2][ny2] != 1) {
				DFS(nx2,ny2,3);
			}
		}
		//세로 방향이면
		else if(d==2) {
			//그 다음 칸도 세로 방향인 경우
			int nx = dx[1] + x;
			int ny = dy[1] + y;
			
			if(nx>=0 && ny>=0 && nx<N && ny<N && arr[nx][ny] != 1) {
				DFS(nx,ny,2);
			}
			
			//그 다음 칸은 대각선 방향인 경우
			int nx2 = dx[2] + x;
			int ny2 = dy[2] + y;
			
			if(nx2>=0 && ny2>=0 && nx2<N && ny2<N && arr[x+1][y] != 1 && arr[x][y+1] != 1 && arr[nx2][ny2] != 1) {
				DFS(nx2,ny2,3);
			}
		} 
		//대각선 방향이면
		else if(d==3) {
			//그 다음 칸 가로 방향
			int nx = dx[0] + x;
			int ny = dy[0] + y;
			
			if(nx>=0 && ny>=0 && nx<N && ny<N && arr[nx][ny] != 1) {
				DFS(nx,ny,1);
			}
			
			//그 다음 칸 세로 방향
			int nx2 = dx[1] + x;
			int ny2 = dy[1] + y;
			
			if(nx2>=0 && ny2>=0 && nx2<N && ny2<N && arr[nx2][ny2] != 1) {
				DFS(nx2,ny2,2);
			}
			
			//그 다음 칸 대각선 방향
			int nx3 = dx[2] + x;
			int ny3 = dy[2] + y;
			
			if(nx3>=0 && ny3>=0 && nx3<N && ny3<N && arr[x+1][y] != 1 && arr[x][y+1] != 1 && arr[nx3][ny3] != 1) {
				DFS(nx3,ny3,3);
			}
		}
		
	}//BFS
}
