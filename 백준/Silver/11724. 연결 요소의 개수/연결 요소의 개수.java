import java.io.*;
import java.util.*;

public class Main {
    static int node; //정점개수
    static int line; //간선 개수
    static boolean[] visit;
    static int[][] arr;
    static Queue<Integer> q = new LinkedList<>();


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());

        arr = new int[1001][1001];
        visit = new boolean[1001];

        //인접행렬 생성
        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1; //간선 연결
        }
        int result = 0;
        for (int i = 1; i <= node; i++) {
            if (visit[i] == false) { //방문한 적 없는 노드하면 dfs
                bfs(i);
                result++;
            }
        }
        System.out.println(result);

    }

    public static void bfs(int start) {
        q.add(start);
        visit[start] = true;

        while (!q.isEmpty()) {
            int temp = q.poll();

            for (int i = 1; i <= node; i++) {
                if (arr[temp][i] == 1 && !visit[i]) {
                    q.add(i);
                    visit[i] = true;
                }
            }
        }

    }
}