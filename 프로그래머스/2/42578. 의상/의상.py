from collections import Counter

def solution(clothes):
    answer = 1
    counter = Counter()
    
    for name, kind in clothes:
        counter[kind] += 1
        
    for item in counter.values():
        answer *= (item+1)
        
    return answer - 1