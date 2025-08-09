def solution(s):
    answer = len(s)
    # 자르는 단위 1~len(s)//2 반복 → 같은 문자열 묶기 → 최단 길이 갱신
    for size in range(1,(len(s)//2)+1):
        prev = s[:size]
        comp = ""
        cnt = 1
        for i in range(size, len(s), size):
            cur = s[i:i+size]
            if cur == prev:
                cnt += 1
            else:
                if(cnt > 1):
                    comp += str(cnt)+prev
                else:
                    comp += prev
                prev = cur
                cnt = 1
        if(cnt > 1):
            comp += str(cnt)+prev
        else:
            comp += prev
        
        # 최소 길이 갱신
        answer = min(answer, len(comp))
        
    return answer