from collections import Counter

def solution(participant, completion):
    answer = ''
    
    p_counter = Counter(participant)
    c_counter = Counter(completion)
    
    diff = p_counter - c_counter
    answer = list(diff.keys())[0]
    
    return answer