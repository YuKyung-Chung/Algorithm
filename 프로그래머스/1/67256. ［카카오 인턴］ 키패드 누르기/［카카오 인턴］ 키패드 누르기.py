def solution(numbers, hand):
    answer = ''
    
    # 키패드 좌표 정의
    keypad = {
        1:(0,0), 2:(0,1), 3:(0,2),
        4:(1,0), 5:(1,1), 6:(1,2),
        7:(2,0), 8:(2,1), 9:(2,2),
        '*':(3,0), 0:(3,1), '#':(3,2)
    }
    # 현재 손가락 위치
    left, right = '*', '#'

    for num in numbers:
        if num in [1,4,7]:
            answer += 'L'
            left = num
        elif num in [3,6,9]:
            answer += 'R'
            right = num
        else:
            # 거리 계산
            l_dist = abs(keypad[left][0] - keypad[num][0]) + abs(keypad[left][1] - keypad[num][1])
            r_dist = abs(keypad[right][0] - keypad[num][0]) + abs(keypad[right][1] - keypad[num][1])
            
            # 더 가까운 손이 이동
            if l_dist > r_dist:
                answer += 'R'
                right = num
            elif l_dist < r_dist:
                answer += 'L'
                left = num
            else:
                if hand == 'right':
                    answer += 'R'
                    right = num
                else:
                    answer += 'L'
                    left = num
    return answer