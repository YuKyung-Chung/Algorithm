import java.util.*;

class Solution {
    public String solution(String s) {
        char[] arr = new char[s.length()];
        for(int i=0; i<s.length(); i++){
            arr[i] = s.substring(i,i+1).charAt(0);
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder(new String(arr));
        
        return sb.reverse().toString();
    }
}