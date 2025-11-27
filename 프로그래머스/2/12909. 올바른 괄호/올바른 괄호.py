def solution(s):
    answer = True
    stack = []
    
    for ch in s:
        if ch == '(':
            stack.append(ch)
        else:
            if not stack:
                return False
            stack.pop()

    return len(stack) == 0