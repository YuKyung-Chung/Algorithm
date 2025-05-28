def solution(lottos, win_nums):
    min_win = 0 # 당첨 가능한 최소 개수
    max_win = 0 # 당첨 가능한 최대 개수
    
    for i in lottos:
        if i != 0:
            if i in win_nums:
                min_win += 1
                max_win += 1
        else:
            max_win += 1
    
    return [find_win(max_win), find_win(min_win)]

def find_win(n):
    if n == 6:
        return 1
    elif n == 5:
        return 2
    elif n == 4:
        return 3
    elif n == 3:
        return 4
    elif n == 2:
        return 5
    else:
        return 6