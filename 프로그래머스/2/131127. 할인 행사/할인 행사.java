import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> list = new HashMap<>();
        for(int i=0; i<want.length; i++){
            //키-값 쌍으로 저장
            list.put(want[i], number[i]);
        }
        
        
        int answer = 0;
        
        //슬라이딩 윈도우 기법
        for(int i=0; i<=discount.length-10; i++){
            Map<String, Integer> check = new HashMap<>();
            
            for(int j=i; j<i+10; j++){
                if(list.containsKey(discount[j])){
                    check.put(discount[j], check.getOrDefault(discount[j], 0)+1);
                }
            }
            
            if(check.equals(list)) answer++;
        }
        
        
        return answer;
    }
}