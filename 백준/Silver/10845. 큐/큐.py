import sys
N = int(sys.stdin.readline())
q = []
for _ in range(N):
    com = sys.stdin.readline().split()
    if com[0] == "push":
        q.insert(0,com[1])
    elif com[0] == "pop":
        if len(q) != 0:
            print(q.pop())
        else:
            print(-1)
    elif com[0] == "size":
        print(len(q))
    elif com[0] == "empty":
        if len(q) != 0:
            print(0)
        else:
            print(1)
    elif com[0] == "front":
        if len(q) == 0:
            print(-1)
        else:
            print(q[len(q)-1])
    elif com[0] == "back":
        if len(q) == 0:
            print(-1)
        else:
            print(q[0])