import java.util.*;
public class Main {
    static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //원소 개수
        int M = sc.nextInt(); //질의 개수

        parent = new int[N + 1];
        //대표 노드를 자기 자신으로 초기화
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        //M번 만큼 반복
        for (int i = 0; i < M; i++) {
            int q = sc.nextInt(); //0인지 1인지 여부
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (q == 0) {
                union(a,b);
            } else {
                if (checkSame(a,b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    //union 연산: 대표 노드끼리 연결하기
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        parent[b] = a;
    }

    //find 연산: 대표 노드 찾기
    static int find(int a) {
        if (a == parent[a]) {
            return a;
        } else {
            //재귀 함수 형태로 구현 -> 경로 압축 부분
            return parent[a] = find(parent[a]);
        }
    }

    static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return true;
        } else {
            return false;
        }
    }
}