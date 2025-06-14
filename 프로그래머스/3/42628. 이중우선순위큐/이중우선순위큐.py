import heapq
def solution(operations):
    answer = []
    min_heap = []
    max_heap = []
    heapq.heapify(min_heap)
    heapq.heapify(max_heap)
    
    for op in operations:
        ins, num = op.split()
        num = int(num)
        if ins == 'I':
            heapq.heappush(min_heap, num)
            heapq.heappush(max_heap, -num) # 최대 힙 구현용
        elif ins == 'D':
            if not min_heap:
                continue
            if num == 1:
                max_val = -heapq.heappop(max_heap)
                min_heap.remove(max_val)
            elif num == -1:
                min_val = heapq.heappop(min_heap)
                max_heap.remove(-min_val)
            
    if not min_heap:
        answer = [0,0]
    else:
        answer = [-heapq.heappop(max_heap), heapq.heappop(min_heap)]
            
    return answer