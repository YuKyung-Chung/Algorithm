def solution(s):
    answer = ''
    nums = list(map(int, s.split()))
    answer = f"{min(nums)} {max(nums)}"
    return answer