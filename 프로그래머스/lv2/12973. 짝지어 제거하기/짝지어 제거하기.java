import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();

        for(int i=0; i<s.length(); i++){
            char a = arr[i];
            if(stack.isEmpty()){
                stack.push(a);
            }else{
                if(a == stack.peek()){
                    stack.pop();
                } else{
                    stack.push(a);
                }
            }
        }
        if(stack.isEmpty()){
            answer = 1;
        } else{
            answer = 0;
        }
        return answer;
    }
}