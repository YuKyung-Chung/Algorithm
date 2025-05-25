def solution(number, limit, power):
    yaksu = []
    # 약수 구하기
    for i in range(1, number+1):
        cnt = 0
        for j in range(1, int(i**0.5) +1):
            if(i % j == 0):
                cnt += 1
                if j != i // j:  # 제곱수 아니면 짝 약수도 세기
                    cnt += 1
        if cnt > limit:
            cnt = power
        yaksu.append(cnt)
    
    # 제한수치 초과하는지 확인
    for y in range(len(yaksu)):
        if (yaksu[y] > limit):
            yaksu[y] = power
    
    # 무기 만들기 위해 필요한 철의 무게 합
    return sum(factor for factor in yaksu)