def solution(order):
    stack = [] # 보조 컨베이어벨트
    answer = 0 # 실은 상자들
    box = 1
    
    for target in order:
        while box < target and box <= len(order):
            stack.append(box)
            box += 1
        
        # 1. 보조 벨트 top이 o면
        if stack and stack[-1] == target:
            s = stack.pop()
            answer += 1
        # 2. 아니면 기존 벨트에서 상자를 계속 꺼낸다.
        elif box == target:
            answer += 1
            box += 1
        # 3. 기존 벨트에서도 더 이상 꺼낼 수 없고,
        #    보조 벨트 top도 target이 아니면
        #    → break
        else:
            break
        

    return answer