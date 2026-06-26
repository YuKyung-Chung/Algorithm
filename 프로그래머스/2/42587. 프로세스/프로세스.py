from collections import deque
def solution(priorities, location):
    answer = 0 # 실행 순서
    q = deque([])
    for i in range(len(priorities)):
        q.append((i, priorities[i])) # (location, priority)
    
    while q:
        index, priority = q.popleft()
        
        # q안에 priority보다 높은 값 있으면 맨 뒤로 넣기
        if any(priority < other_priority for _, other_priority in q):
            q.append((index, priority))
        else:
            answer += 1 # 실행순서 하나 올리기
        
            if index == location:
                return answer
    
    return answer