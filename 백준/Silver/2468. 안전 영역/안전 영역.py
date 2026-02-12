from collections import deque

N = int(input())
maps = []
for _ in range(N):
    maps.append(list(map(int, input().split())))
max_h = max(map(max, maps))

dx = [0,0,1,-1]
dy = [1,-1,0,0]
def bfs(x,y,h,visited):
    q = deque()
    q.append((x,y))
    visited[x][y] = True

    while q:
        x,y = q.popleft()
        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]

            if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny] and maps[nx][ny] > h:
                visited[nx][ny] = True
                q.append((nx,ny))

ans = 0
for h in range(0, max_h):
    visited = [[False] * N for _ in range(N)]
    cnt = 0

    for i in range(N):
        for j in range(N):
            if maps[i][j] > h and not visited[i][j]:
                bfs(i,j,h,visited)
                cnt += 1

    ans = max(ans, cnt)

print(ans)