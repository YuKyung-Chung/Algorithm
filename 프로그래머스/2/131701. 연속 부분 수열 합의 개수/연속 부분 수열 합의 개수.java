import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        Set<Integer> set = new HashSet<>();
        
        int[] circle_elements = new int[n*2];
        for(int i=0; i<n; i++){
            circle_elements[i] = elements[i];
        }
        for(int i=n; i<circle_elements.length; i++){
            circle_elements[i] = elements[i-n];
        }
        
        //길이 1부터 n까지의 모든 연속 부분 수열 합 계산
        for(int i=1; i<=n; i++){
            for(int j=0; j<n; j++){
                int sum  = 0;
                //부분 수열 합 계산
                for(int k=0; k<i; k++){
                    sum += circle_elements[j+k];
                }
                set.add(sum);
            }
        }
        
        
        return set.size();
    }
}