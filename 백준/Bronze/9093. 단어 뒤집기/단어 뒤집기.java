import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                StringBuilder sb = new StringBuilder(st.nextToken());
                answer.append(sb.reverse()).append(" ");
            }
            answer.append("\n");
        }
        System.out.println(answer);

    }
}
