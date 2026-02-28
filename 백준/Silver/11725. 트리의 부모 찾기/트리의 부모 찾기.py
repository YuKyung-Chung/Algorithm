from collections import deque

N = int(input())
# 인접 리스트로 무방향 트리 그래프 구성
tree = [[] for _ in range(N+1)]

for _ in range(N-1):
    a,b = map(int, input().split())
    tree[a].append(b)
    tree[b].append(a)

parent = [0] * (N+1)
visited = [False] * (N+1)

q = deque([1])
visited[1] = True

while q:
    cur = q.popleft()
    for next_node in tree[cur]:
        if not visited[next_node]:
            visited[next_node] = True
            parent[next_node] = cur
            q.append(next_node)

for i in range(2, N+1):
    print(parent[i])