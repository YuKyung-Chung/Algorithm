import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<progresses.length; i++){
            q.add((int) Math.ceil((double) (100 - progresses[i]) /speeds[i]));
            // days = (int) Math.ceil((double)(100 - progresses[idx]) / speeds[idx]);
        }
        
        List<Integer> answer = new ArrayList<>();
        while(!q.isEmpty()){
            int day = q.poll();
            int count = 1;
            
            while(!q.isEmpty() && day >= q.peek()){
                q.poll();
                count++;
            }
            answer.add(count);
        }
        int[] answer_int = new int[answer.size()];
        for(int i=0; i<answer.size(); i++){
            answer_int[i] = answer.get(i);
        }
        return answer_int;
    }
}