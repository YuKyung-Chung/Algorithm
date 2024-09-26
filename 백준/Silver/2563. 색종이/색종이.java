import java.util.Scanner;

public class Main {
	static int[][] arr = new int[101][101];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //색종이 수
		
		for(int i=0; i<N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			checkArea(x,y);
		}
		
		int area = 0; //겹치는 부분 카운트 변수
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(arr[i][j] == 1)
					area++;
			}
		}
		
		System.out.println(area);
	}//end of main
	
	//겹치는 영역 체크
	public static void checkArea(int x, int y) {
		for(int i = x; i < x+10; i++) {
			for(int j = y; j < y+10; j++) {
				arr[i][j] = 1;
			}
		}
	}
}
