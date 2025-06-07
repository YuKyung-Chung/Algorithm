def solution(begin, target, words):
    answer = float('INF')
    visited = [False] * len(words)
    
    def dfs(begin, target, count):
        nonlocal answer
        if begin == target:
            answer = min(answer, count)
            return
        
        for i in range(len(words)):
            cnt = 0
            for j in range(len(words[0])):
                if words[i][j] == begin[j]:
                    cnt += 1
            if cnt == len(begin)-1 and not visited[i]:
                visited[i] = True
                dfs(words[i], target, count+1)
                visited[i] = False
                
    if target not in words:
        return 0
    
    dfs(begin, target, 0)
    
    return answer