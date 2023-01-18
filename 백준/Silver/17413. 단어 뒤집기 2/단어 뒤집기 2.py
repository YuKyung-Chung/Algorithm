import sys
from collections import deque

str = list(sys.stdin.readline().rstrip())
result = []
q = deque()
tag = False

for i in str:
    if i == "<":
        while q:
            result.append(q.pop())
        tag = True
        result.append(i)
    elif i == ">":
        tag = False
        result.append(i)
    elif i == " ":
        while q:
            result.append(q.pop())
        result.append(i)
    elif tag == True:
        result.append(i)
    elif tag == False:
        q.append(i)
while q:
    result.append(q.pop())
print(''.join(result))