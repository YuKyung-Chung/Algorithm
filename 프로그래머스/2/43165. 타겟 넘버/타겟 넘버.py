def solution(numbers, target):
    answer = 0
    
    def dfs(cnt, mid_sum):
        nonlocal answer
        
        # 탈출조건
        if cnt == len(numbers):
            if mid_sum == target:
                answer += 1
            return
            
        dfs(cnt+1, mid_sum + numbers[cnt])
        dfs(cnt+1, mid_sum - numbers[cnt])
    
    
    
    dfs(0, 0)
    
    return answer