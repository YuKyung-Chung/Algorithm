import heapq

def solution(N, road, K):
    answer = 0

    # 양방향 가중치 그래프
    graph = [[] for _ in range(N+1)]
    for a, b, c in road:
        graph[a].append((b,c))
        graph[b].append((a,c))
        
    
    # 다익스트라
    dist = [float('inf')] * (N+1)
    dist[1] = 0 # 1번 노드 거리는 0
    heap = [(1,0)] #(노드, 거리)
    
    while heap:
        node, distance = heapq.heappop(heap)
        
        if distance > dist[node]:
            continue
        
        for next_node, d in graph[node]:
            new_d = d + distance
            if new_d < dist[next_node]:
                dist[next_node] = d + distance
                heapq.heappush(heap, (next_node, d+distance))

    for d in dist[1:]:
        if d <= K:
            answer += 1
    return answer