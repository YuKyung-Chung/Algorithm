import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //총 색종이 수
		int[][] arr = new int[101][101];
		int count = 0; //넓이 저장 변수
		
		//arr 배열 0으로 초기화
		for(int i=0; i<101; i++) {
			for(int j=0; j<101; j++) {
				arr[i][j] = 0;
			}
		}
		
		
		for(int k=0; k<T; k++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			for(int i=a; i<a+10; i++) {
				for(int j=b; j<b+10; j++) {
					if(arr[i][j] != 1) {
						arr[i][j] = 1;
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}
}
