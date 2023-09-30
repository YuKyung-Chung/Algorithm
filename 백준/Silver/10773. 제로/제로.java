import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < K; i++) {
			int now = sc.nextInt();
			if(now == 0) {
				stack.pop();
			}
			else if(now != 0){
				stack.add(now);
			}
		}
		int sum = 0;
		
		for (int i = 0; i < stack.size(); i++) {
			sum += stack.get(i);
		}
		
		System.out.println(sum);
	}
}
