from collections import Counter
def solution(nums):
    answer = 0
    N = len(nums)//2 # 선택할 수 있는 폰켓몬 수
    
    c = Counter(nums)
    
    # 선택할 수 있는 가짓수가 전체 수보다 많으면 N이 정답
    if len(c) >= N:
        answer = N
    # 그게 아닌경우 
    else:
        answer = len(c)
    
    
    return answer