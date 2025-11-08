from collections import Counter

def solution(X, Y):
    same_num = []
    cX = Counter(X)
    cY = Counter(Y)
    
    # 짝꿍 만들기
    for k in range(9, -1, -1):
        str_k = str(k)
        
        # k 라는 숫자가 공통으로 나타나는 횟수 계산
        common_count = min(cX.get(str_k, 0), cY.get(str_k,0))
        
        same_num.append(str_k * common_count)
        
    result = ''.join(same_num)
    
    if not result:
        return "-1"
    if result[0] == '0':
        return "0"
    
    
    return result