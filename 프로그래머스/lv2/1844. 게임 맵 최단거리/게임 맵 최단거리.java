import java.util.*;
class Solution {
    static int[][] A;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    public int solution(int[][] maps) {
        int answer = 0;
        visited = new boolean[maps.length][maps[0].length];
        A = new int[maps.length][maps[0].length];
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length; j++){
                A[i][j] = maps[i][j];
            }
        }
        BFS(0,0);
        answer = A[maps.length-1][maps[0].length-1];
        if(answer == 0 || answer == 1) 
            answer = -1;
        
        return answer;
    }
    public void BFS(int a, int b){
        visited[a][b] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {a,b});
        
        while(!q.isEmpty()){
            int[] temp = q.poll();
            for(int i=0; i<4; i++){
                int x = dx[i] + temp[0];
                int y = dy[i] + temp[1];
                if(x>=0 && y>=0 && x<A.length && y<A[0].length){
                    if(A[x][y] != 0 && !visited[x][y]){
                        visited[x][y] = true;
                        A[x][y] = A[temp[0]][temp[1]]+1;
                        q.add(new int[] {x,y});
                    }
                }
            }
        }
        
    }
}