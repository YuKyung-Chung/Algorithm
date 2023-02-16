import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        int[] R = new int[N];
        R[N - 1] = A[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            R[i] = Math.max(A[i], R[i + 1] + A[i]);
        }
        int[] L = new int[N];
        L[0] = A[0];
        int result = L[0];
        for (int i = 1; i < N; i++) {
            L[i] = Math.max(A[i], L[i - 1] + A[i]);
            result = Math.max(result, L[i]);
        }

        for (int i = 1; i < N-1; i++) {
            int temp = L[i - 1] + R[i + 1];
            result = Math.max(result, temp);
        }
        System.out.println(result);
    }
}
