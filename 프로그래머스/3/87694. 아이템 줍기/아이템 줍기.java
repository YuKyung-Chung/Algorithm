import java.util.*;

class Solution {
    static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        //맵의 크기 두배로 늘리기
        int maxCoord = 102;
        boolean[][] map = new boolean[maxCoord][maxCoord];
        
        // 직사각형 영역을 표시하고, 내부 공간을 비웁니다.
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2, y1 = rect[1] * 2, x2 = rect[2] * 2, y2 = rect[3] * 2;
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    map[i][j] = true;
                }
            }
        }
        
        // 기존 직사각형에서 테두리만 남기고 내부 공간 false 처리로 비우기
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2 + 1, y1 = rect[1] * 2 + 1, x2 = rect[2] * 2 - 1, y2 = rect[3] * 2 - 1;
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    map[i][j] = false;
                }
            }
        }
        
        return bfs(map, characterX * 2, characterY * 2, itemX * 2, itemY * 2);
    }//end of solution
    
    private int bfs(boolean[][] map, int startX, int startY, int endX, int endY) {
        int maxCoord = 102;
        boolean[][] visited = new boolean[maxCoord][maxCoord];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{startX, startY, 0});
        visited[startX][startY] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], dist = current[2];
            
            //도착지점에 도착하면 값을 반으로 나눠서 출력
            if (x == endX && y == endY) {
                return dist / 2;
            }
            
            //4방향으로 탐색하기
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                
                //경계조건 만족하는지 체크하기
                if (newX >= 0 && newX < maxCoord && newY >= 0 && newY < maxCoord 
                    && map[newX][newY] && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY, dist + 1});
                }
            }
        }
        return -1;
    }//end of bfs
}
