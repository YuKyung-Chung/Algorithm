import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];
        int result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            int start = 0;
            int end = N-1;
            long find = arr[i];
            //투 포인터 알고리즘
            while (start < end) {
                if (arr[start] + arr[end] == find) {
                    //find는 서로 다른 두 수의 합이어야 함을 체크
                    if (start != i && end != i) {
                        result++;
                        break;
                    } else if (start == i) {
                        start++;
                    } else if (end == i) {
                        end--;
                    }
                } else if (arr[start] + arr[end] < find) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        System.out.println(result);
    }
}
