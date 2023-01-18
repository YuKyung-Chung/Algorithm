import sys
str = list(sys.stdin.readline().rstrip())
stack = []
answer = 0
for i in range(len(str)):
    if str[i] == '(':
        stack.append(str[i])
    elif str[i] == ')':
        if str[i-1] == '(':
            stack.remove(str[i-1])
            answer += len(stack)
        else:
            stack.pop()
            answer += 1
print(answer)