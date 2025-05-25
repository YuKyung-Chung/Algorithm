def solution(n):
    answer = ''
    # 10진수 -> 3진수
    while n > 0 :
        answer = str(n % 3) + answer
        n = n // 3
    
    # 뒤집기
    answer = answer[::-1]
    
    # 3진수 -> 10진수
    answer = int(answer,3)
    
    return answer