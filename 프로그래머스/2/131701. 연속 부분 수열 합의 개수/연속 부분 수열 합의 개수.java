import java.util.*;

class Solution {
    public int solution(int[] elements) {
        //중복되는 값 제거하기 위한 Set
        HashSet<Integer> set = new HashSet<>();
        int N = elements.length;
        
        //원형 수열이므로 기존 수열의 2배로 이어붙임
        int[] extended = new int[N * 2];
        for(int i=0; i<N; i++){
            extended[i] = elements[i];
            extended[i+N] = elements[i];
        }
        
        for(int i=0; i<N; i++){
            int sum = 0;
            for(int j=i; j<i+N; j++){
                sum += extended[j];
                set.add(sum);
            }
        }
        
        return set.size();
    }
}