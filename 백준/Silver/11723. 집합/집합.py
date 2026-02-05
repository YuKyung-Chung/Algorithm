import sys
input = sys.stdin.readline
write = sys.stdout.write

M = int(input())
S = 0 # 비트마스크로 기록
ALL = (1 << 21) - 2 # 1~20 비트 = 1

for _ in range(M):
    find = input().split()
    op = find[0]

    if op == "add":
        x = int(find[1])
        S = S | (1 << x)
    elif op == "check":
        x = int(find[1])
        write("1\n" if (S & (1 << x)) else "0\n")
    elif op == "remove":
        x = int(find[1])
        S = S & ~(1 << x)
    elif op == "toggle":
        x = int(find[1])
        S = S ^ (1 << x)
    elif op == "all":
        S = ALL
    elif op == "empty":
        S = 0