import sys

# N : 리스트에 있는 점수 개수
# new_score : 새 점수
# P : 랭킹 리스트에 올라 갈 수 있는 점수의 개수
N, new_score, P = map(int, input().split())

# 만약 점수가 P보다 랭킹이 낮다면 -1 출력
if N > 0:
    scores = list(map(int, input().split()))
else:
    scores = []

# 만약 랭킹이 꽉 찼고, 새 점수가 꼴찌 점수보다 작거나 같으면 못 들어감
if N == P and scores[-1] >= new_score:
    print(-1)
    sys.exit(0) # 종료

rank = 1
for s in scores:
    if s > new_score:
        rank += 1
    else:
        break

print(rank)