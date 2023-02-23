class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int sign = 0;
        if(s.charAt(0) == ')')
            return false;
        if(s.length() == 0)
            return false;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                sign++;
            }
            if(s.charAt(i) == ')')
                sign--;
            if(sign < 0)
                break;       
        }
        if(sign == 0 && s.charAt(0) == '(')
            answer = true;
        else
            answer = false;
        
        return answer;
    }
}