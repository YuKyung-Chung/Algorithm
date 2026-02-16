from collections import deque

N, M = map(int, input().split())
x, y, d = map(int, input().split())
room = [list(map(int, input().split())) for _ in range(N)]

# d: 0북 1동 2남 3서
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

q = deque()
q.append((x, y, d))

ans = 0

while q:
    x, y, d = q.popleft()

    # 1) 현재 칸 청소(0이면 청소해서 2로 변경)
    if room[x][y] == 0:
        room[x][y] = 2
        ans += 1

    found = False

    # 3) 주변 4방향 탐색: 왼쪽 회전 -> 앞칸이 0이면 전진 후 1번으로
    for _ in range(4):
        d = (d + 3) % 4  # 반시계(왼쪽) 회전
        nx = x + dx[d]
        ny = y + dy[d]

        if room[nx][ny] == 0:
            q.append((nx, ny, d))  # 다음 상태 큐에 넣고
            found = True
            break

    # 2) 청소되지 않은 빈칸이 주변에 없으면 후진
    if not found:
        back = (d + 2) % 4
        bx = x + dx[back]
        by = y + dy[back]

        # 뒤가 벽이면 종료
        if room[bx][by] == 1:
            break

        # 후진은 방향 유지
        q.append((bx, by, d))

print(ans)
