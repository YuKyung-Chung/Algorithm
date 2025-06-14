import heapq

def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    
    while scoville:
        first = heapq.heappop(scoville)
        if first >= K:
            return answer
        if not scoville:
            return -1
        second = heapq.heappop(scoville) * 2
        answer += 1
        heapq.heappush(scoville, first + second)
    
    return answer