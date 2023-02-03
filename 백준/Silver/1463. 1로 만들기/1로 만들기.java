import java.io.*;
import java.util.*;

public class Main {
    //동적 프로그래밍(DP)
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        dp = new int[N+1]; //연산 횟수 저장

        //dp 초기화
        dp[0] = dp[1] = 0;
        for (int i = 2; i < N+1; i++) {
            //-1 연산을 수행할 경우
            dp[i] = dp[i - 1] + 1; //+1은 연산을 수행한 카운터를 하나 올려줌
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1); //비교
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1); //비교
            }
        }
        System.out.println(dp[N]);
    }
}