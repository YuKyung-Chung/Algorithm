def solution(s):
    answer = 0
    same = 0
    diff = 0
    x = '' # 기준 문자 초기화
    
    for i in range(len(s)):
        if same == 0:
            x = s[i]
            same += 1
        else:
            if (s[i] == x):
                same += 1
            else:
                diff += 1
            
        if (same == diff):
            answer += 1
            same = 0
            diff = 0
    
    # 마지막 문자열이 남아있는 경우 (같아지기 전에 끝났을 때)
    if same != 0:
        answer += 1
           
    return answer