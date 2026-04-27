def solution(n, results):
    answer = 0
    
    win = [[0]*(n+1) for _ in range(n+1)]
    for a, b in results:
        win[a][b] = 1
        
    #플로이드 워셜
    for k in range(1, n+1):
        for i in range(1, n+1):
            for j in range(1, n+1):
                if win[i][k] and win[k][j]:
                    win[i][j] =1
    
    for i in range(1, n+1):
        count = 0
        for j in range(1, n+1):
            if win[i][j] or win[j][i]: #승패가 알려진 경우
                count +=1
        if count == n-1:
            answer += 1
    
    
    return answer