import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {

        int s1 = 0;
        int s2 = 0;
        for(int i=0; i<goal.length; i++){
            String now = goal[i];
            
            if(s1 < cards1.length && cards1[s1].equals(now)){
                s1++;
            }
            else if(s2 < cards2.length && cards2[s2].equals(now)){
                s2++;
            }
            else{
                return "No";
            }
        }
        
        return "Yes";
    }
}