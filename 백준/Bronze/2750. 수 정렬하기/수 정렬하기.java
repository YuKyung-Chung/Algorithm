import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i=0; i<N; i++){
            int temp = sc.nextInt();
            A[i] = temp;
        }
        Arrays.sort(A);
        for(int i=0; i<N; i++){
            sb.append(A[i]).append("\n");
        }
        System.out.print(sb);
    }
}