import java.util.Scanner;

public class Main {
	static int N;
	public static void main(String[] args) {
		//자릿수가 한개인 소수 2,3,5,7 에서 시작
		//이어서 현재수 * 10 + a를 계산하여 소수인지 판단
		//소수라면 재귀로 자릿수 하나 늘리기
		//a가 짝수인 경우 제외하기
		//자릿수 N까지 확장했을 때 그 값이 소수라면 해당 값 출력
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //자릿수 입력받기
		
		DFS(2,1);
		DFS(3,1);
		DFS(5,1);
		DFS(7,1);
		
	}
	
	public static void DFS(int num, int jarisu) {
		if(jarisu == N) {
			//소수이면 출력
			if(isPrime(num)) {
				System.out.println(num);
			}
			return;
		}
		
		
		for(int i=1; i<=9; i++) {
			//짝수이면 제외
			if(i % 2 == 0) {
				continue;
			}
			if(isPrime(num*10+i))
				DFS(num*10 + i, jarisu+1);
		}
	}
	
	//소수 판별 함수
	public static boolean isPrime(int num) {
		for(int i=2; i<=num/2; i++) 
			if(num % i == 0) 
				return false;
		return true;
	}
}
