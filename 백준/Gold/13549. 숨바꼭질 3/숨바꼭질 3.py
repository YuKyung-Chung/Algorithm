# 다익스트라
from collections import deque

N,K = map(int, input().split())
MAX = 100001
dist = [-1] * MAX
queue = deque([N])
dist[N] = 0

while queue:
    now = queue.popleft()

    if now == K:
        print(dist[now])
        break

    if 0<= now * 2 < MAX and dist[now*2] == -1:
        dist[now*2] = dist[now]
        queue.appendleft(now*2)

    # 걷기 (비용 1)
    for next_pos in (now-1, now+1):
        if 0 <= next_pos < MAX and dist[next_pos] == -1:
            dist[next_pos] = dist[now] + 1
            queue.append(next_pos) # 덱의 뒤에 삽입