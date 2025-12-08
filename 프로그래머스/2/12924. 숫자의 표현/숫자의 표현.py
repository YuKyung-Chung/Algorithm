# 투포인터 알고리즘
def solution(n):
    start, end = 1, 1
    current_sum = 1
    count = 0
    
    while start <= n:
        if current_sum == n:
            # n 만드는 하나의 방법 발견
            count += 1
            # 구간 오른쪽으로 하나 밀기
            current_sum -= start
            start += 1
        elif current_sum < n:
            # end 하나 늘려서 더 큰 수 포함하기
            end += 1
            current_sum += end
        else:
            # 합이 크면 start 하나 늘려서 왼쪽 줄이기
            current_sum -= start
            start += 1
            
    return count
            
    
    return count