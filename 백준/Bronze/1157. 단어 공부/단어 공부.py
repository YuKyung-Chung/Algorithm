from collections import Counter

s = Counter(input().upper())
max_freq = max(s.values())

# 최대 빈도를 가진 문자가 2개 이상이면 "?"
find = [ch for ch, f in s.items() if f == max_freq]
print(find[0] if len(find) == 1 else "?")