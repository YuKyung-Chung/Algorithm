import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        //맨 앞이 - 부호인지 확인
        if(s.substring(0,1).equals("-")){
            answer = Integer.parseInt(s.substring(1,s.length())) * (-1);
        }
        //맨 앞이 + 부호인지 확인
        else if(s.substring(0,1).equals("+")){
            answer = Integer.parseInt(s.substring(1,s.length()));
        }
        //부호가 아니면 숫자 반환
        else{
            answer = Integer.parseInt(s.substring(0,s.length()));
        }
        
        
        return answer;
    }
}