def solution(left, right):
    answer = 0
    # 약수 개수가 짝수인 수는 더하기, 홀수인 수는 빼기
    for i in range(left, right+1):
        # 약수 개수 구하기
        cnt = 0
        for j in range(1, int((i**0.5) + 1)):
            if i % j == 0:
                cnt += 1
                if j != (i//j): # 제곱수 아니면 짝 약수도 카운트
                    cnt+=1
                    
        if (cnt % 2 == 0):
            answer += i
        else:
            answer -= i
    return answer