from itertools import combinations as comb

def solution(numbers):
    answer = []
    answer_set = set()
    
    for i,j in comb(numbers, 2):
        answer_set.add(i+j)
    
    return sorted(list(answer_set))