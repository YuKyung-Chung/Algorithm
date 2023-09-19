import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] answer = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Stack<Integer> s = new Stack<>();
		s.push(0);
		for (int i = 1; i < N; i++) {
			while(!s.isEmpty() && arr[s.peek()] < arr[i]) {
				answer[s.pop()] = arr[i];
			}
			s.push(i);
		}
		
		while(!s.isEmpty()) {
			answer[s.pop()] = -1;
		}
		
		for (int i = 0; i < N; i++) {
			sb.append(answer[i]).append(" ");
		}
		System.out.println(sb);
	}
}
