import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int min = 0; //최대값으로 초기화

		for(int i=0; i<N; i++) {
			int number = i;
			int sum = 0;
			
			while(number != 0) {
				//각 자릿수의 합 구하기
				sum += number % 10;
				number /= 10;
			}
			
			//i값과 각 자릿수 누적합이 같은 경우
			if(sum + i == N) {
				min = i;
				break;
			}
			
		}
		System.out.println(min);
		
	}
}
