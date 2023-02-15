import java.util.*;
public class Main {
    static int N,M;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int[] answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        answer = new int[N + 1];
        A = new ArrayList[N + 1];
        // A 배열 초기화
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        //인접 리스트 생성
        for (int i = 0; i < M; i++) {
            int S = sc.nextInt();
            int P = sc.nextInt();
            A[S].add(P);
        }

        //신뢰도 배열 초기화
        //모든 노드로 BFS 실행
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            BFS(i);
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, answer[i]);
        }
        for (int i = 1; i <= N; i++) {
            if (answer[i] == max) {
                System.out.print(i + " ");
            }
        }
    }

    static void BFS(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;

        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int i : A[temp]) {
                if (!visited[i]) {
                    visited[i] = true;
                    answer[i]++; //신규 노드 인덱스의 정답 배열 값 증가시킴
                    q.add(i);
                }
            }
        }
    }
}