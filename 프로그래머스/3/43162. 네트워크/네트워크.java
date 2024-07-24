import java.util.*;

class Solution {
    static ArrayList<Integer>[] list;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        list = new ArrayList[n];
        
        for(int i=0; i<n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(computers[i][j] == 1){
                    list[i].add(j);
                    list[j].add(i);
                }
            }
        }
        
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(!visited[i]){
                answer++;
                dfs(visited, i);
            }
        }
        
        return answer;
    }
    private static void dfs(boolean[] visited, int x){
        visited[x] = true;
        
        for(int i : list[x]){
            if(!visited[i])
                dfs(visited, i);
        }
    }
}