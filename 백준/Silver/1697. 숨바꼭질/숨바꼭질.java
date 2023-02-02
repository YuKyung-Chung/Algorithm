import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static int[] visit = new int[100001];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());


        if (n == k) {
            System.out.println(0);
        } else {
            bfs(n);
        }


    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit[start] = 1; //방문횟수 1증가함

        while (!q.isEmpty()) {
            int temp = q.poll();

            for (int i = 0; i < 3; i++) { //3가지 방법으로 움직일 수 있음
                int next;

                if (i == 0) {
                    next = temp + 1;
                } else if (i == 1) {
                    next = temp - 1;
                } else {
                    next = temp * 2;
                }

                if (next == k) {
                    System.out.println(visit[temp]);
                    return;

                }
                if (next >= 0 && next<visit.length && visit[next] == 0) {
                    q.add(next);
                    visit[next] = visit[temp] + 1;
                }
            }

        }


    }
}