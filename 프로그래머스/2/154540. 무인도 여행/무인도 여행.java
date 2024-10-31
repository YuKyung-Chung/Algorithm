import java.util.*;

class Solution {
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static char[][] map;
    static int rows, cols;
    
    public int[] solution(String[] maps) {
        
        rows = maps.length;
        cols = maps[0].length();
        map = new char[rows][cols];
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                map[i][j] = maps[i].charAt(j);
            }
        }
        
        List<Integer> list = new ArrayList<>();
        visited = new boolean[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(!visited[i][j] && map[i][j] != 'X'){
                    list.add(BFS(i,j));
                }
            }
        }
        Collections.sort(list); //오름차순 정렬
        
        int[] answer;
        if(list.isEmpty()){
            return new int[]{-1};
        }else{
            answer = list.stream().mapToInt(i -> i).toArray();
        }
        
        return answer;
    }//end of Main
    
    public int BFS(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        
        int sum = 0;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            sum += map[now[0]][now[1]] - '0'; // 현재 위치의 자원량을 더하기
            
            //4방향으로 이동
            for(int i=0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= rows || ny >= cols) continue;
                
                if(map[nx][ny] == 'X' || visited[nx][ny]) continue;
                
                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
                
            }
        }
        
        return sum;
    }
}