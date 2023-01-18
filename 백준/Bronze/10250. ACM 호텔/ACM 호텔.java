import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //첫째 줄 입력 받음(테스트 케이스 개수)
        int T = Integer.parseInt(br.readLine());

        int result;
        
        //테스트 케이스 개수만큼 H,W,N 입력 받음
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());            
            if (N % H == 0) {
                result = H * 100 + (N / H);
            } else {
                result = (N % H) * 100 + (N / H) + 1;
            }
            System.out.println(result);
        }
        br.close();
    }
}
