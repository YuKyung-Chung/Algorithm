import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long left = 0;
        long right = times[times.length -1] * (long)n; //모든 사람이 느리게 심사 받는 경우
        
        while(left <= right){
            long mid = (left + right) / 2;
            long complete = 0; //심사한 총 사람 수
            //mid 시간 동안 몇명의 사람 심사할 수 있는지 계산
            for(int i=0; i<times.length; i++){
                complete += mid / times[i];
            }
            //심사한 총 사람수가 n보다 작을 경우
            if(complete < n) //해당 시간에는 모든 사람이 검사 받을 수 없음
                left = mid+1;
            else{
                right = mid - 1;
                answer = mid; //모두 검사받았으나, 더 최솟값이 있을 수 있음
            }
        }
        return answer;
    }
}