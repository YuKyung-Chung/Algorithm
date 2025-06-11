from collections import deque

def solution(priorities, location):
    answer = 0
    q = deque()
    
    for i, p in enumerate(priorities):
        q.append((i,p))
    
    while q:
        idx, priority = q.popleft()
        
        # 하나라도 우선순위 높은 게 남아있다면 다시 큐에 넣기
        if any(priority < p for _, p in q):
            q.append((idx, priority))
        else:
            answer += 1
            if idx == location:
                return answer
    
    