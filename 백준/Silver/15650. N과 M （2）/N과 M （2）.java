import java.util.*;

public class Main {
    static int N,M;
    static boolean[] visit;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];
        visit = new boolean[N];

        dfs(0);

    }

    static void dfs(int idx) {
        if (idx == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true; //방문 여부 체크
                arr[idx] = i + 1; //현재 인덱스에 값을 넣어주고
                dfs(idx + 1); //다음 인덱스 채우기 위해 다시 재귀호출

                //재귀호출이 끝난 후에 현재 i만 true로 바꾸고 나머지는 false로 해준다
                for (int j = i+1; j < N; j++) {
                    visit[j] = false;
                }
            }
        }
    }
}