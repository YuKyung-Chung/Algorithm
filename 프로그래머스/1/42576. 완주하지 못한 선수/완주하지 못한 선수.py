from collections import Counter
def solution(participant, completion):
    answer = ''
    
    d = Counter(participant)
    
    for person in completion:
        if person in d:
            d[person] -= 1
                
    for k,v in d.items():
        if v != 0:
            answer = k
            
    return answer