from collections import deque

def solution(maps):
    answer = 0
    dx = [0,0,1,-1]
    dy = [1,-1,0,0]
    rows = len(maps)
    cols = len(maps[0])
    
    def bfs(i, j, target):
        queue = deque()
        queue.append((i,j,0))
        visited = [[False]*cols for _ in range(rows)]
        visited[i][j] = True
        
        while queue:
            r,c,dist = queue.popleft()
            
            if maps[r][c] == target:
                return dist
            
            for k in range(4):
                nx = dx[k] + r
                ny = dy[k] + c
                
                # 유효성 검사
                if(nx >= 0 and ny >=0 and nx < rows and ny < cols and maps[nx][ny] != 'X' and not visited[nx][ny]):
                    visited[nx][ny] = True
                    queue.append((nx, ny, dist+1))
        return -1
    
    for i in range(len(maps)):
        for j in range(len(maps[i])):
            # 출발점에서 레버까지
            if maps[i][j] == 'S':
                start_r = i
                start_c = j
                
            if maps[i][j] == 'L':
                end_r = i
                end_c = j
                
    dist_to_lever = bfs(start_r,start_c,'L')          
    dist_to_end = bfs(end_r, end_c,'E')
    
    # 둘 중 하나라도 -1이면 탈출 불가
    if dist_to_lever == -1 or dist_to_end == -1:
        answer = -1
    else:
        answer = dist_to_lever + dist_to_end
                    
    return answer