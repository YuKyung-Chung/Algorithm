from collections import Counter
def solution(nums):
    answer = 0
    
    # 고를수있는 폰켓몬수
    N = len(nums)/2
    poketmons = Counter(nums)
    
    if len(poketmons) > N:
        answer = N
    else:
        answer = len(poketmons)
    
    return answer

