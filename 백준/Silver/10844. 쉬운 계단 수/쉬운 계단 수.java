
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //수의 길이
        long[][] dp = new long[N+1][10];
        long count = 0; //계단수 count

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) { //digit
            for (int j = 0; j <= 9; j++) { //value
                if (j == 0) { //자릿값이 1일 때
                    dp[i][0] = dp[i-1][1] % 1000000000;
                } else if (j == 9) { //자릿값이 9일 때
                    dp[i][9] = dp[i-1][8] % 1000000000;
                }else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
                }
            }
        }

        for(int i = 0; i <= 9; i++) {
            count += dp[N][i];
        }
        System.out.println(count % 1000000000);
    }
}