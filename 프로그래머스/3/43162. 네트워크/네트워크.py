def solution(n, computers):
    answer = 0
    visited = [False] * (n)
    
    def dfs(node):
        visited[node] = True
        
        for next_node in range(n):
            # 연결되어 있고, 아직 방문하지 않았다면 방문
            if computers[node][next_node] == 1 and not visited[next_node]:
                dfs(next_node)
    
    for i in range(n):
        if not visited[i]:
            answer += 1
            dfs(i)
    
    
    return answer