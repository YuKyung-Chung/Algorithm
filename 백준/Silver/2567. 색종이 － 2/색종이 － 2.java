import java.util.Scanner;

public class Main {
	
	static int[][] arr = new int[101][101];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //색종이 개수
		
		for(int i=0; i<N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			// 색종이의 10x10 영역을 채운다.
            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    arr[j][k] = 1;
                }
            }
		}
		
		int count = 0;
		//둘레 계산하기
		for(int i=0; i<101; i++) {
			for(int j=0; j<101; j++) {
				if(arr[i][j] == 1) {
					//상하좌우가 빈칸이면 둘레에 포함
					if(i==0 || arr[i-1][j] == 0) count++; //위쪽
					if(i==100 || arr[i+1][j] == 0) count++; //아래쪽
					if(j==0 || arr[i][j-1] == 0) count++; //왼쪽
					if(j==100 || arr[i][j+1] == 0) count++; //오른쪽
				}
			}
		}
		
		System.out.println(count);
		
	}//end of main	
}
