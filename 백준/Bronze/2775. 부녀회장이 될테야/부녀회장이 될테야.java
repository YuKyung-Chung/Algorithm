import java.util.*;
public class Main {
    static int T;
    static int[][] D;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        D = new int[15][15];
        for (int i = 0; i < 15; i++) {
            D[i][1] = 1;
            D[0][i] = i;
        }
        
        for (int i = 1; i < 15; i++) {
            for (int j = 2; j < 15; j++) {
                D[i][j] = D[i - 1][j] + D[i][j - 1];
            }
        }
        
        for (int i = 0; i < T; i++) {
            int K = sc.nextInt();
            int N = sc.nextInt();
            System.out.println(D[K][N]);
        }
    }
}