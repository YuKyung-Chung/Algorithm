# 각 지점에서 목표지점까지의 거리를 출력한다.
# 원래 갈 수 없는 땅인 위치는 0을 출력
# 원래 갈 수 있는 땅인 부분 중에서 도달할 수 없는 위치는 -1을 출력
from collections import deque

N,M = map(int, input().split()) # N: 세로행, M: 가로열

grid = []
sx = sy = -1

for i in range(N):
    row = list(map(int, input().split()))
    grid.append(row)
    for j in range(M):
        if row[j] == 2:
            sx, sy = i, j # 시작 좌표

# dist 초기화
# 원래 0인곳은 0출력
# 원래 1인곳: 도달 못하면 -1 유지
# 목표 2: 0
dist = [[0] * M for _ in range(N)]
for i in range(N):
    for j in range(M):
        if grid[i][j] == 1:
            dist[i][j] = -1

# BFS
q = deque([(sx, sy)])
dist[sx][sy] = 0

dx = [-1,1,0,0]
dy = [0,0,1,-1]

while q:
    x, y = q.popleft()
    for k in range(4):
        nx, ny = x + dx[k], y + dy[k]
        if 0 <= nx < N and 0 <= ny < M:
            if grid[nx][ny] == 1 and dist[nx][ny] == -1:
                dist[nx][ny] = dist[x][y] + 1
                q.append((nx, ny))

# 출력
out = []
for i in range(N):
    out.append(' '.join(map(str, dist[i])))
print('\n'.join(out))


