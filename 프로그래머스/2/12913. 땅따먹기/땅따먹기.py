def solution(land):
    answer = 0
    n = len(land) # 행
    m = len(land[0]) # 열
    
    for row in range(1, n):
        for col in range(m):
            prev_sum = 0
            
            for prev_col in range(m):
                if prev_col == col:
                    continue
                    
                # 이전행의 다른 열 중 가장 큰 값
                prev_sum = max(prev_sum, land[row-1][prev_col])
                
            land[row][col] += prev_sum

    return max(land[n-1])