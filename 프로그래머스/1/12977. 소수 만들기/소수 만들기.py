from itertools import combinations

def solution(nums):
    answer = 0

    for comb in combinations(nums, 3):
        # 소수이면 answer 에 1 추가
        if find_nums(sum(comb)):
            # print(sum(comb))
            answer += 1

    return answer

# 소수인지 판별하는 함수
def find_nums(num):
    if num == 0 or num == 1:
        return False
    cnt = 1
    for i in range(2, num+1):
        if num % i == 0:
           cnt += 1
    
    if cnt > 2:
        return False
    else:
        return True