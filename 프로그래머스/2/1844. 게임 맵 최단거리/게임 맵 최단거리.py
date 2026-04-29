from collections import deque
def solution(maps):
    answer = 0
    cnt = 0
    N = len(maps)
    M = len(maps[0])
    
    dx = [1,-1,0,0]
    dy = [0,0,1,-1]
    
    q = deque([(0,0,1)])
    visited = [[False]*M for _ in range(N)]
    visited[0][0] = True
    
    while q:
        x,y,dist = q.popleft()
        
        # 도착하면 거리반환
        if x == N-1 and y == M-1:
            return dist
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 0 <= nx < N and 0 <= ny < M:
                if not visited[nx][ny] and maps[nx][ny] == 1:
                    visited[nx][ny] = True
                    q.append((nx, ny, dist+1))
                    
        
    return -1