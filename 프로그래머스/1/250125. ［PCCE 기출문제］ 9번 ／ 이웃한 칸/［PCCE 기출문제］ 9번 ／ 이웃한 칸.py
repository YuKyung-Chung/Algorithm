def solution(board, h, w):
    answer = 0
    dx = [1,-1,0,0]
    dy = [0,0,1,-1]
    
    for i in range(4):
        # 4방향으로 움직이기
        nx = dx[i] + h
        ny = dy[i] + w
        
        if(nx >=0 and ny >=0 and nx < len(board) and ny < len(board)):
            if board[nx][ny] == board[h][w]:
                answer += 1
    
    return answer