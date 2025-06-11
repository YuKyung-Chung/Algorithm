from collections import deque
import math

def solution(progresses, speeds):
    answer = []
    release = [] # 배포되는 기간 저장

    for i in range(len(progresses)):
        release.append(math.ceil((100-progresses[i]) / speeds[i]))
    
    current_day = release[0]
    q = deque()
    q.append(current_day)
    
    for days in release[1:]:
        if days <= current_day :
            q.append(days)
        else:
            answer.append(len(q))
            q.clear()
            current_day = days
            q.append(days)
            
    answer.append(len(q))

    
    return answer