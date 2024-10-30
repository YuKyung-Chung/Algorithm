import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] bookTime = new int[book_time.length][2];
        //기존 객실이 비어있다면 해당 객실에 추가
        //기존 객실 모두 꽉 찼다면 새로운 객실 배정
        for(int i=0; i<book_time.length; i++){
            int start = Integer.parseInt(book_time[i][0].replace(":","")); //1640
            int end = Integer.parseInt(book_time[i][1].replace(":","")); //1860 ->1900
            
            //청소시간 10분 더해서 저장
            end += 10;
            if(end % 100 >= 60){
                end += 40;
            }
            
            bookTime[i][0] = start;
            bookTime[i][1] = end;
        }
        Arrays.sort(bookTime, (a1, a2) -> {
            if(a1[0] == a2[0]){
                return a1[1] - a2[1]; //입실시각 같으면 퇴실시각 순으로 정렬
            }
            else{
                return a1[0]-a2[0]; //입실시각 순으로 정렬
            }
            
        });
        
        //우선순위 큐 활용
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int[] book : bookTime) {
            // 기존 방의 퇴실 시간이 현재 예약의 입실 시간보다 작거나 같으면 방을 비움
            if (!pq.isEmpty() && pq.peek() <= book[0]) {
                pq.poll();
            }
            // 새로운 방의 퇴실 시간을 큐에 추가
            pq.add(book[1]);
        }
        
        // 필요한 방의 개수는 우선순위 큐의 크기
        answer = pq.size();
        
        return answer;
    }
}