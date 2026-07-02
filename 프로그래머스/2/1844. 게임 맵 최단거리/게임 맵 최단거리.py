from collections import deque
def solution(maps):
    dx = [1,-1,0,0]
    dy = [0,0,1,-1]
    
    n = len(maps) # 행개수
    m = len(maps[0]) # 열개수
    visited = [[False]*m for _ in range(n)]
    q = deque()
    q.append((0,0,1))
    visited[0][0] = True
    
    while q:
        x,y,d = q.popleft()
        
        if x == n-1 and y == m-1:
            return d
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 0 <= nx < n and 0 <= ny < m:
                if not visited[nx][ny] and maps[nx][ny] == 1:
                    visited[nx][ny] = True
                    q.append((nx, ny, d + 1))
    
    return -1