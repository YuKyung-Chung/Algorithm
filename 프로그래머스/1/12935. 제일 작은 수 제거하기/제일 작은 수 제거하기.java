import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1){
            return new int[]{-1};
        }
        
        int min = Arrays.stream(arr).min().getAsInt();
        //최솟값을 제외한 나머지 저장
        List<Integer> list = new ArrayList<>();
        for(int i:arr){
            if(i != min){
                list.add(i);
            }
        }
        
        //List를 int 배열로 변환
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}