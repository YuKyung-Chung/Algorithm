
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //건물 종류
        ArrayList<Integer>[] A = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        int[] indegree = new int[N + 1]; //진입 차수 배열
        int[] selfBuild = new int[N + 1]; //자기 자신을 짓는데 걸리는 시간
        for (int i = 1; i <= N; i++) {
            selfBuild[i] = sc.nextInt(); //건물 짓는데 걸리는 시간
            while (true) { //인접 리스트 초기화
                int preTemp = sc.nextInt();
                if (preTemp == -1) {
                    break;
                }
                A[preTemp].add(i);
                indegree[i]++; //진입 차수 배열 초기화
            }
        }
        //위상 정렬
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        int[] result = new int[N + 1];
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : A[now]) {
                indegree[next]--;
                //시간 업데이트하기
                result[next] = Math.max(result[next], result[now] + selfBuild[now]);
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            System.out.println(result[i] + selfBuild[i]);
        }
    }
}