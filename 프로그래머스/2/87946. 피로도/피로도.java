class Solution {
    static int maxCount = -1;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        explore(k, dungeons, visited, 0);
        return maxCount;
    }
    
    public void explore(int k, int[][] dungeons, boolean[] visited, int count){
        //최대 탐험 개수 갱신
        maxCount = Math.max(maxCount, count);
        
        for(int i=0; i< dungeons.length; i++){
            //최소 필요 피로도 이상이고, 아직 방문하지 않았다면 탐험 가능
            if(k >= dungeons[i][0] && !visited[i]){
                visited[i] = true;
                explore(k-dungeons[i][1], dungeons, visited, count+1);
                visited[i] = false;
            }
        }
        
    }
}