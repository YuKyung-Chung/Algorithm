import heapq

def solution(N, road, K):
    answer = 0
    
    # 양방향 가중치 그래프 초기화
    graph = [[] for _ in range(N+1)]
    for a, b, c in road:
        graph[a].append((b, c))
        graph[b].append((a, c))
    
    # 최단거리 배열 초기화 (무한대로 설정)
    dist = [float('inf')] * (N+1)
    dist[1] = 0  # 출발 노드(1번 마을) 거리는 0
    
    # 힙에 (거리, 노드) 순서로 삽입 → 거리 기준 최소 힙 정렬
    heap = [(0, 1)]
    
    while heap:
        distance, node = heapq.heappop(heap)  # 현재 거리가 가장 짧은 노드 꺼내기
        
        # dist[node]보다 큰 거리로 저장된 건 이미 최단거리가 확정된 것 → 스킵
        if distance > dist[node]:
            continue
        
        # 인접 노드 탐색
        for next_node, d in graph[node]:
            new_d = distance + d  # 현재 노드를 거쳐서 가는 거리
            if new_d < dist[next_node]:  # 더 짧은 경로 발견 시 갱신
                dist[next_node] = new_d
                heapq.heappush(heap, (new_d, next_node))
    
    # 거리가 K 이하인 마을 수 카운트
    for d in dist[1:]:
        if d <= K:
            answer += 1
    
    return answer