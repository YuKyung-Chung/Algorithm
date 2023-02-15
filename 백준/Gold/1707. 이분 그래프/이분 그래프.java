import java.util.*;
public class Main {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int[] check;
    static boolean isEven;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt(); //테스트 케이스 개수
        //K번 반복
        for (int i = 0; i < K; i++) {
            int V = sc.nextInt(); // 정점 개수
            int E = sc.nextInt(); // 간선 개수

            check = new int[V + 1];
            visited = new boolean[V + 1];
            A = new ArrayList[V + 1];
            isEven = true;

            //인접 리스트 초기화
            for (int j = 1; j <= V; j++) {
                A[j] = new ArrayList<>();
            }
            //인접 리스트 생성
            for (int k = 0; k < E; k++) {
                int S = sc.nextInt();
                int P = sc.nextInt();
                A[S].add(P);
                A[P].add(S);
            }
            //방문 배열 초기화하고 각 노드에서 DFS 실행
            for (int l = 1; l <= V; l++) {
                if(isEven)
                    DFS(l);
                else
                    break;
            }
            if (isEven) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static void DFS(int node) {
        visited[node] = true;
        for (int i : A[node]) {
            if (!visited[i]) {
                //인접한 노드는 같은 집합이 아니므로 이전 노드와 다른 집합으로 처리
                check[i] = (check[node] + 1) % 2;
                DFS(i);
            }
            //이미 방문한 노드가 현재 내 노드와 같은 집합이면 이분 그래프가 아님
            else if (check[node] == check[i]) {
                isEven = false;
            }
        }

    }
}
