def solution(tickets):
    answer = []
    tickets = sorted(tickets, key=lambda x:(x[0], x[1]))
    visited = [False] * len(tickets)
    
    
    curr = ''
    def dfs(path, count):
        if count == len(tickets):
            answer.append(path[:])
            return
        
        for i in range(len(tickets)):
            if not visited[i] and tickets[i][0] == path[-1]:
                visited[i] = True
                path.append(tickets[i][1])
                dfs(path, count+1)
                path.pop()
                visited[i] = False
        
    
    for i in range(len(tickets)):
        if tickets[i][0] == "ICN":
            visited[i] = True
            dfs(["ICN", tickets[i][1]], 1)
            visited[i] = False
        
    return answer[0]