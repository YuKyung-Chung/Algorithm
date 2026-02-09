from collections import deque

N, M, V = map(int, input().split())

# 1. 그래프 생성
graph = [[] for _ in range(N+1)]

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

# 2. 정점 번호가 작은 것부터 방문해야 하므로 정렬
for i in range(1, N+1):
    graph[i].sort()

#---------DFS---------
visited = [False] * (N+1)
def dfs(v):
    visited[v] = True
    print(v, end = ' ')
    for nxt in graph[v]:
        if not visited[nxt]:
            dfs(nxt)
dfs(V)
print()

#---------BFS---------
visited = [False] * (N+1)

def bfs(start):
    q = deque([start])
    visited[start] = True

    while q:
        v = q.popleft()
        print(v, end = ' ')
        for nxt in graph[v]:
            if not visited[nxt]:
                visited[nxt] = True
                q.append(nxt)

bfs(V)