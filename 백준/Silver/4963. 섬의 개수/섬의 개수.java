import java.io.*;
import java.util.*;
public class Main {
    static int w; //너비
    static int h; //높이
    static int[][] map; //2차원 배열 지도
    static boolean[][] visit;
    static int[] dx = {0, 0, 1, -1, -1, 1, -1, 1};
    static int[] dy = {1, -1, 0, 0, -1, 1, 1, -1};

    static int curX, curY;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w ==0 && h == 0)
                break;
            
            map = new int[h][w];
            visit = new boolean[h][w];
            
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            count = 0; //섬 개수 초기화
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visit[i][j] && map[i][j] == 1) {
                        visit[i][j] = true;
                        dfs(i,j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }

    public static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 8; i++) { //방향
            curX = x + dx[i];
            curY = y + dy[i];
            if (curX >= 0 && curY >= 0 && curX < h && curY < w) {
                if (!visit[curX][curY] && map[curX][curY] == 1) {
                    dfs(curX, curY);
                }
            }
        }
    }
}
