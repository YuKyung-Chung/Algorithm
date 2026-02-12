from collections import deque

M,N,H = map(int, input().split()) # 가로, 세로, 높이
box = []
# ----- 6방향 -----
dz = [0,0,0,0,1,-1]
dx = [0,0,1,-1,0,0]
dy = [1,-1,0,0,0,0]

# ----- 입력 받기 -----
for h in range(H):
    layer = []
    for n in range(N):
        row = list(map(int, input().split()))
        layer.append(row)
    box.append(layer)

# ----- 익은 토마토 전부 큐에 넣기 -----
q = deque()

for h in range(H):
    for n in range(N):
        for m in range(M):
            if box[h][n][m] == 1:
                q.append([h,n,m])

# ----- BFS 수행 ----- 
while q:
    z, x, y = q.popleft()
    for i in range(6):
        nz = z + dz[i]
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nz < H and 0 <= nx < N and 0 <= ny < M:
            if box[nz][nx][ny] == 0:
                box[nz][nx][ny] = box[z][x][y] + 1
                q.append([nz,nx,ny])

# ----- 결과 계산 -----
ans = 0
for z in range(H):
    for x in range(N):
        for y in range(M):
            if box[z][x][y] == 0:
                print(-1)
                exit()
            ans = max(ans, box[z][x][y])

print(ans - 1)
