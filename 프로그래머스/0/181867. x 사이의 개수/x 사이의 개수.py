def solution(myString):
    cnt = 0
    for i in myString:
        if(i == 'x'):
            cnt+=1
    answer = [0] * (cnt+1)
    sum = 0
    idx = 0
    for i in myString:
        if(i=='x'):
            answer[idx] = sum
            sum = 0
            idx+=1
        else:
            sum+=1
        answer[idx] = sum
    return answer