import java.util.*;

class Solution {
    public String solution(String my_string, String letter) {
        char[] ch = my_string.toCharArray();
        StringBuilder answer = new StringBuilder();
        
        for(int i=0; i<ch.length; i++){
            if(ch[i] != letter.charAt(0)){
                answer.append(ch[i]);
            }
        }
        
        return answer.toString();
    }
}