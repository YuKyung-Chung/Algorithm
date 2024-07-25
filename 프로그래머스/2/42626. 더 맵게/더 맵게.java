import java.util.*;
import java.io.*;

class Solution {
    static PriorityQueue<Integer> pq;
    static int answer = 0;
    static boolean finish = false;
    
    public int solution(int[] scoville, int K) {
        pq = new PriorityQueue<>();
        
        for(int i : scoville){
            pq.offer(i);
        }
        makeSpicy(K);
        
        if(finish == false) return -1;
        else return answer;
    }//end of solution
    private static void makeSpicy(int K){
        
        while(pq.size() >= 2){
            int now = pq.poll();
            int second = pq.poll();
            if(now >= K){
                finish = true;
                return;
            }
            
            int after = now + (second * 2);
            answer += 1;
            pq.offer(after);
            
        }
        
        if(pq.poll() >= K){
            finish = true;
        } 
        return;
    }//end of makeSpicy
}