from itertools import permutations

def solution(k, dungeons):
    answer = -1
    dungeons = list(permutations(dungeons))
    for dungeon in dungeons:
        now_p = k # 현재 피로도
        count = 0 # 탐험 진행한 던전 수
        for d in dungeon:
            # 최소 필요 피로도, 소모 피로도
            min_p, consume_p = d
            # 최소 필요 피로도가 현재 피로도보다 크고
            # 소모 피로도가 현재 피로도보다 작을 경우 탐험 진행
            if now_p >= min_p and now_p >= consume_p:
                # 탐험 진행
                now_p -= consume_p
                count += 1
            else:
                answer = max(answer, count)
                break
        answer = max(answer, count)
    return answer