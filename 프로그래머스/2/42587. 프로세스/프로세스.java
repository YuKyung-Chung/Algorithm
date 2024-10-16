import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<int[]> q = new LinkedList<>();
        // 프로세스의 우선순위와 인덱스를 큐에 추가
        for (int i = 0; i < priorities.length; i++) {
            q.add(new int[] {priorities[i], i});
        }
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            boolean isTrue = false;
            
            for(int[] i: q){
                //현재보다 더 높은 우선순위가 있다면
                if(i[0] > now[0]){
                    isTrue = true;
                    break;
                }
            }
            
            //현재보다 더 높은 우선순위 있는 경우
            if(isTrue){
                q.add(now);
            }
            else{
                //현재 프로세스 실행
                answer++;
                //실행한 프로세스가 찾던 프로세스인 경우 반환
                if(location == now[1]){
                    return answer;
                }
            }
        }
        return answer;
    }
}