import java.util.*;
public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
        System.out.print(sb);
    }

    static void DFS(int num, int jari) {
        if (jari == N) {
            if (isPrime(num)) {
                sb.append(num).append("\n");
            }
            return;
        }
        for (int i = 1; i < 10; i++) {
            //짝수 가지치기
            if (i % 2 == 0) {
                continue;
            }
            //소수라면 재귀 함수로 자릿수 늘림
            if (isPrime(num * 10 + i)) {
                DFS(num * 10 + i, jari + 1);
            }
        }
    }

    //소수 판별 함수
    static boolean isPrime(int num) {
        for (int i = 2; i <= num/2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
