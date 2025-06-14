import heapq
def solution(jobs):
    answer = 0
    # 1. jobs를 요청 시각 기준 정렬
    jobs.sort()
    current_time = 0
    total_sum = 0
    q = []
    i = 0
    while i < len(jobs) or q:
        
        # 현재 시간보다 작은 요청시간이 있다면 대기열에 추가
        while i < len(jobs) and current_time >= jobs[i][0]:
            heapq.heappush(q, (jobs[i][1], jobs[i][0]))
            i += 1
        
        # 대기열에 작업이 있다면
        if q:
            duration, start_time = heapq.heappop(q)
            current_time += duration
            total_sum += current_time - start_time
        # 작업 없다면 다음 작업 도착 시간으로 현재 시간만 갱신
        else:
            current_time = jobs[i][0]
    return total_sum // len(jobs)