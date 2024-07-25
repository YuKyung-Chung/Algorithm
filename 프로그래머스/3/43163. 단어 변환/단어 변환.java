import java.util.*;
import java.io.*;

class Solution {
    static boolean found;
    static int answer = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        found = false;
        boolean[] visited = new boolean[words.length]; //words 배열 중 이미 사용한 단어
        
        find(begin.toCharArray(), target.toCharArray(), words, visited, 0);
        
        if(found == false) return 0;
        else return answer;
    }//main 메서드
    
    private static void find(char[] now, char[] target, String[] words, boolean[] visited, int count){
        
        if(Arrays.equals(now, target)){
            found = true;
            answer = Math.min(answer, count);
            return;
        }
        
        //아직 방문하지 않았으면서 변화한 단어가 한개일 경우 바꿔
        for(int i=0; i<words.length; i++){
            if(!visited[i] && isOnlyOneDifference(now, words[i])){
                visited[i] = true;
                find(words[i].toCharArray(), target, words, visited, count+1);
                visited[i] = false; // Backtracking을 위해 visited 상태를 원래대로 되돌림
            }
        }
    }//find 메서드
    
    private static boolean isOnlyOneDifference(char[] now, String word){
        char[] words = word.toCharArray();
        int diff = 0;
        
        if(now.length != words.length) return false;
        
        for(int i=0; i<now.length; i++){
            if(now[i] != words[i]) diff++;
            if(diff > 1) return false;
        }
        
        return diff == 1;
    }
}