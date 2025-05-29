def solution(survey, choices):
    answer = ''
    scores = {
        'R' : 0,
        'T' : 0,
        'C' : 0,
        'F' : 0,
        'J' : 0,
        'M' : 0,
        'A' : 0,
        'N' : 0
    }
    
    for i in range(len(survey)):
        first, second = survey[i][0], survey[i][1]
        
        if choices[i] < 4:
            scores[first] += 4 - choices[i]
        elif choices[i] > 4:
            scores[second] += choices[i] - 4
            
    # 성격 유형 선택(알파벳 오름차순으로)
    pairs = [('R','T'),('C','F'),('J','M'),('A','N')]

    for a,b in pairs:
        if scores[a] >= scores[b]:
            answer += a
        else:
            answer += b
            
    return answer
