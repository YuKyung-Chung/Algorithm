def solution(s):
    last_seen = {}  # 문자의 마지막 위치를 저장
    result = []

    for i in range(len(s)):
        char = s[i] # 현재 위치의 문자
        if char in last_seen:
            result.append(i - last_seen[char]) #현재 인덱스 - 이전 등장 인덱스
        else:
            result.append(-1) #처음 나온 문자
        last_seen[char] = i # 현재 인덱스 기록

    return result
