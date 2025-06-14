def solution(k, dungeons):
    answer = -1
    visited = [False] * len(dungeons)
    count = 0
    
    def explore(dungeons, visited, count, k):
        max_count = count # 현재까지의 최대값 저장
        for j in range(len(dungeons)):
            if not visited[j] and dungeons[j][0] <= k:
                visited[j] = True
                max_count = max(max_count, explore(dungeons, visited, count+1, k - dungeons[j][1]))
                visited[j] = False
           
        return max_count
    
    for i in range(len(dungeons)):
        answer = max(answer, explore(dungeons, visited, 0, k))
        
    return answer