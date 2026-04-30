from collections import deque

def solution(rectangle, characterX, characterY, itemX, itemY):
    answer = 0
    board = [[0]*101 for _ in range(101)]
    characterX, characterY, itemX, itemY = characterX*2, characterY*2, itemX*2, itemY*2
    
    for x1, y1, x2, y2 in rectangle:
        x1, y1, x2, y2 = x1*2, y1*2, x2*2, y2*2
        
        for x in range(x1, x2+1):
            board[x][y1] = 1
            board[x][y2] = 1
            
        for y in range(y1, y2+1):
            board[x1][y] = 1
            board[x2][y] = 1
            
    for x1, y1, x2, y2 in rectangle:
        x1, y1, x2, y2 = x1*2, y1*2, x2*2, y2*2
        
        # 변 표시 후 내부를 0으로 지움
        for x in range(x1+1, x2):
            for y in range(y1+1, y2):
                board[x][y] = 0  # 내부는 이동 불가
                
                
    # print(board)
    q = deque([(characterX, characterY,1)])
    board[characterX][characterY] = 0
    dx = [0,0,1,-1]
    dy = [1,-1,0,0]
    while q:
        x, y, dist = q.popleft()
        if x == itemX and y == itemY:
            return dist//2
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 0<=nx<len(board) and 0<=ny<len(board[0]) and board[nx][ny] == 1:
                board[nx][ny] = 0 # 방문처리
                q.append((nx,ny,dist+1))
    
    # return answer