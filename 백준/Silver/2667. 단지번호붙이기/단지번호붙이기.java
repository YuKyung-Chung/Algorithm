import java.util.*;
import java.io.*;
public class Main {
    public static int N;
    public static int[][] arr;
    public static boolean[][] vtd;
    public static ArrayList<Integer> list;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static void solve(int pp, int qq) {
        Queue<int[]> q = new LinkedList<>();
        vtd[pp][qq] = true; //방문 처리
        q.add(new int[]{pp, qq});

        int size = 1;
        //q에 값이 있으면
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny] == 0 || vtd[nx][ny]) {
                    continue;
                } else {
                    vtd[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    size++;
                }

            }
        }
        list.add(size);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //N x N
        arr = new int[N][N];
        vtd = new boolean[N][N];
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                //아직 방문되지 않았고, 1인 경우
                if (!vtd[i][j] && arr[i][j] == 1) {
                    count++;
                    solve(i, j); //방문처리
                }
            }
        }
        System.out.println(count);
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (Integer integer : list) {
            sb.append(integer).append("\n");
        }
        System.out.println(sb.toString());
    }
}
