import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0; //최빈값
        int[] newArray = new int[1000]; //최빈값 담을 배열
        
        for(int i=0;i<array.length;i++){
            newArray[array[i]]++;
        }
        
        int max = 0;
        int max_index = 0;
        
        for(int i=0; i<newArray.length;i++){
            if(newArray[i] > max){
                max = newArray[i];
                max_index = i;
            }
        }
        int count = 0;
        for(int i=0; i<newArray.length;i++){
            if(newArray[i] == max){
                count++;
            }
        }
        if(count>1){
            return -1;
        } else{
            return max_index;
        }
        
    }
}