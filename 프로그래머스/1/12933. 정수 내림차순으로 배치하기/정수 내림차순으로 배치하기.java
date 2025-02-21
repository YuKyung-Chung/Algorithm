import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String str = String.valueOf(n);
        String[] arr = new String[str.length()];
        
        for(int i=0; i<str.length(); i++){
            arr[i] = str.substring(i,i+1);
        }
        Arrays.sort(arr, Collections.reverseOrder()); //내림차순 정렬
        String sorted = "";
        for(int i=0; i<str.length(); i++){
            sorted += arr[i];
        }
        answer = Long.parseLong(sorted);
        return answer;
    }
}