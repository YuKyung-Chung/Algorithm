# 슬라이딩 윈도우
def solution(want, number, discount):
    answer = 0
    start = 0
    end = 10
    want_dict = {}
    for i in range(len(want)):
        want_dict[want[i]] = number[i]
    
    if len(discount) < 10:
        return 0
    
    while end <= len(discount):
        discount_dict = {}
        for i in range(start, end):
            # want의 개수와 일치하는지 확인
            discount_dict[discount[i]] = discount_dict.get(discount[i], 0) + 1
        if want_dict == discount_dict:
            answer += 1
            
        start += 1
        end += 1
        
    return answer