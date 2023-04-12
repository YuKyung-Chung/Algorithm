import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        int size = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] % divisor == 0){
                size++;
            }
        }
        if(size == 0){
            int[] answer = {-1};
            return answer;
        }
        
        int number = 0;
        int[] answer = new int[size];
        for(int i=0; i<arr.length; i++){
            if(arr[i] % divisor == 0){
                answer[number] = arr[i];
                number++;
            }
        }
        Arrays.sort(answer);
        return answer;
    }
}