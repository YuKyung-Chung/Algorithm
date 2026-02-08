import math
N = int(input()) # 굴다리 길이
M = int(input()) # 가로등 개수
pos = list(map(int, input().split())) # 설치할 수 있는 가로등 위치

ans = max(pos[0], N - pos[-1])

for i in range(M-1):
    gap = pos[i+1] - pos[i]
    ans = max(ans, math.ceil(gap/2))

print(ans)