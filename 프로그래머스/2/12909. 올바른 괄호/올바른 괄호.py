def solution(s):
    answer = True
    
    stack = []
    
    if s[0] == ')':
        return False
    else:
        stack.append(s[0])
    
    while True:
        for i in s[1:]:
            if len(stack) != 0 and stack[-1] == '(' and i == ')':
                stack.pop()
            else:
                stack.append(i)
        break    
            
        
    if len(stack) != 0:
        answer = False

    return answer