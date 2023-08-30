
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int N, min, R;
	static int[][] arr;
	static boolean[] sel;
	static int[] A;
	static int[] B;
	static int aSum, bSum, sum;
	
	public static void main(String[] args)   {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); //식재료의 수
			min = Integer.MAX_VALUE; //맛이 최소가 되는 값 저장하는 변수
			R = N/2; //한 음식 당 골라야 할 식재료 개수
			sel = new boolean[N];
			A = new int[R];
			B = new int[R];
			
			arr = new int[N][N];
			//시너지 배열 입력받음
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			combination(0,0);
			
			System.out.printf("#%d %d\n",tc,min); //출력
			
		}//tc
	}//main
	
	public static void combination(int idx, int aidx) {
		if(aidx == R) {
			//나머지 반은 B에 저장
			int bidx = 0;
			for (int i = 0; i < N; i++) {
				if(!sel[i]) {
					B[bidx] = i;
					bidx++;
				}
			}

			aSum = 0;
			bSum = 0;
			//2개 뽑기
			for (int i = 0; i < R-1; i++) {
				for (int j = i+1; j < R; j++) {
					aSum += arr[A[i]][A[j]] + arr[A[j]][A[i]];
					bSum += arr[B[i]][B[j]] + arr[B[j]][B[i]];
					
				}
			}
			min = Math.min(min, Math.abs(aSum-bSum));
			return;
		}
		
		//R개씩 뽑는 조합
		for (int i = idx; i <= N-R+aidx; i++) {
			A[aidx] = i;
			sel[i] = true;
			combination(i+1, aidx+1);
			sel[i] = false;
		}
		
	} //combination
}
