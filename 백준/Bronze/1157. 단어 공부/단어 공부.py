from collections import Counter

s = input().upper()
s = Counter(s)
result = sorted(s.items(), key=lambda x:x[1], reverse=True)

max_num = -1
answer = ""
for i, j in result:
    if max_num < j:
        max_num = j
        answer = i
    elif max_num == j:
        answer = "?"

print(answer)