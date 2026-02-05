N, K = map(int, input().split())
countries = []
for _ in range(N):
    countries.append(list(map(int, input().split())))

countries.sort(key=lambda c: (-c[1], -c[2], -c[3]))
rank = [0 for _ in range(N+1)]
rank[countries[0][0]] = 1
for c in range(1,len(countries)):
    # 금/은/동 모두 같으면 공동 순위
    if(countries[c][1:] == countries[c-1][1:]):
        rank[countries[c][0]] = rank[countries[c-1][0]]
    else:
        rank[countries[c][0]] = rank[countries[c-1][0]] + 1

print(rank[K])