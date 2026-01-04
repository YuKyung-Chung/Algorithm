import math

def solution(progresses, speeds):
    answer = []
    # 완료되기까지 걸리는 날짜
    complete_date = [0] * len(progresses)
    for i in range(len(progresses)):
        complete_date[i] = math.ceil((100 - progresses[i])/speeds[i])
    
    count = 1
    current = complete_date[0]
    for i in range(1, len(complete_date)):
        # current = max(current, complete_date[i])
        
        if complete_date[i] <= current:
            count += 1
        else:
            # 크면 answer.append(cnt) 하고 current = d, count = 1
            answer.append(count)
            count = 1
            current = complete_date[i]
    
    # 마지막
    answer.append(count)
    
    return answer