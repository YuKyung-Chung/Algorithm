import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] arr;
	static int[] comb; //조합 임시 저장 배열
	static int idx = 0;
	static int N = 7;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr= new int[9];
		comb = new int[7];
		
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		combination(0,0);
		System.out.println(sb);
		
	}//main
	
	public static void combination(int cur, int cidx) {
		int sum = 0;
		if(cidx == N) {
			for (int i = 0; i < comb.length; i++) {
				sum += comb[i];
			}
			if(sum == 100) {
				sb = new StringBuilder();
				for (int i = 0; i < comb.length; i++) {

					sb.append(comb[i]+"\n");
				}
			}
			return;
		}
		
		if(cur == arr.length) return;
		
		comb[cidx] = arr[cur];
		combination(cur+1, cidx+1);
		combination(cur+1, cidx);
		
		
	}
}
