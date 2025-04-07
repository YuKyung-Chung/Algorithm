import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        // 기본형 -> 객체형 배열로 변환
        Integer[] scoreArr = Arrays.stream(score).boxed().toArray(Integer[]::new);

        //내림차순 정렬
        Arrays.sort(scoreArr, Collections.reverseOrder());
        //앞에서부터 m개로 자르기
        for(int j=m-1; j<score.length; j+=m){
            // System.out.println(scoreArr[j]);
            answer += scoreArr[j] * m;
        }
        
        
        
        return answer;
    }
}