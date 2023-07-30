import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i=1; i<=N; i++){
            //증가

            //공백
            for (int j = N - 1; j >= i; j--) {
                System.out.print(" ");
            }
            //별
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println("");

        }
        for (int k = 1; k <= N - 1; k++) {
            //감소
            //공백
            for (int j = 1; j <= k; j++) {
                System.out.print(" ");
            }
            //별
            for (int j = 2 * (N-1) - 1; j >= 2 * k - 1; j--) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
