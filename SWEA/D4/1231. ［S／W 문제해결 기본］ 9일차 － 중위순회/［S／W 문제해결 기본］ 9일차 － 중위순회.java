
import java.util.Scanner;

public class Solution {
	static String[] arr;
	static int N;
	public static void main(String[] args)   {
		Scanner sc = new Scanner(System.in);
		
		tc: for (int tc = 1; tc <= 10; tc++) {
			N = sc.nextInt(); //정점 개수
			
			arr = new String[N+1];
			
			//배열에 값 저장
			for (int i = 1; i <= N; i++) {
				//왼쪽 오른쪽 자식 모두 있는 경우
				if(i*2 <= N && 2*i+1 <= N) {
					//입력 4개
					sc.next();
					String alphabet = sc.next();
					arr[i] = alphabet;
					sc.next();
					sc.next();
				}//왼쪽 자식만 있는 경우
				else if(i*2 <= N && i*2+1 > N) {
					//입력 3개
					sc.next();
					String alphabet = sc.next();
					arr[i] = alphabet;
					sc.next();
				}
				//자식 없는 경우
				else {
					//입력 2개
					sc.next();
					String alphabet = sc.next();
					arr[i] = alphabet;
				}
			}
			
			System.out.printf("#%d ", tc);
			inorder(1);
			System.out.println();
			
		} //tc
	} //main
	
	//중위순회하는 메서드
	public static void inorder(int i) {
		
		if(i <= N) {
			inorder(2*i);
			//공백이 아니면 출력
			if(arr[i] != null) {
				System.out.print(arr[i]);
			}
			inorder(2*i+1);
		}
		
	}
}
