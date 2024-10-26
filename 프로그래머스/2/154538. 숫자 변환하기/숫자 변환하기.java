import java.util.*;
class Solution {
    static int answer = 0;
    public int solution(int x, int y, int n) {

        bfs(x, y, n);
        
        return answer;
    }
    
    public void bfs(int x, int y, int n){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,0});
        
        boolean[] visited = new boolean[y+1];
        
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int now = tmp[0]; //현재 수
            int cnt = tmp[1]; //연산 횟수
            
            if(now == y){
                answer = cnt;
                return;
            }
            
            if(now + n <= y && !visited[now+n]){
                q.add(new int[]{now+n, cnt+1});
                visited[now+n] = true;
            }
            if(now * 2 <= y && !visited[now*2]){
                q.add(new int[]{now*2, cnt+1});
                visited[now*2] = true;
            }
            if(now * 3 <= y && !visited[now*3]){
                q.add(new int[]{now*3, cnt+1});
                visited[now*3] = true;
            }
            
        }
        
        answer = -1;
        return;
        
    }
}