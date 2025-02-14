import java.util.*;

class Solution {
    int[] answer;
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
       
        for(int i=1; i<=n; i++){
            if(i % 2 != 0){
                list.add(i);
            }
        }
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}