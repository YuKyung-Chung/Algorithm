import sys
N = int(input())

for i in range(N):
    str = sys.stdin.readline().rstrip()
    words = list(str.split())
    stack = []
    
    for word in words:
        stack.append(word[::-1])
        
    answer = " ".join(stack)
    print(answer)