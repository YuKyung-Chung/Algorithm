from collections import deque

def bfs(a,b):
    q.append((a,b))
    visited[a][b] = True

    while q:
        x, y = q.popleft()

        if arr[x][y] == 3:
            return 1

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < N and 0 <= ny < N and arr[nx][ny] != 1 and not visited[nx][ny]:
                visited[nx][ny] = True
                q.append((nx,ny))
    return 0


T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N = int(input())
    visited = [[False] * N for _ in range(N)]
    arr = []
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    q = deque()
    answer = 0

    for _ in range(N):
        arr.append(list(map(int, input().strip())))

    # 2에서 출발, 도착은 3, 0은 통로, 1은 벽
    for i in range(N):
        for j in range(N):
            if arr[i][j] == 2:
                answer = bfs(i,j)
                break

    print('#'+str(test_case), answer)