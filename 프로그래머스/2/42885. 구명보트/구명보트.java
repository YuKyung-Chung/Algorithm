import java.io.*;
import java.util.*;

class Solution {
    //투 포인터로 풀어보기
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people); //오름차순 정렬
        int left = 0;
        int right = people.length-1;
        
        while(left <= right){
            //가장 가벼운 사람과 가장 무거운 사람을 함께 태울 수 있으면 태운다
            if(people[left] + people[right] <= limit){
                left++; //가벼운 사람은 보트에 태움
            }
            //가장 무거운 사람은 무조건 태워야 하므로 오른쪽 인덱스 감소
            right--;
            //보트 하나 사용
            answer++;
        }
        
        return answer;
    }
}