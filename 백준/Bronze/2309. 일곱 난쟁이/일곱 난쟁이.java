import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] height = new int[9];
        int sum = 0;
        int A = 0;
        int B = 0;

        for (int i = 0; i < 9; i++) {
            height[i] = Integer.parseInt(br.readLine());
            sum += height[i];
        }
        Arrays.sort(height); //난쟁이 키 오름차순으로 정렬

        //가짜 난쟁이 판별
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - height[i] - height[j] == 100) {
                    A = i;
                    B = j;
                    break;
                }
            }
        }

        //진짜 난쟁이 출력
        for (int i = 0; i < 9; i++) {
            if (i == A || i == B) {
                continue;
            }
            System.out.println(height[i]);
        }

    }
}
