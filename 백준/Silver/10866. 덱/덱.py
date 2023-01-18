from collections import deque
import sys

d = deque()
N = int(input())

for i in range(N):
    cmd = sys.stdin.readline().split()
    if cmd[0] == 'push_front':
        d.appendleft(cmd[1])
    elif cmd[0] == 'push_back':
        d.append(cmd[1])
    elif cmd[0] == 'pop_front':
        if len(d) == 0:
            print(-1)
        else:
            print(d.popleft())
    elif cmd[0] == 'pop_back':
        if len(d) == 0:
            print(-1)
        else:
            print(d.pop())
    elif cmd[0] == 'size':
        print(len(d))
    elif cmd[0] == 'empty':
        if len(d) == 0:
            print(1)
        else:
            print(0)
    elif cmd[0] == 'front':
        if len(d) == 0:
            print(-1)
        else:
            print(d[0])
    elif cmd[0] == 'back':
        if len(d)== 0:
            print(-1)
        else:
            print(d[-1])
        