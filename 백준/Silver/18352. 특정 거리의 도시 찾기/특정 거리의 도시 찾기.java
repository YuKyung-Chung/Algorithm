import java.util.*;
public class Main {
    static int N,M,K,X;
    static ArrayList<Integer>[] A;
    static List<Integer> answer;
    static int[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //도시 개수
        M = sc.nextInt(); //도로 개수
        K = sc.nextInt(); //거리 정보
        X = sc.nextInt(); //출발 도시 번호

        A = new ArrayList[N + 1];
        answer = new ArrayList<>();

        //인접리스트 초기화
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<Integer>();
        }
        //인접리스트에 그래프 데이터 채우기
        for (int i = 0; i < M; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();
            A[S].add(E);
        }
        //방문 배열 초기화하기
        visited = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            visited[i] = -1;
        }

        BFS(X);
        for (int i = 0; i <= N; i++) {
            //방문 거리가 k인 노드의 숫자를 정답 배열에 더하기
            if (visited[i] == K) {
                answer.add(i);
            }
        }
        if (answer.isEmpty()) {
            System.out.println("-1");
        } else {
            Collections.sort(answer);
            for (int temp : answer) {
                System.out.println(temp);
            }
        }
    }

    //BFS 구현하기
    private static void BFS(int Node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(Node);
        visited[Node]++;
        while (!q.isEmpty()) {
            int now_Node = q.poll();
            for (int i : A[now_Node]) {
                if (visited[i] == -1) {
                    visited[i] = visited[now_Node] + 1;
                    q.add(i);
                }
            }
        }
    }

}
