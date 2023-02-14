import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] A = new int[N][2];
        for (int i = 0; i < N; i++) {
            A[i][0] = sc.nextInt();
            A[i][1] = sc.nextInt();
        }
        Arrays.sort(A, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) { //종료시간이 같을 때
                    return o1[0] - o2[0]; //시작시간 기준으로 정렬하기
                }
                return o1[1] - o2[1];
            }
        });
        int count = 0;
        int end = -1;
        for (int i = 0; i < N; i++) {
            if (A[i][0] >= end) { //겹치지 않는 다음 회의가 나온 경우
                end = A[i][1]; //종료 시간 업데이트하기
                count++;
            }
        }
        System.out.println(count);
    }
}