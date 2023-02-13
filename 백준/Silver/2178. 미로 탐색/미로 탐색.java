import java.io.*;
import java.util.*;
public class Main {
    static boolean[][] visited;
    //상하좌우 탐색하기 위한 배열 선언하기
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N, M;
    static int[][] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        A = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }
        BFS(0, 0);
        System.out.println(A[N-1][M-1]);
    }

    public static void BFS(int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{n, m});
        visited[n][m] = true;

        while (!q.isEmpty()) {
            int now[] = q.poll();
            for (int i = 0; i < 4; i++) {
                int X = now[0] + dx[i];
                int Y = now[1] + dy[i];
                //좌표 유효성 검사하기
                if (X >= 0 && Y >= 0 && X < N && Y < M) {
                    //갈 수 있는 칸이면서 방문하지 않은 칸이면 방문하기
                    if (A[X][Y] == 1 && !visited[X][Y]) {
                        visited[X][Y] = true;
                        A[X][Y] = A[now[0]][now[1]] + 1; //깊이 업데이트하기
                        q.add(new int[]{X, Y});
                    }
                }
            }
        }
    }
}
