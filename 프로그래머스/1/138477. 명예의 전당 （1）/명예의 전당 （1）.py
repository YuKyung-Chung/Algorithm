import heapq

def solution(k, score):
    honor = []
    answer = []
    
    for i in score:
        heapq.heappush(honor, i) # 최소 힙에 추가
        if len(honor) > k:
            heapq.heappop(honor) # k개 초과 시 가장 낮은 점수 제거
        answer.append(honor[0]) # 힙의 top은 항상 최하위 점수
    return answer