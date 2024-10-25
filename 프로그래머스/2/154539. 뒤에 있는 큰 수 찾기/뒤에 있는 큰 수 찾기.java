import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        
        //뒤에서부터 탐색
        for(int i=numbers.length-1; i >= 0; i--){
            int now = numbers[i];
            
            //현재보다 작거나 같으면 pop
            while(!stack.isEmpty() && stack.peek() <= now){
                stack.pop();
            }
            
            //스택에 남아있는 수가 가장 큰수
            if(stack.isEmpty()){
                answer[i] = -1;
            }
            else{
                answer[i] = stack.peek();
            }
            
            //스택에 넣기
            stack.push(now);
           
        }
        return answer;
    }
}