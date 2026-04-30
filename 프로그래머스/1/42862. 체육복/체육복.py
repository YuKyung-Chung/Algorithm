def solution(n, lost, reserve):
    overlap = set(lost) & set(reserve)
    lost = [x for x in lost if x not in overlap]
    reserve = [x for x in reserve if x not in overlap]
    answer = n - len(lost)
    
    for i in range(1, n+1):
        if i in lost:
            if i-1 in reserve:
                reserve.remove(i-1)
                lost.remove(i)
                answer += 1
                continue
            elif i+1 in reserve:
                reserve.remove(i+1)
                lost.remove(i)
                answer += 1
                continue
    
    return answer