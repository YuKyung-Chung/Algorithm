from collections import deque

F, S, G, U, D = map(int, input().split())
# F : 총 층수, S: 현재 있는 층, G: 도착해야할 층, U: 위로 갈수있는 칸, D: 아래로 갈수있는 칸

q = deque()
q.append((S,0))
visited = [False] * (F+1)
visited[S] = True

while q:
    now, cnt = q.popleft()

    if now == G:
        print(cnt)
        break

    # 위로 이동
    if 1 <= now + U <= F and not visited[now+U]:
        visited[now+U] = True
        q.append((now+U,cnt+1))

    # 아래로 이동
    if 1 <= now - D <= F and not visited[now-D]:
        visited[now-D] = True
        q.append((now-D,cnt+1))
else:
    print("use the stairs")