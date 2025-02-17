import java.util.*;

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        char[] ch = new char[my_string.length()];
        for(int i=0; i<my_string.length(); i++){
            ch[i] = my_string.substring(i,i+1).charAt(0);
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<ch.length; i++){
            if(ch[i] - 'A' < 0){
                list.add(ch[i] - '0');
            }
        }
        
        for(int i=0; i<list.size(); i++){
            answer += list.get(i);
        }
        
        return answer;
    }
}