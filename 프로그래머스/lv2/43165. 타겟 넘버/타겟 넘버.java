import java.util.*;
import java.io.*;

class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        //숫자배열, 노드 깊이, 타겟넘버, 이전까지의 합
        DFS(numbers,0,target,0);
        
        return answer;
    }
    
    public static void DFS(int[] numbers, int depth, int target, int sum){
        //마지막 노드까지 탐색한 경우
        if(depth == numbers.length){
            if(sum == target) answer++;
            return;
        }
        
        DFS(numbers, depth+1, target, sum + numbers[depth]);
        DFS(numbers, depth+1, target, sum - numbers[depth]);
    }
    
}