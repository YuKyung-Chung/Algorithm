import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n+1][m+1];
        int MOD = 1000000007;
        boolean[][] visited = new boolean[n+1][m+1];
        
        for(int[] puddle : puddles){
            visited[puddle[1]][puddle[0]] = true; //웅덩이 체크
        }
        
        dp[1][1] = 1; //시작점 초기화
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(visited[i][j] == true){
                    continue;
                }
                dp[i][j] += dp[i - 1][j] + dp[i][j - 1];
                dp[i][j] %= MOD;
            }
        }
        
        return dp[n][m];
    }
}