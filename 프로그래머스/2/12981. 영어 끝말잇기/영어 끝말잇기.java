import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        boolean isTrue = true;
        List<String> list = new ArrayList<>();
        list.add(words[0]); //첫번째 단어 추가
        
        for(int i=1; i<words.length; i++){
            //말이 이어지는지 확인
            if(words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
                answer[0] = i % n +1;
                answer[1] = i / n +1;
                isTrue = false;
                break;
            }

            //이전에 나왔던 단어인지 확인
            if(list.contains(words[i])){
                answer[0] = i % n +1;
                answer[1] = i / n +1;
                isTrue = false;
                break;
            }
            list.add(words[i]);
        }

        return answer;
    }
}