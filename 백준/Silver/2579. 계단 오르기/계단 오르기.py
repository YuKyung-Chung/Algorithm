N = int(input())
stairs = [0] * (N+1)
for i in range(1, N+1):
    stairs[i] = int(input())

dp = [[0]*3 for _ in range(N+1)]
dp[1][1] = stairs[1] # 첫번째 계단 밟은 경우
dp[1][0] = 0 # 첫번째 계단 안밟은 경우

if N>=2:
    dp[2][1] = stairs[2] # 두번째 계단 밟은 경우
    dp[2][2] = dp[1][1] + stairs[2] # 두번째 계단 밟은 경우 (연속2번째)

if N>=3:
    for j in range(3, N+1):
        dp[j][2] = dp[j-1][1] + stairs[j]
        dp[j][1] = max(dp[j-2][1] + stairs[j], dp[j-2][2]+ stairs[j], dp[j-2][0]+ stairs[j])
dp[N][0] = max(dp[N][1], dp[N][2])

print(dp[N][0])