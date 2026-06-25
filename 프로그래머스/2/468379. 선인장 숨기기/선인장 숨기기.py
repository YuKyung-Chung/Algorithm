from collections import deque

def solution(m, n, h, w, drops):
    INF = float('inf')
    rain = [[INF] * n for _ in range(m)]
    
    for i, (r,c) in enumerate(drops):
        rain[r][c] = i+1
            
    # 1. 각 행마다 가로 w칸 최솟값
    row_min = [[0] * (n-w+1) for _ in range(m)]
    
    for r in range(m):
        dq = deque() # 인덱스 저장
        
        for c in range(n):
            while dq and rain[r][dq[-1]] >= rain[r][c]:
                dq.pop()
            dq.append(c)
            
            if dq[0] <= c - w:
                dq.popleft()
            
            # 윈도우 크기가 w가 되었으므로 최솟값 기록
            if c >= w-1:
                row_min[r][c-w+1] = rain[r][dq[0]]
                
    # 2. 세로 h칸 최솟값 + 정답 찾기    
    score_map = [[0] * (n-w+1) for _ in range(m-h+1)]
    # w 크기만큼 줄어들었음
    for c in range(n-w+1):
        dq = deque()
        
        for r in range(m):
            while dq and row_min[dq[-1]][c] >= row_min[r][c]:
                dq.pop()
            dq.append(r)
            
            if dq[0] <= r-h:
                dq.popleft()
            
            # 윈도우 크기가 h가 되었으므로 최솟값 기록
            if r >= h-1:
                top_row = r-h+1
                score_map[top_row][c] = row_min[dq[0]][c]
                
    # 행 우선으로 가장 좋은 위치 찾기
    best_score = -1
    best_row = 0
    best_col = 0
    
    for r in range(m-h+1):
        for c in range(n-w+1):
            # score_map에서 가장 큰 값의 좌표 저장
            if score_map[r][c] > best_score:
                best_score = score_map[r][c]
                best_row = r
                best_col = c
    
    return [best_row, best_col]