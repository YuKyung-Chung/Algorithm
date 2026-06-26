from collections import deque

def solution(bridge_length, weight, truck_weights):
    time = 0
    trucks = deque(truck_weights)
    
    bridge = deque([0 for _ in range(bridge_length)])
    now_weight = 0 # 현재 다리 위 트럭 무게 합
    
    # 아직 건널 트럭이 남아있거나 현재 다리 위 무게가 0보다 클때
    while trucks or now_weight > 0:
        time += 1
        # 1초가 지나면서 다리 맨 앞 칸이 빠짐
        now_truck = bridge.popleft()
        now_weight -= now_truck
        
        # 다음 트럭이 올라갈수 있으면 트럭 올리기
        if trucks and now_weight + trucks[0] <= weight:
            t = trucks.popleft()
            bridge.append(t)
            now_weight += t
        # 못올라가면 0 추가
        else:
            bridge.append(0)

    return time