from collections import deque

N,M = map(int, input().split())
maps = []
for i in range(N):
    maps.append(list(map(int, input().split())))

dx = [-1,1,0,0]
dy = [0,0,1,-1]
ans = 0

def checkIfSeperated():
    q = deque()
    visited = [[False] * M for _ in range(N)]
    cnt = 0

    for i in range(N):
        for j in range(M):
            if maps[i][j] != 0 and not visited[i][j]:
                # 빙산이 분리되었는지 확인
                q.append((i,j))
                visited[i][j] = True
                cnt += 1
                # 분리된 빙산이 2개 이상이면 종료
                if cnt >= 2:
                    break
                while q:
                    x,y = q.popleft()
                    for h in range(4):
                        nx = x + dx[h]
                        ny = y + dy[h]
                        if 0<=nx<N and 0<=ny<M and not visited[nx][ny] and maps[nx][ny] != 0:
                            visited[nx][ny] = True
                            q.append((nx,ny))
    return cnt

def melt():
    # 동시에 녹이기: 감소량 먼저 계산
    dec = [[0]*M for _ in range(N)]
    q = deque()
    for i in range(N):
        for j in range(M):
            if maps[i][j] != 0:
                sea = 0
                for h in range(4):
                    nx = i + dx[h]
                    ny = j + dy[h]
                    if maps[nx][ny] == 0:
                        sea += 1
                dec[i][j] = sea

    for i in range(N):
        for j in range(M):
            if maps[i][j] != 0:
                maps[i][j] = max(0, maps[i][j] - dec[i][j])



while True:
    comp = checkIfSeperated()
    if comp >= 2:
        print(ans)
        break
    if comp == 0:
        # 다 녹음
        print(0)
        break

    ans += 1
    melt()


