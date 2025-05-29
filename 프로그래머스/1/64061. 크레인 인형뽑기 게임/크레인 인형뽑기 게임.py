def solution(board, moves):
    answer = 0
    n = len(board)
    dolls = []
    
    for move in moves:
        for i in range(n):
            if(board[i][move-1] != 0):
                picked = board[i][move-1]
                board[i][move-1] = 0
                
                if (dolls and dolls[-1] == picked):
                    dolls.pop()
                    answer += 2
                else:
                    dolls.append(picked)
                break # 인형 하나 집었으면 다음 move로 이동
    
    return answer