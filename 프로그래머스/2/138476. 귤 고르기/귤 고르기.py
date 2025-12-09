def solution(k, tangerine):
    answer = 0
    
    #1. 귤 크기 별 딕셔너리 구축
    t_dict = {}
    
    for t in tangerine:
        t_dict[t] = t_dict.get(t, 0) + 1
    
    #2. 개수 많은 순으로 내림차순 정렬
    t_dict = sorted(t_dict.items(), key=lambda x: x[1], reverse = True)
    
    #3. 귤 k개 판매
    picked = 0
    for size, count in t_dict:
        picked += count
        answer +=1
        
        if picked >= k:
            break
    return answer


