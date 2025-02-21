import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        s = s.toLowerCase();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        return map.getOrDefault('p',0).equals(map.getOrDefault('y',0));
    }
}