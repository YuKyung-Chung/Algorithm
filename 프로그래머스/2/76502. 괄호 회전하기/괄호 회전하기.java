import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        //s 길이만큼 회전
        for(int i=0; i<s.length(); i++){
            String ss = s.substring(i) + s.substring(0,i);
            char[] c = ss.toCharArray();
            Stack<Character> stack = new Stack<>();
            
            for(char now : c){
                if(stack.isEmpty()){
                    stack.push(now);
                    continue;
                }
                if(now ==')' && stack.peek() == '('){
                    stack.pop();
                    continue;
                }
                else if(now == '}' && stack.peek() == '{'){
                    stack.pop();
                    continue;
                }
                else if(now == ']' && stack.peek() == '['){
                    stack.pop();
                    continue;
                }
                
                stack.push(now);
            }
            
            //올바른 괄호 문자열이 되면
            if(stack.size() == 0) answer++;
            
        }
        
        return answer;
    }
}