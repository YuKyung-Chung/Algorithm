import java.util.*;
class Solution {
    static ArrayList<ArrayList<Integer>> graph;
    static int[][] dp;
    static boolean[] visited;
    public int solution(int n, int[][] lighthouse) {
        int answer = 0;
        
        //그래프 만들기
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        //양방향 간선 추가
        for(int[] i : lighthouse){
            int a = i[0];
            int b = i[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        dp = new int[n+1][2]; //0: 꺼짐, 1:켜짐
        visited = new boolean[n+1];
        
        dfs(1); //1번 노드부터 실행
        
        return Math.min(dp[1][0], dp[1][1]);
    }
    
    public static void dfs(int node){
        visited[node] = true;
        
        //초기값 : 현재 노드가 켜진 상태
        dp[node][1] = 1;
        
        for(int next : graph.get(node)){
            if(!visited[next]){
                dfs(next);
                
                //내가 꺼져 있으면 자식꺼는 무조건 켜져 있어야 함
                dp[node][0] += dp[next][1];
                
                //내가 켜져있으면 자식은 켜져 있어도 꺼져 있어도 돼서 작은거
                dp[node][1] += Math.min(dp[next][1], dp[next][0]);                
            }
        }
    }
}