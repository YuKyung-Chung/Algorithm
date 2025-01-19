import java.util.*;
import java.io.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        List<String> list = new ArrayList<>();
        for(String str : phone_book){
            list.add(str);
        }
        Collections.sort(list);
        
        for(int i=0; i<list.size()-1; i++){
            String now = list.get(i);
            String next = list.get(i+1);
            if(next.startsWith(now)){
                answer = false;
            }
        }
        
        return answer;
    }
}