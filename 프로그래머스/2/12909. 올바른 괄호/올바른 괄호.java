import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        //오른쪽 괄호부터 시작하면 false
        if(s.charAt(0) == ')') return false;
        try{
            for(char c: s.toCharArray()){
                if(c == '('){
                    stack.push('c');
                }
                else if(c == ')'){
                    stack.pop();
                }
            }
        }
        catch(Exception e){
            return false;
        }
        
        return stack.size() == 0? true: false;
    }
}