# Greedy
def solution(n, m, section):
    answer = 0
    i = 0
    
    while i < len(section):
        # 현재 구간 기준으로 롤러 한 번 칠하기
        start = section[i]
        end = start + m - 1
        
        # 이 범위 안에 있는 모든 section 요소는 한 번에 칠해진 것으로 간주
        while i < len(section) and section[i] <= end:
            i+=1
        answer += 1
        
    return answer