class Solution {
    private int maxDungeons = 0; // 최대 탐험할 수 있는 던전 수
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length]; // 던전 방문 여부 체크 배열
        explore(k, dungeons, visited, 0);
        return maxDungeons;
    }
    
    private void explore(int k, int[][] dungeons, boolean[] visited, int count) {
        // 현재 탐험한 던전 수로 최대값 갱신
        maxDungeons = Math.max(maxDungeons, count);

        for (int i = 0; i < dungeons.length; i++) {
            // 던전을 아직 방문하지 않았고, 최소 필요 피로도를 만족하는 경우
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true; // 던전 방문 표시
                explore(k - dungeons[i][1], dungeons, visited, count + 1); // 재귀 호출
                visited[i] = false; // 방문 표시 해제
            }
        }
    }
}