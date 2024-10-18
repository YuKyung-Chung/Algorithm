import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //오름차순으로 자동 정렬
        for(int i: scoville){
            pq.add(i);
        }
        
        //가장 작은 원소가 K 미만일 경우
        while(pq.peek() < K && pq.size() >= 2){
            pq.add(pq.poll() + (pq.poll() * 2));
            answer++;
        }
        
        //마지막 남은 원소가 K 미만인지 확인
        if(pq.size() < 2 && pq.peek() < K){
            answer = -1;
        }
        
        return answer;
    }
}