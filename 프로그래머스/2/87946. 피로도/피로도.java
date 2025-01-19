class Solution {
    static boolean[] visited;
    static int dlength;
    static int maxCount;
    public int solution(int k, int[][] dungeons) {
        dlength = dungeons.length;
        visited = new boolean[dlength];
        dfs(0, 0, k, visited, dungeons);
        
        return maxCount;
    }
    
    public static void dfs(int i, int answer, int k, boolean[] visited, int[][] dungeons){
        
        // 현재 탐험한 던전 수를 최댓값과 비교
        maxCount = Math.max(maxCount, answer);
        
        for(int j=0; j<dlength; j++){
            if(!visited[j] && k >= dungeons[j][0]){
                visited[j] = true;
                dfs(j, answer+1, k-dungeons[j][1], visited, dungeons);
                visited[j] = false;
            }
        }
    }
}