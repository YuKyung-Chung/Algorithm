import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        //인접 리스트 초기화
        for (int i = 0; i <= N; i++) {
            A.add(new ArrayList<>());
        }
        //진입 차수 배열
        int[] indegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();
            A.get(S).add(E);
            indegree[E]++;
        }
        //진입 차수 배열 데이터 저장하기
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int now = q.poll();
            System.out.println(now + " ");
            for (int next : A.get(now)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
    }
}