import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<number.length(); i++){
            int now = Integer.parseInt(number.substring(i,i+1));
            
            while(!stack.isEmpty() && stack.peek() < now && k > 0){
                stack.pop();
                k--;
            }
            
            stack.push(now);
            
        }
        // 제거 횟수가 남아 있을 경우 뒤에서 제거
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        for (Integer element : stack) {
            answer += String.valueOf(element);
        }
        
        return answer;
    }
}