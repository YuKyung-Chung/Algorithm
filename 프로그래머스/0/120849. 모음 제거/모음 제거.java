import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        char[] ch = new char[my_string.length()];
        for(int i=0; i<my_string.length(); i++){
            ch[i] = my_string.charAt(i);
        }
        
        for(char c : ch){
            
            if(c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u'){
                sb.append(c);
            }
        }
        
        answer = sb.toString();
        
        return answer;
    }
}