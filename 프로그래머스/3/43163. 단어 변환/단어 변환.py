from collections import deque
def solution(begin, target, words):
    answer = 0
    
    if target not in words:
        return 0
    q = deque([(begin, 0)])
    start = list(begin)
    visited = [False] * len(words)
    
    while q:
        word, count = q.popleft()
        
        if word == target:
            return count
        
        for w in words:
            cnt = 0
            for i in range(len(word)):
                if word[i] != w[i]:
                    cnt += 1

            if cnt == 1:
                q.append((w, count+1))
                
        
    
    return answer