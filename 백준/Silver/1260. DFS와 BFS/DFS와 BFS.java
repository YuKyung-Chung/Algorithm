import java.io.*;
import java.util.*;
public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //노드 개수
        int M = Integer.parseInt(st.nextToken()); //에지 개수
        int start = Integer.parseInt(st.nextToken()); //시작점
        A = new ArrayList[N + 1];

        //리스트 초기화
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<Integer>();
        }

        //인접 리스트에 그래프 데이터 저장하기
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            A[u].add(v);
            A[v].add(u);
        }
        
        //번호 작은 곳부터 방문하기 위해 정렬하기
        for (int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
        }


        visited = new boolean[N+1]; //방문 배열 초기화
        DFS(start);
        System.out.println();
        visited = new boolean[N+1]; //방문 배열 초기화
        BFS(start);
        System.out.println();
    }

    public static void DFS(int start) {
        System.out.print(start + " ");
        visited[start] = true;
        for (int i : A[start]) {
            if(!visited[i])
                DFS(i);
        }
        
    }

    public static void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int now = q.poll();
            System.out.print(now + " ");
            for (int i : A[now]) {
                if (!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
