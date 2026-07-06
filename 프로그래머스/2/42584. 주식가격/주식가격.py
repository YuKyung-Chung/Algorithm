def solution(prices):
    answer = [0] * len(prices)
    stack = []

    for i in range(len(prices)):
        while stack and prices[stack[-1]] > prices[i]:
            prev_idx = stack.pop()
            answer[prev_idx] = i - prev_idx
        stack.append(i)

        
    while stack:
        prev_idx = stack.pop()
        answer[prev_idx] = len(prices)-1 - prev_idx
    
    return answer