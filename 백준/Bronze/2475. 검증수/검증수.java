import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] numbers = new int[5];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = sc.nextInt();
		}
		
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum += Math.pow(numbers[i],2);
		}
//		System.out.println(sum);
		System.out.println(sum%10);
	}
}
