def solution(n):
    answer = 0
    
    for start in range(1, n+1):
        total = 0
        while total < n:
            total += start
            start += 1
            if total == n:
                answer += 1
                break
    
    
    return answer