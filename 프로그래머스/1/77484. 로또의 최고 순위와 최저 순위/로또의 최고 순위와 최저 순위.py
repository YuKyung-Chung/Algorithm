def solution(lottos, win_nums):
    rank = [6,6,5,4,3,2,1]
    ans = 0
    cnt_zero = lottos.count(0)

    for i in win_nums:
        if i in lottos:
            ans += 1
            
    return rank[ans+cnt_zero], rank[ans]