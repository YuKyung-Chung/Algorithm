from collections import deque
def solution(priorities, location):
    answer = 0
    q = deque()
    
    for i in range(len(priorities)):
        if i == location:
            q.append([priorities[i], 1])
        else:
            q.append([priorities[i], 0])
    
    while q:
        p, find = q.popleft()
        
        # 만약 q에 p보다 우선순위 높은게 있는지 확인
        has_higher = False
        
        for other_p, _ in q:
            if other_p > p:
                has_higher = True
                break
                # q.append([p,find])
        if has_higher:
            q.append([p,find])
        else:
            answer += 1
            if find == 1:
                return answer
    
    return answer