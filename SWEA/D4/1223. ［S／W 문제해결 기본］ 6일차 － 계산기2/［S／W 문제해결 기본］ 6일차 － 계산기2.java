
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static int top;
	public static int[] stackN;
	public static char[] stackC;
	
	public static boolean isEmpty() {
		return top == -1;
	}
	
	public static boolean isFull() {
		return top == stackC.length -1;
	}
	
	public static void push(char ch) {
		//가득 차있는지 확인
		if(isFull()) {
			return;
		}
		stackC[++top] = ch;
	}
	
	public static char pop() {
		//비어있는지 확인
		if(isEmpty()) {
			return 0;
		}
		return stackC[top--];
	}
	
	public static char peek() {
		if(isEmpty()) {
			return 0;
		}
		return stackC[top];
	}
	
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		
		//연산자 우선순위 부여
		Map<Character, Integer> priority = new HashMap<>();
		priority.put('+', 1);
		priority.put('*', 2);
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt(); //계산식 길이
			String inorder = sc.next(); //중위 계산식 입력받음
			String postorder = "";
			
			//1. 중위 -> 후위 계산식
			top = -1;
			stackC = new char[N];
			for (int i = 0; i < N; i++) {
				char ch = inorder.charAt(i);
				//피연산자면 그대로 출력
				if(ch - '0' >= 0 && ch -'0' <= 9) {
					postorder += ch;
				}
				//계산식일 경우 (우선순위 고려하기)
				else {
					//스택 비어있으면 푸시
					if(isEmpty()) {
						push(ch);
					}
					else {
						//우선순위 낮으면 스택에 추가
						if(priority.get(peek()) < priority.get(ch)) {
							push(ch);
						}
						//우선순위 낮을때까지 pop하고 그 후에 push
						else {
							while(!isEmpty() && priority.get(peek()) >= priority.get(ch)) {
								postorder += pop();
							}
							push(ch);
						}
					}
					
				}
			}
            //스택에 남아있는거 몽땅 출력
			while(!isEmpty()) {
				postorder += pop();
			}
			
			//2. 후위 -> 스택으로 계산하기
			top = -1;
			stackN = new int[N];
			for (int i = 0; i < N; i++) {
				char ch = postorder.charAt(i);
				//피연산자라면 스택에 푸시
				if(ch -'0' >= 0 && ch -'0' <= 9) {
					stackN[++top] = ch - '0';
				}
				//연산자라면
				else {
					int b = stackN[top--];
					int a = stackN[top--];
					int cal = 0;
					if(ch == '*') cal = a*b;
					else if(ch == '+') cal = a+b;
					
					stackN[++top] = cal; //연산결과 다시 푸시
				}
			}
			
			int result = stackN[top--];
			
			System.out.printf("#%d %d\n", tc, result);
			
		} //tc
	}//main
}
