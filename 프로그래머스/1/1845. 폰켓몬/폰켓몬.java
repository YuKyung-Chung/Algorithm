import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> h = new HashSet<>();
        
        for(int i:nums){
            h.add(i);
        }
        
        if(h.size() < nums.length/2){
            answer = h.size();
        }
        else{
            answer = nums.length/2;
        }
        return answer;
    }
}