import java.util.Scanner;

public class Solution {
	public static int top;
	public static char[] stack;
	public static int[] stack2;
	
	//isEmpty
	public static boolean isEmpty() {
		return top == -1;
	}
	
	//isFull
	public static boolean isFull() {
		return top == stack.length-1;
	}
	
	//push
	public static void push(char ch) {
		//가득 찼는지 확인
		if(isFull()) {
			return;
		}
		stack[++top] = ch;
	}
	
	//pop
	public static char pop() {
		//비었는지 확인
		if(isEmpty()) {
			return 0;
		}
		return stack[top--];
	}
	
	
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt(); //계산식 길이
			String inorder = sc.next(); //중위계산식 입력 받음
			String postorder = "";
			
			//1. 중위 -> 후위 계산식
			top = -1;
			stack = new char[N];
			for (int i = 0; i < N; i++) {
				char tmp = inorder.charAt(i);
				//피연산자일 경우 그대로 출력
				if(tmp -'0' >= 0 && tmp -'0' <= 9) {
					postorder += tmp;
				}
				//연산자일 경우 (+만 존재)
				else {
					if(isEmpty()) {
						push(tmp);
					}
					else {
						postorder += pop();
						push(tmp);
					}
				}
			}
			//스택이 빌때까지 pop해서 후위계산식에 추가
			while(!isEmpty()) {
				postorder += pop();
			}
			
			//2. 후위 계산식 -> 계산하기
			top = -1;
			stack2 = new int[N];
			
			for (int i = 0; i < N; i++) {
				char tmp = postorder.charAt(i);
				//피연산자이면
				if(tmp -'0' >= 0 && tmp-'0' <=9) {
					stack2[++top] = tmp - '0';
				}
				//연산자라면
				else {
					//순서 중요!!!!!!
					int b = stack2[top--];
					int a = stack2[top--];
					int sum = a+b;
					stack2[++top] = sum; //연산결과 다시 푸시
				}
			}
			int result = stack2[top--];
			
			System.out.printf("#%d %d\n", tc, result);
		}//tc
		
	}//main
}
