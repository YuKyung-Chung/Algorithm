import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();//재료개수
		int M = sc.nextInt(); //필요한 수
		int[] in = new int[N];
		
		for(int i=0; i<N; i++) {
			in[i] = sc.nextInt();
		}
		Arrays.sort(in); //오름차순 정렬
		
		int start = 0;
		int end = in.length-1;
		int count = 0;
		
		while(start != end) {
			if(in[start] + in[end] == M) {
				count++;
				start++;
			}
			else if(in[start] + in[end] < M) {
				start++;
			} else if(in[start] + in[end] > M) {
				end--;
			}
		}
		System.out.println(count);
		
	}
}
