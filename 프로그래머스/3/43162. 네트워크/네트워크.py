def solution(n, computers):
    answer = 0
    visited = [False]*n
    
    def dfs(node):
        nonlocal answer
        visited[node] = True
        
        for i in range(n):
            if computers[node][i] == 1 and not visited[i]:
                dfs(i)
                
    
    for i in range(n):
        if not visited[i]:
            dfs(i)
            answer += 1
    
    return answer