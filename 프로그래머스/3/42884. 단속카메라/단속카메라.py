def solution(routes):
    answer = 0
    routes = sorted(routes, key=lambda x:x[1])
    camera = -300001 # 카메라 없는 상태
    
    for start, end in routes:
        if camera < start: # 현재 카메라가 이 차량 범위 밖이면
            camera = end #진출 시점에 카메라 설치
            answer += 1
    
    return answer