import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double[] scores = new double[N];
		double M = -1;
		
		for (int i = 0; i < N; i++) {
			scores[i] = sc.nextInt();
			M = Math.max(M, scores[i]);
		}
		
		//새로운 점수 구하기
		for (int i = 0; i < N; i++) {
			scores[i] = scores[i]/M*100;
		}
		
		double sum = 0;
		//새로운 평균 구하기
		for (int i = 0; i < N; i++) {
			sum += scores[i];
		}
		System.out.println(sum/N);
	}
}
