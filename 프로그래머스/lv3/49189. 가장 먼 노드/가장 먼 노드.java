import java.io.*;
import java.util.*;

class Solution {
    static List<Integer>[] list;
    static int cnt,answer;
    static int[] dist;
    
    public int solution(int n, int[][] edge) {
        answer = 0;
        list = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<edge.length; i++){
            int a = edge[i][0];
            int b = edge[i][1];
            
            list[a].add(b);
            list[b].add(a);
            
        }
        
        dist = new int[n+1];
        BFS(1,n);
        
        for(int i=1; i<=n; i++){
            if(dist[i] == cnt-1){
                answer++;
            }
        }
       System.out.println(Arrays.toString(dist));
        System.out.println(cnt);
        return answer;
    }
    
    public static void BFS(int start,int n){
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        dist[start] = cnt;
        
        while(!q.isEmpty()){
            int a = q.size();
            for(int k=0; k<a; k++){
                int cur = q.poll();
                
                // System.out.println(cnt+"번째" +cur);
                for(int i : list[cur]){
                    if(!visited[i]){
                        visited[i] = true;
                        dist[i] = cnt+1;
                        q.add(i);
                    }
                    
                }  
                
            }
            // System.out.println(q.toString());
            cnt++;
            
        }
    }
}