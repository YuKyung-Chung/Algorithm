import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            //mod 연산을 할 때는 연산마다 계산을 해줘야 한다
            //계속 숫자를 더하고 마지막 출력시에만 mod 연산을 해줄 경우
            //Integer.MAX_VALUE를 넘어 Overflow가 발생하기 때문에 잘못된 값 출력될 수 있다.
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }
        System.out.println(dp[n]);
    }
}