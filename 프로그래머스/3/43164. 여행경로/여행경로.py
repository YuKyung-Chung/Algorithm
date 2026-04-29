def solution(tickets):
    answer = []
    tickets = sorted(tickets, key=lambda x:(x[0], x[1]))
    N = len(tickets)
    path = ["ICN"]
    visited = [False] * N
    
    def dfs(current):
        if len(path) == N+1:
            answer.append(path[:])
            return True
        
        for i in range(N):
            if not visited[i] and tickets[i][0] == current:
                visited[i] = True
                path.append(tickets[i][1])
                if dfs(tickets[i][1]):
                    return
                visited[i] = False
                path.pop()
    
    
    dfs("ICN")

    return answer[0]