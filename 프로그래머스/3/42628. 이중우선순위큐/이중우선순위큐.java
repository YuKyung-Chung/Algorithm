import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        //오름차순 우선순위 큐 생성
        PriorityQueue<Integer> minpq = new PriorityQueue<>();
        // 내림차순 우선순위 큐 생성
        PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String str : operations){
            if(str.split(" ")[0].equals("I")){
                minpq.offer(Integer.parseInt(str.split(" ")[1]));
                maxpq.offer(Integer.parseInt(str.split(" ")[1]));
            } 
            else if(str.split(" ")[0].equals("D")){
                //최댓값 삭제
                if(str.split(" ")[1].equals("1")){
                     minpq.remove(maxpq.poll());
                }
                //최솟값 삭제
                else if(str.split(" ")[1].equals("-1")){
                    maxpq.remove(minpq.poll());
                }
            }
            
        }
        
        if(maxpq.isEmpty() && minpq.isEmpty()){
            return new int[]{0,0};
        }
        return new int[]{maxpq.poll(), minpq.poll()};
    }
}