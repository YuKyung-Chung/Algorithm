from collections import deque

def solution(maps):
    answer = -1
    q = deque()
    q.append((0,0,1))
    visited = [[False] * len(maps[0]) for _ in range(len(maps))]
    visited[0][0] = True
    dx = [0,0,1,-1]
    dy = [1,-1,0,0]
    
    while q:
        x,y,d = q.popleft()
        
        if x == (len(maps)-1) and y == (len(maps[0])-1):
            return d
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if nx >= 0 and nx < len(maps) and ny >= 0 and ny < len(maps[0]) and not visited[nx][ny] and maps[nx][ny] == 1:
                visited[nx][ny] = True
                q.append((nx, ny, d+1))
    
    return answer