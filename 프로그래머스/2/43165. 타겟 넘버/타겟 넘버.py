def solution(numbers, target):
    answer = 0
    
    def dfs(idx, number_sum):
        nonlocal answer
        
        if idx == len(numbers):
            if number_sum == target:
                answer += 1
            return
            
        dfs(idx+1, number_sum + numbers[idx])
        dfs(idx+1, number_sum - numbers[idx])
        
    
    dfs(0,0)
    
    return answer