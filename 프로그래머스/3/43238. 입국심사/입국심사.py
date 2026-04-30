def solution(n, times):
    answer = 0
    
    left = 1 # 최소 시간
    right = max(times) * n # 최대 시간
    
    while left < right:
        # mid분 안에 n명 심사 가능?
        mid = (left + right) // 2
        person = 0
        for time in times:
            person += mid // time
        # 가능하면 right = mid (더 줄여보기)
        if person >= n:
            right = mid
        # 불가능하면 left = mid+1 (더 늘려보기)
        else:
            left = mid + 1
        
    return left