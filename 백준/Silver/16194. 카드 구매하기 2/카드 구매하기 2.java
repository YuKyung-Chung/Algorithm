import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] card = new int[10001]; //카드팩 개수
        int[] minArr = new int[10001]; //최소 비용

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        //배열의 초기값은 0이므로, 카드팩 개수로 초기화해줘야 한다!!!
        for (int i = 1; i <= N; i++) {
            minArr[i] = card[i];
            for (int j = 1; j <= i; j++) {
                minArr[i] = Math.min(minArr[i], card[j] + minArr[i-j]);
            }
        }
        System.out.println(minArr[N]);
    }
}