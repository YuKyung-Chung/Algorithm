import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] words = s.split(" ", -1); // 공백을 유지하면서 문자열을 나눔
        
        for(int i=0; i<words.length; i++){
            StringBuilder sb2 = new StringBuilder();
            
            for(int j=0; j<words[i].length(); j++){
                char c = words[i].charAt(j);
                if(j % 2 == 0){
                    sb2.append(Character.toUpperCase(c));
                }
                else{
                    sb2.append(Character.toLowerCase(c));
                }
            }
            
            answer.append(sb2);
            if(i< words.length - 1){
                answer.append(" "); //원래 공백 유지
            }
        }
        return answer.toString();
    }
}