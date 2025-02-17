import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int sqrt = (int) Math.sqrt(n);
        answer = (sqrt * sqrt == n)? 1: 2;
        
        return answer;
    }
}