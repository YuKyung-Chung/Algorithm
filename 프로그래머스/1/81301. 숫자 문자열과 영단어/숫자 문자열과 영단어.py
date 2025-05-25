def solution(s):
    answer = 0
    result = ''
    isNum = ''
    for i in range(len(s)):
        if s[i].isdigit(): # 숫자인 경우
            result += str(s[i])
        elif s[i].isalpha(): # 알파벳인 경우
            isNum += s[i]
            while(findNum(isNum) > -1): # 알파벳을 숫자로 바꿀때까지 실행
                if (findNum(isNum) == -1): # 숫자를 판별할 수 없는 경우
                    isNum += s[i]
                else:
                    result += str(findNum(isNum))
                    isNum = '' # 알파벳 초기화
                
    return int(result)

def findNum(n):
    if(n == 'zero'):
        return 0
    elif(n == 'one'):
        return 1
    elif(n == 'two'):
        return 2
    elif(n == 'three'):
        return 3
    elif(n == 'four'):
        return 4
    elif(n == 'five'):
        return 5
    elif(n == 'six'):
        return 6
    elif(n == 'seven'):
        return 7
    elif(n == 'eight'):
        return 8
    elif(n == 'nine'):
        return 9
    else:
        return -1