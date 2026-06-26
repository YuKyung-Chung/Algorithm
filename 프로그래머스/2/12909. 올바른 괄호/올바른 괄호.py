def solution(s):
    answer = True
    total = 0
    if s[0] == ')':
        return False
    
    for i in s:
        if i == '(':
            total += 1
        if i == ')':
            total += -1
        if total < 0:
            return False
        
    if total == 0:
        return True
    else:
        return False