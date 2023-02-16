
import java.io.*;
import java.util.*;
public class Main {
    static char[] A;
    static char[] B;
    static long[][] dp;
    static ArrayList<Character> Path;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine().toCharArray();
        B = br.readLine().toCharArray();

        dp = new long[A.length + 1][B.length + 1];
        Path = new ArrayList<>();
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i-1] == B[j-1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[A.length][B.length]);
        getText(A.length, B.length);
        for (int i = Path.size() - 1; i >= 0; i--) {
            System.out.print(Path.get(i));
        }
    }

    static void getText(int r, int c) {
        if (r == 0 || c == 0) return;
        if (A[r - 1] == B[c - 1]) {
            Path.add(A[r - 1]);
            getText(r - 1, c - 1); //같으면 LCS에 기록하고 왼쪽위로 이동
        } else {
            //다르면 왼쪽과 오른쪽 중 큰 수로 이동
            if(dp[r-1][c] > dp[r][c-1])
                getText(r - 1, c);
            else
                getText(r, c - 1);
        }
    }
}
