# 임스 제외하고 몇명이 필요한지
def HowManyPeople(people):
    if people == "Y":
        return 1
    elif people == "F":
        return 2
    elif people == "O":
        return 3

N, M = input().split()
people = [] # 플레이하고자 하는 사람들의 이름
players = HowManyPeople(M)
for _ in range(int(N)):
    people.append(input().split())

# 한번 게임했던 사람과는 다시 플레이하지 않음.
# Y = 2, F = 3, O = 4 명 필요
played = set()
cnt = 0
result = 0
for i in range(int(N)):
    # 이미 게임한 사람이면 건너뛰기
    if people[i][0] in played:
        continue
    # 처음 게임하는 사람이면
    cnt += 1
    played.add(people[i][0])
    # 인원수가 채워졌다면
    if cnt == players:
        result += 1
        cnt = 0

print(result)