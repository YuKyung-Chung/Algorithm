from math import gcd

def solution(signals):
    
    def lcm(a, b):
        return a * b // gcd(a, b)

    # 각 주기
    periods = [G + Y + R for G, Y, R in signals]

    # reduce 대신 직접 누적
    total_lcm = periods[0]
    for p in periods[1:]:
        total_lcm = lcm(total_lcm, p)

    # 시뮬레이션
    for t in range(1, total_lcm + 1):
        all_yellow = True
        
        for G,Y,R in signals:
            T = G+Y+R
            # 현재 주기에서 몇번째 초인지
            time_in_cycle = t % T
            
            if time_in_cycle == 0:
                time_in_cycle = T
            
            if not (G < time_in_cycle <= G + Y):
                all_yellow = False
                break
                
        if all_yellow:
            return t

    return -1