import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        //양수, 음수, 0, 1 따로 저장하기
        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder()); //양수는 내림차순 정렬
        PriorityQueue<Integer> minus = new PriorityQueue<>(); //음수는 오름차순 정렬
        int one = 0;
        int zero = 0;
        for (int i = 0; i < N; i++) {
            int temp = sc.nextInt();
            if (temp == 1) {
                one++;
            } else if (temp < 0) {
                minus.add(temp);
            } else if (temp == 0) {
                zero++;
            } else if (temp > 1) {
                plus.add(temp);
            }
        }
        int sum = 0;
        //양수 처리하기
        while (plus.size() > 1) {
            int first = plus.poll();
            int second = plus.poll();
            sum = sum + (first * second);
        }
        if (!plus.isEmpty()) {
            sum = sum + plus.poll();
        }
        
        //음수 처리하기
        while (minus.size() > 1) {
            int first = minus.poll();
            int second = minus.poll();
            sum = sum + (first * second);
        }
        if (!minus.isEmpty()) {
            if(zero == 0)
                sum = sum + minus.poll();
        }
        //1 처리하기
        sum = sum + one;
        System.out.println(sum);
        
    }
}
