def solution(n, wires):
    answer = float('inf')
    graph = [[] for _ in range(n+1)]
    # 송전탑 연결 트리 만들기
    for wire in wires:
        a,b = wire
        graph[a].append(b)
        graph[b].append(a)
    
    
    def dfs(node, cut_a, cut_b, visited):
        visited[node] = True
        count = 1
        
        for next_node in graph[node]:
            # 끊은 전선이면 이동하지 않음
            if node == cut_a and next_node == cut_b:
                continue
                
            if node == cut_b and next_node == cut_a:
                continue
                
            if not visited[next_node]:
                count += dfs(next_node, cut_a, cut_b, visited)
        return count
    
    
    for cut_a, cut_b in wires:
        # a,b 전선 끊었다고 가정
        visited = [False] * (n+1)
        
        #a에서 DFS 시작
        # 단 a-b 연결은 못 지나가게 처리
        count = dfs(cut_a, cut_a, cut_b, visited)
        other_count = n - count
        
        # 두 전력망의 송전탑 개수 차이
        diff = abs(count - other_count)
        answer = min(answer, diff)
    return answer