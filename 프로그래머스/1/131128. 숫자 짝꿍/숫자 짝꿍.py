from collections import Counter

def solution(X, Y):
    same_num = []
    x_count = Counter(X)
    y_count = Counter(Y)
    
    for digit in x_count:
        if digit in y_count:
            # 최소 공통 개수만큼 append
            same_num.extend([digit] * min(x_count[digit], y_count[digit]))
    
    # 겹치는 수 없으면 바로 -1 return
    if not same_num:
        return "-1"
    
    same_num.sort(reverse = True)
    
    # 0이 여러개일 경우 '0'으로
    if same_num[0] == '0':
        return "0"
    
    return ''.join(same_num)