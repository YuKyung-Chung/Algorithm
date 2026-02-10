from collections import deque

N = int(input()) # 전체 사람 수
a, b = map(int, input().split()) # 촌수 계산해야 하는 두 사람 번호
M = int(input()) # 부모 자식간 관계 수
relations = [[] for _ in range(N+1)]
for _ in range(M):
    x, y = map(int, input().split())
    relations[x].append(y)
    relations[y].append(x)


# ------------DFS--------------
# visited = [False] * (N+1)
# def dfs(cur, dist):
#     if cur == b:
#         return dist
#
#     visited[cur] = True
#     for nxt in relations[cur]:
#         if not visited[nxt]:
#             res = dfs(nxt, dist + 1)
#             if res != -1:
#                 return res
#     return -1
#
# print(dfs(a, 0))

# ------------BFS---------------
visited = [False] * (N+1)
q = deque()

q.append((a,0)) #(현재 사람, 촌수)
visited[a] = True

ans = -1
while q:
    cur, dist = q.popleft()
    if cur == b:
        ans = dist
        break
    for x in relations[cur]:
        if not visited[x]:
            visited[x] = True
            q.append((x, dist+1))
print(ans)