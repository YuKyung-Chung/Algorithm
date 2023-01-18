n = int(input())
a = list(map(int,input().split()))
dp = [1]*n
num = []
for i in range(n):
    for j in range(i):
        if a[j] < a[i]:
            dp[i] = max(dp[i], dp[j]+1)
print(max(dp))


order = max(dp)
for i in range(n-1, -1, -1):
    if dp[i] == order:
        num.append(a[i])
        order -= 1
        
num.reverse()
print(*num)