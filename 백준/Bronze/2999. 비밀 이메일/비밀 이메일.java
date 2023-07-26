import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		int N = str.length();
		
		int R = 0;
		int C = 0;
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i*j == N && i<=j) {
					R = i;
					C = j;
				}
			}
		}
		
		String[] words = str.split("");
		int k = 0;
		String[][] arr = new String[R][C];
		for(int i=0; i<C; i++) {
			for(int j=0; j<R; j++) {
				
				arr[j][i] = words[k++];
			}
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(arr[i][j]);
			}
		}
	}
}
