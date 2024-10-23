import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int num = (int) (right-left+1);
        int[] answer = new int[num];
        
        // left부터 right까지의 값을 차례로 구함
        for (long i = left; i <= right; i++) {
            // i를 n으로 나눈 몫이 row, 나머지가 col
            int row = (int) (i / n);
            int col = (int) (i % n);
            
            // 해당 위치의 값은 max(row, col) + 1
            answer[(int)(i - left)] = Math.max(row, col) + 1;
        }
        return answer;
    }
}