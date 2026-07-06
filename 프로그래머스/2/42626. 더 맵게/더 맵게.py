import heapq
def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    
    while scoville[0] < K:
        if len(scoville) < 2:
            if scoville[0] < K:
                return -1
        first = heapq.heappop(scoville)
        second = heapq.heappop(scoville)
        now = first + (second * 2)
        
        heapq.heappush(scoville, now)
        answer += 1
    
    return answer