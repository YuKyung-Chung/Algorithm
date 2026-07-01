import heapq
from collections import Counter
def clean_max_heap(max_heap, count):
    while max_heap and count[-max_heap[0]] == 0:
        heapq.heappop(max_heap)
 
def clean_min_heap(min_heap, count):
    while min_heap and count[min_heap[0]] == 0:
        heapq.heappop(min_heap)
    
def solution(operations):
    answer = []
    min_heap = []
    max_heap = []
    count = Counter()
    
    for op in operations:
        order, num = op.split(" ")
        num = int(num)
        if(order == 'I'):
            # 큐에 주어진 숫자 삽입
            heapq.heappush(min_heap,num)
            heapq.heappush(max_heap,-num)
            count[num] += 1
        elif order == 'D':
            if num == 1:
                # 큐에서 최댓값 삭제
                clean_max_heap(max_heap, count)
                if max_heap:
                    x = -heapq.heappop(max_heap)
                    count[x] -= 1
            elif num == -1:
                # 큐에서 최솟값 삭제
                clean_min_heap(min_heap, count)
                
                if min_heap:
                    x = heapq.heappop(min_heap)
                    count[x] -= 1
                    
    # 마지막 결과 확인 전에도 무효값 정리
    clean_min_heap(min_heap, count)
    clean_max_heap(max_heap, count)

    if not min_heap and not max_heap:
        return [0,0]
    
    return [-max_heap[0], min_heap[0]]