import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		int count = 0;
		for(int i=0; i<N; i++) {
			int start = 0;
			int end = N-1;
			
			while(start != end) {
				//자신을 제외한 두 수의 합을 확인해야 하므로 i는 건너뛰어야 함
				if(start == i) {
					start++;
					continue;
				}
				if(end == i) {
					end--;
					continue;
				}
				
				//두 수의 합이 현재 숫자와 같으면 좋은 수 
				if(arr[start] + arr[end] == arr[i]) {
						count++;
						break;
				} else if(arr[start] + arr[end] < arr[i]) {
					start++;
				} else {
					end--;
				}
			}
		}
		
		System.out.println(count);
		
	}
}
