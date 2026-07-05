import heapq
def solution(n, works):
    answer = 0
    work = []
    
    # 최댓값큐 만들기
    for w in works:
        heapq.heappush(work, -w)
    
    for i in range(n):
        if work:
            now = -heapq.heappop(work)
            if now == 0: break
            else:
                heapq.heappush(work,-(now-1))

    for w in work:
        answer += w*w
        
    return answer