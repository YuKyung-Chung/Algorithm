from collections import deque

def solution(maps):
    n = len(maps)
    m = len(maps[0])
    
    # 방향: 동, 서, 남, 북
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    
    def bfs(x, y):
        queue = deque()
        queue.append((x, y))
        
        while queue:
            x, y = queue.popleft()
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                
                # 범위 벗어나면 무시
                if nx < 0 or ny < 0 or nx >= n or ny >= m:
                    continue
                
                # 벽이거나 이미 방문한 칸이면 무시
                if maps[nx][ny] == 0 or maps[nx][ny] != 1:
                    continue
                
                # 최단 거리 누적 저장
                maps[nx][ny] = maps[x][y] + 1
                queue.append((nx, ny))
        
        # 도착지에 도달 못했으면 여전히 1일 것이므로 예외 처리 필요
        return maps[n - 1][m - 1]

    result = bfs(0, 0)
    return result if result != 1 else -1
