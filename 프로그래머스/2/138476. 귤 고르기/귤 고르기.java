import java.io.*;
import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        //크기에 따른 귤 개수 카운트하여 저장
        for(int i=0; i<tangerine.length; i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i],0)+1);
        }
        
        //Map.Entry를 리스트로 변환
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        
        //value 값에 따라 내림차순으로 정렬
        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        
        //정렬된 결과에 따라 귤 고르는 로직
        for(Map.Entry<Integer, Integer> entry : entryList){
            if(k<=0) break;
            k -= entry.getValue();
            answer++;
        }
        
        return answer;
    }
}