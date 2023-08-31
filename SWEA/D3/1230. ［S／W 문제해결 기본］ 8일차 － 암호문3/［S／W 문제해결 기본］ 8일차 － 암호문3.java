
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args)   {
		Scanner sc = new Scanner(System.in);
		
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt(); //원본 암호문 개수
			
			List<Integer> list = new LinkedList<>();
			
			//원본 암호문 저장
			for (int i = 0; i < N; i++) {
				list.add(sc.nextInt());
			}
			
			int M = sc.nextInt(); //명령어 개수
			
			for (int i = 0; i < M; i++) {
				String order = sc.next();
				//데이터 삽입
				//앞에서부터 x번째 암호문 바로 다음에 y개의 암호문을 삽입
				if(order.equals("I")) {
					int x = sc.nextInt();
					int y = sc.nextInt();
					
					for (int j = 0; j < y; j++) {
						list.add(x+j, sc.nextInt());
					}
				} 
				//데이터 삭제
				//앞에서부터 x번째 암호문 바로 다음부터 y개의 암호문을 삭제
				else if(order.equals("D")) {
					int x = sc.nextInt();
					int y = sc.nextInt();
					
					for (int j = 0; j < y; j++) {
						list.remove(x+j);
					}
				}
				//데이터 추가
				//맨 뒤에 y개의 암호문을 덧붙인다
				else if(order.equals("A")) {
					int x = sc.nextInt();
					
					for (int j = 0; j < x; j++) {
						list.add(sc.nextInt());
					}
				}
			}
			
			System.out.printf("#%d ",tc);
			for(int i=0; i<10; i++) {
				int ans = list.get(i);
				System.out.print(ans+" ");
			}
//			for (int i = 0; i < list.size(); i++) {
//				System.out.print(list.get(i) + " ");
//			}
			System.out.println();
			
		}//tc
	}//main
}
