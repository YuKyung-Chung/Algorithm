import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		for(int i=0; i<10; i++) {
			arr[i] = sc.nextInt();
		}
		int sum = 0;
		for(int i=0; i<10; i++) {
			int midSum = sum+arr[i];
			if(100 - midSum >= 0)
				sum += arr[i];
			else {
				if(midSum - 100 <= 100 - sum) {
					sum += arr[i];
					break;
				} 
				else
					break;
			}
		}
		System.out.println(sum);
}
}
