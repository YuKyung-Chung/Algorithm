import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        //감소하는 부분
        for (int i = 1; i <= N; i++) {
            //공백 부분
            for (int j = 1; j <= i - 1; j++) {
                System.out.print(" ");
            }
            //별 부분
            for (int j = 2 * N - 1; j >= 2 * i - 1; j--) {
                System.out.print("*");
            }

            System.out.println(" ");
        }

        //증가하는 부분
        for (int i = 1; i <= N - 1; i++) {
            //공백 부분
            for (int j = N-2; j >= i; j--) {
                System.out.print(" ");
            }
            //별 부분
            for (int j = 1; j <= 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }
}
