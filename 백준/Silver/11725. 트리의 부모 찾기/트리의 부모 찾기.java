import java.util.*;
public class Main {
    static int N;
    static boolean[] visited;
    static ArrayList<Integer>[] tree;
    static int[] answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        visited = new boolean[N + 1];
        answer = new int[N + 1];
        tree = new ArrayList[N + 1];
        //tree 초기화
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }

        //인접 리스트 생성
        for (int i = 1; i < N; i++) {
            int S = sc.nextInt();
            int P = sc.nextInt();
            tree[S].add(P);
            tree[P].add(S);
        }
        
        DFS(1); //1번 노드부터 DFS 시작
        
        for (int i = 2; i <= N; i++) {
            System.out.println(answer[i]);
        }
    }

    static void DFS(int node) {
        visited[node] = true;

        for (int i : tree[node]) {
            if (!visited[i]) {
                visited[i] = true;
                //DFS를 탐색하면서 부모노드를 정답 배열에 저장
                answer[i] = node; 
                DFS(i);
            }
        }
    }
}