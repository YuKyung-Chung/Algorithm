import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int M;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static boolean arrive = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //사람 수
        M = Integer.parseInt(st.nextToken()); //친구 관계수
        visited = new boolean[N];
        A = new ArrayList[N];

        //리스트 초기화
        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<Integer>();
        }

        //인접 리스트 채우기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            A[u].add(v);
            A[v].add(u);
        }

        for (int i = 0; i < N; i++) {
            DFS(i, 1); //depth 1부터 시작
            if (arrive) {
                break;
            }
        }
        if(arrive)
            System.out.println("1");
        else
            System.out.println("0");
    }

    static void DFS(int node, int depth) {
        if (depth == 5 || arrive) {
            arrive = true;
            return;
        }
        visited[node] = true;
        for (int i :A[node]) {
            if (!visited[i]) {
                DFS(i, depth + 1);
            }
        }
        visited[node] = false;
    }
}
