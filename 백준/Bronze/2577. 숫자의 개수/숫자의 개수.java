import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int numbers = a*b*c;
		String str = Integer.toString(numbers);
		
		int[] count = new int[10];
		for (int i = 0; i < str.length(); i++) {
			count[Integer.valueOf(str.substring(i,i+1))]++;
		}
		
		for (int i = 0; i < count.length; i++) {
			System.out.println(count[i]);
		}
	}
}
