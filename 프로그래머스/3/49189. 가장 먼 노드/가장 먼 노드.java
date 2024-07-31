import java.util.*;
import java.io.*;

class Solution {
    static ArrayList<Integer>[] list;
    public int solution(int n, int[][] edge) {
        list = new ArrayList[n+1];
        int answer = 0;
        boolean[] visited = new boolean[n+1];
        int[] distance = new int[n+1];
        
        for(int i=0; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<edge.length; i++){
            list[edge[i][0]].add(edge[i][1]);
            list[edge[i][1]].add(edge[i][0]);
        }
        
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int i : list[now]){
                if(!visited[i]){
                    visited[i] = true;
                    distance[i] = distance[now] + 1;
                    q.add(i);
                }
            }
        }
        
        //가장 먼 거리 찾기
        int maxDist = -1;
        for(int i : distance){
            maxDist = Math.max(maxDist, i);
        }
        
        //먼 거리에 해당하는 노드 개수 세기
        for(int i=0; i<=n; i++){
            if(distance[i] == maxDist)
                answer++;
        }
        return answer;
    }
}