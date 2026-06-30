import heapq

def solution(jobs):
    answer = 0
    
    # 작업 번호를 붙여서 저장
    # jobs[i] = [요청시각, 소요시간]
    jobs = [(request_time, duration, i) for i, (request_time, duration) in enumerate(jobs)]
    
    # 요청 시각 기준으로 정렬
    jobs.sort(key=lambda x: x[0])
    
    heap = []
    time = 0          # 현재 시각
    idx = 0           # 아직 힙에 넣지 않은 작업의 인덱스
    count = 0         # 처리 완료한 작업 수
    total_time = 0    # 반환 시간 합
    
    while count < len(jobs):
        
        # 현재 시각까지 요청된 작업들을 모두 대기 큐에 넣음
        while idx < len(jobs) and jobs[idx][0] <= time:
            request_time, duration, job_id = jobs[idx]
            
            # 우선순위: 소요시간, 요청시각, 작업번호
            heapq.heappush(heap, (duration, request_time, job_id))
            idx += 1
        
        # 대기 큐에 작업이 있으면 가장 우선순위 높은 작업 수행
        if heap:
            duration, request_time, job_id = heapq.heappop(heap)
            
            # 현재 시각에서 duration만큼 작업 수행
            time += duration
            
            # 반환 시간 = 작업 종료 시각 - 요청 시각
            total_time += time - request_time
            
            count += 1
        
        # 대기 큐가 비어 있으면 다음 작업 요청 시각으로 시간 이동
        else:
            time = jobs[idx][0]
    
    return total_time // len(jobs)