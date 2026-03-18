N,M = map(int, input().split())
r,c,d = map(int, input().split())

# 북, 동,남, 서
dx = [-1,0,1,0]
dy = [0,1,0,-1]

maps = []
for i in range(N):
    maps.append(list(map(int, input().split())))

result = 0 # 로봇청소기가 청소하는 칸의 개수
cleaned = [[0]*M for _ in range(N)]

# 반시계방향으로 회전
def turnLeft(d):
    if d == 0:
        return 3
    else:
        return d-1

def start(x,y,d):
    global result
    # 현재 칸이 아직 청소되지 않은 경우, 청소하기
    if not cleaned[x][y]:
        cleaned[x][y] = 1
        result += 1

    # 주변 4칸 중 청소되지 않은 빈칸 없는 경우
    for i in range(4):
        d = turnLeft(d)
        nx = dx[d] + x
        ny = dy[d] + y

        if nx >= 0 and nx < N and ny >= 0 and ny <M:
            # 청소되지 않은 빈칸 있는 경우
            if not cleaned[nx][ny] and maps[nx][ny] == 0:
                start(nx, ny,d)
                return

    # 4방향 다 못갔을 때
    bx = x - dx[d]
    by = y - dy[d]

    if 0 <= bx < N and 0 <= by < M and maps[bx][by] == 0:
        start(bx, by,d)
    else:
        return


start(r, c,d)
print(result)
