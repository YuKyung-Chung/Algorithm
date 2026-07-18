T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    V, E  = map(int, input().split())
    graph = [[] for _ in range(V+1)]
    for _ in range(E):
        a, b = map(int, input().split())
        graph[a].append(b)

    answer = 0
    visited = [False] * (V+1)
    visited[0] = True
    def find(start, end, graph, visited):
        visited[start] = True

        if start == end:
            return 1

        for i in graph[start]:
            if not visited[i]:
                if find(i, end, graph, visited):
                    return 1

        return 0

    # 출발 노드 , 도착 노드
    S, G = map(int, input().split())
    print('#'+str(test_case), find(S, G, graph, visited))