def solution(strArr):
    answer = []
    idx = 0
    for i in strArr:
        if(idx % 2 == 0):
            answer.append(i.lower())
        else:
            answer.append(i.upper())
        idx+=1
        
    return answer