N = int(input())
people = []
for i in range(1, N+1):
    x, y = map(int, input().split())
    people.append((i, x, y))

rank = [0] * (N)
for i in range(N):
    r = 1
    for j in range(N):
        if people[j][1] > people[i][1] and people[j][2] > people[i][2]:
            r += 1
    rank[i] = r

print(" ".join(map(str, rank)))