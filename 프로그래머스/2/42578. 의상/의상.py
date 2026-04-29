from collections import Counter
def solution(clothes):
    answer = 0
    c = Counter()
    for cloth in clothes:
        c[cloth[1]] += 1
        
    multiple = 1
    for i in c.items():
        multiple *= i[1]+1

    
    return multiple-1