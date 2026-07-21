from collections import deque

def find(S):
    q = deque()
    q.append((S,0))

    while q:
        a,dist = q.popleft()

        if a == G:
            return dist

        for n in arr[a]:
            if not visited[n]:
                visited[n] = True
                q.append((n,dist+1))

    return 0

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    V, E = map(int, input().split())
    arr = [[] for _ in range(V+1)]
    for i in range(E):
        a, b = map(int, input().split())
        arr[a].append(b)
        arr[b].append(a)

    visited = [False] * (V+1)
    # 출발노드, 도착노드
    S, G = map(int, input().split())
    visited[S] = True
    print('#' + str(test_case), find(S))