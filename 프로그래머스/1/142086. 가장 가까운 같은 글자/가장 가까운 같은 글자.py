def solution(s):
    last_seen = {}  # 문자의 마지막 위치를 저장
    result= []
    
    for i, char in enumerate(s):
        if char in last_seen:
            result.append(i-last_seen[char])
        else:
            result.append(-1)
        last_seen[char] = i # 현재 위치로 업데이트
    return result
