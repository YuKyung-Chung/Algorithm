from collections import Counter

T = int(input())
for _ in range(T):
    N = int(input()) # 팀 번호
    players = list(map(int, input().split()))
    players_counter = Counter(players)
    participate = []
    # 각 팀의 참가 선수가 6보다 작으면 제외
    for team, cnt in players_counter.items():
        if cnt>= 6:
            participate.append(team)

    team_scores = {} # 팀별 점수 저장용 딕셔너리

    for team in participate: # 참가 가능한 팀 하나씩 확인
        team_scores[team] = [] # 해당 팀 점수들 담을 빈 리스트 생성

    score = 1
    for team in players:
        if team in team_scores:
            team_scores[team].append(score)
            score += 1
    # print(team_scores)

    # 상위 4명 합
    team_scores_sum = {}
    for team in team_scores:
        total = 0
        for i in range(4):
            total += team_scores[team][i]
        team_scores_sum[team] = total

    # 우승 팀 (동점이면 5번째 점수로)
    winner = 0
    best_sum = 10 ** 9
    best_fifth = 10 ** 9

    for team in team_scores:
        s4 = team_scores_sum[team]
        fifth = team_scores[team][4]

        if s4 < best_sum:
            best_sum = s4
            best_fifth = fifth
            winner = team
        elif s4 == best_sum and fifth < best_fifth:
            best_fifth = fifth
            winner = team

    print(winner)

