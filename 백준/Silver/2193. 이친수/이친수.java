
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] num = new long[N + 1];

        num[0] = 0;
        num[1] = 1;
        for (int i = 2; i <= N; i++) {
            num[i] = num[i - 1] + num[i - 2];
        }
        System.out.println(num[N]);
    }
}