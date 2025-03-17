import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        //예산 오름차순 정렬
        Arrays.sort(d);
        
        for(int i=0; i<d.length; i++){
            if(budget - d[i] >= 0){
                budget = budget - d[i];
                answer++;            
            }
        }
        return answer;
    }
}