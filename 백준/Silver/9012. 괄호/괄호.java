import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken(); //((()())))
            sb.append(solve(str)).append('\n');
        }
        System.out.println(sb);
    }

    public static String solve(String s) {
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            }else if (count == 0) {
                return "NO";
            } else {
                count--;
            }
        }

        if (count == 0) {
            return "YES";
        } else {
            return "NO";
        }
    }
}