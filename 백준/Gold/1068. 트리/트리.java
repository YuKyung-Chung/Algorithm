import java.util.*;
public class Main {
    static int N, deleteNode;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //노드 개수

        visited = new boolean[N + 1];

        tree = new ArrayList[N + 1];
        //tree 초기화
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        int root = 0;
        //인접 리스트 생성
        for (int i = 0; i < N; i++) {
            int S = sc.nextInt();
            if (S == -1) {
                root = i;
            } else {
                tree[S].add(i);
                tree[i].add(S);
            }
        }
        deleteNode = sc.nextInt(); //삭제할 노드

        if (root == deleteNode) {
            System.out.println(0);
        } else {
            DFS(root);
            System.out.println(answer);
        }
    }

    static void DFS(int node) {
        if (node == deleteNode) {
            return;
        }
        visited[node] = true;
        int cNode = 0;
        for (int i : tree[node]) {
            if (!visited[i] && i != deleteNode) { //삭제 노드가 아닐 때도 탐색 중지
                visited[i] = true;
                cNode++;
                DFS(i);
            }
        }
        //자식 노드가 아닐 때, 리프노드로 간주하고 정답 값 증가
        if (cNode == 0) {
            answer++;
        }
    }
}