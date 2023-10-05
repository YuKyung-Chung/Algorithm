import java.io.*;
import java.util.*;

class Solution {
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(!visited[i]){
                 answer++;
                DFS(computers, i);
            }
        }
        
        return answer;
    }
    public static void DFS(int[][] computers, int x){
        visited[x] = true;
        
       for(int j=0; j<computers.length; j++){
            if(computers[x][j] == 1 && !visited[j]){
                visited[j] = true;
                DFS(computers,j);
            }
       }
        
    }
}