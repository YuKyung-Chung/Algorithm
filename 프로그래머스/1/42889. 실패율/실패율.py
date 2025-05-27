def solution(N, stages):
    answer = []
    fail_rate = {}
    total = len(stages) # 총 도전중인 사용자 수
    
    for i in range(1,N+1):
        #i번 스테이지
        cnt = 0
        for s in stages:
            if i == s:
                cnt += 1
        
        if total != 0:
            fail_rate[i] = cnt / total
        else:
            fail_rate[i] = 0
        total = total - cnt
    
    # fail_rate 딕셔너리를 value 기준으로 내림차순 정렬하고 key만 추출
    return sorted(fail_rate, key=lambda x:fail_rate[x] ,reverse = True)