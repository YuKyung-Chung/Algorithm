import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] clothe: clothes){
            String type = clothe[1]; //의상 종류
            map.put(type,map.getOrDefault(type,0)+1);
        }
        //입지 않는 경우까지 포함하여 모든 경우 계산하기
        Iterator<Integer> it = map.values().iterator();
        int answer = 1;
        while(it.hasNext()){
            answer *= it.next().intValue()+1;
        }
        return answer-1;
    }
}