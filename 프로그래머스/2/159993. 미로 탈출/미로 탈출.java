import java.util.*;

class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int rows, cols;
    
    public int solution(String[] maps) {
        rows = maps.length;
        cols = maps[0].length();
        
        int startX = 0, startY = 0;
        int leverX = 0, leverY = 0;
        
        // 시작점과 레버 위치 찾기
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maps[i].charAt(j) == 'S') {
                    startX = i;
                    startY = j;
                } else if (maps[i].charAt(j) == 'L') {
                    leverX = i;
                    leverY = j;
                }
            }
        }
        
        // S에서 L까지 최단 거리 찾기
        int startToLever = bfs(maps, startX, startY, 'L');
        if (startToLever == -1) {
            return -1;
        }
        
        // L에서 E까지 최단 거리 찾기
        int leverToExit = bfs(maps, leverX, leverY, 'E');
        if (leverToExit == -1) {
            return -1;
        }
        
        return startToLever + leverToExit;
    }
    
    private int bfs(String[] maps, int startX, int startY, char target) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];
            
            if (maps[x].charAt(y) == target) {
                return distance;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 배열 범위 내에 있고 벽이 아니며 방문하지 않은 경우만 이동
                if (nx >= 0 && ny >= 0 && nx < rows && ny < cols &&
                    !visited[nx][ny] && maps[nx].charAt(ny) != 'X') {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, distance + 1});
                }
            }
        }
        return -1;
    }
}
