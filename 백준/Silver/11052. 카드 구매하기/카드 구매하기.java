import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] card = new int[10001]; //카드팩 저장하는 배열
        int[] maxArr = new int[10001]; //최대 금액

        int N = Integer.parseInt(st.nextToken()); //카드 N개

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                maxArr[i] = Math.max(maxArr[i], card[j] +maxArr[i-j]);
            }
        }
        System.out.println(maxArr[N]);
    }
}
