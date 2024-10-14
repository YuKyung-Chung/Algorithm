import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for(String[] clothe: clothes){
            String type = clothe[1]; //의상 종류
            map.put(type,map.getOrDefault(type,0)+1);
        }
        //입지 않는 경우까지 포함하여 모든 경우 계산하기
        //아예 안입는 경우는 없으니까 마지막에 1 빼주기
        int answer = 1;
        for(String s: map.keySet()){
            answer *= (map.get(s)+1);
        }
        
        return answer-1;
    }
}