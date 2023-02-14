import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //카드 묶음 수 저장
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //우선순위는 숫자 낮은 순
        
        for (int i = 0; i < N; i++) {
            int data = sc.nextInt();
            pq.add(data);
        }
        int data1 = 0;
        int data2 = 0;
        int sum = 0;
        //자동 정렬에 따라 작은 카드 묶음 2개를 쉽게 뽑을 수 있음
        while (pq.size() != 1) {
            data1 = pq.poll();
            data2 = pq.poll();
            sum += data1 + data2;
            pq.add(data1 + data2);
        }
        System.out.println(sum);
    }
}