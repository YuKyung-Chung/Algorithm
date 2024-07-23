import java.util.*;
import java.io.*;

class Solution {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] visited;
    static int end_x, end_y;
    
    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        end_x = maps.length-1;
        end_y = maps[0].length-1;
        
        return bfs(maps, visited, 0, 0);
    }
    
    private static int bfs(int[][] maps, boolean[][] visited, int x ,int y){
        int steps = 1;
        visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y});
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int j=0; j<size; j++){
                int[] now = q.poll();
            
                if (now[0] == end_x && now[1] == end_y) {
                    return steps;
                }
            
                //4방향 탐색
                for(int i=0; i<4; i++){
                    int nx = now[0] + dx[i];
                    int ny = now[1] + dy[i];
                    if(nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length
                    || visited[nx][ny]) continue;
                
                    if(maps[nx][ny] == 1 && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        q.add(new int[] {nx, ny});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}