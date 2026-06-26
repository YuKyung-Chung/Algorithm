import math
from collections import deque

def solution(progresses, speeds):
    answer = []
    progress_days = [] # 작업 후 배포 가능일수
    
    for p, s in zip(progresses, speeds):
        progress_days.append(math.ceil((100-p) / s))
    
    now_max= progress_days[0] # 현재 최대 작업길이
    count = 0
    for day in progress_days:
        # 현재 작업일이 최대 작업길이 보다 작으면 배포일에 같이 배포
        if day <= now_max:
            count += 1
        else:
            answer.append(count)
            count = 1
            now_max = day
            
    answer.append(count) # 마지막 배포 묶음 추가
    return answer