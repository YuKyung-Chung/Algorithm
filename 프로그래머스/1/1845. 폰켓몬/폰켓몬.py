from collections import Counter
def solution(nums):
    answer = 0
    N = (len(nums))//2
    
    nums = Counter(nums)
    # print(len(nums))
    
    
    print(N)
    if(len(nums) >= N):
        answer = N
    else:
        answer = len(nums)
    
    return answer