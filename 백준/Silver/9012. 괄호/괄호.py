import sys
N = int(input())

for _ in range(N):
    str = sys.stdin.readline()
    sum = 0
    for vps in str:
        if vps == "(":
            sum += 1
        elif vps == ")":
            sum -= 1
        if sum < 0:
            print("NO")
            break
    if sum == 0:
        print("YES")
    elif sum > 0:
        print("NO")