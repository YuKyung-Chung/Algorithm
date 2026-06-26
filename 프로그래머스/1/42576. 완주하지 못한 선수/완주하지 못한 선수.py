from collections import Counter

def solution(participant, completion):
    answer = ''
    
    participants = Counter(participant)
    for c in completion:
        if c in participants:
            participants[c] -= 1
    
    answer = [key for key, value in participants.items() if value != 0]
    return answer[0]