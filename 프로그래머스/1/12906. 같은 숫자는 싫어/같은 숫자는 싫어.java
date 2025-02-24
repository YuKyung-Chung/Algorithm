import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        int now = arr[0];
        list.add(now);
        for(int i=1; i<arr.length; i++){
             if(arr[i] != now){
                 now = arr[i];
                 list.add(arr[i]);
             }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}