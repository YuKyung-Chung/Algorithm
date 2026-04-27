import heapq

def solution(n, edge):
    answer = 0
    
    # 양방향 가중치 없는 그래프
    graph = [[] for _ in range(n+1)]
    for a, b in edge:
        graph[a].append(b)
        graph[b].append(a)
        
    # 다익스트라
    dist = [float('inf')] * (n+1)
    dist[1] = 0
    heap = [(0,1)] # (거리, 노드)
    
    while heap:
        distance, node = heapq.heappop(heap)
    	
        for next_node in graph[node]:
            new_d = distance + 1 # 가중치 없으니까 1씩 증가
            if new_d < dist[next_node]:
                dist[next_node] = new_d
                heapq.heappush(heap, (new_d, next_node))
        
    max_dist = max(dist[1:])
    answer = sum(1 for d in dist[1:] if d == max_dist)
    return answer