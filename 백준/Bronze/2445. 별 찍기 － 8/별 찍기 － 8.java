import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        //증가
        for(int i=1; i<=N; i++){
            //첫번째 별 부분
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            //두번째 공백 부분
            for (int j = N * 2 - 2; j > 2 * i - 2; j--) {
                System.out.print(" ");
            }
            //세번째 별 부분
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        //감소
        for(int i=1; i<=N-1; i++){
            //첫번째 별 부분
            for (int j = N-1; j >= i; j--) {
                System.out.print("*");
            }
            //두번째 공백 부분
            for (int j = 1; j <= i * 2; j++) {
                System.out.print(" ");
            }
            //세번째 별 부분
            for (int j = N-1; j >= i; j--) {
                System.out.print("*");
            }

            System.out.println("");
        }
    }
}
