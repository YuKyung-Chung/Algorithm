def solution(n):
    #  에라토스테네스의 체 설명
    # 2부터 n까지의 모든 수를 소수(True)라고 가정합니다.
    # 2부터 √n까지의 수를 반복하면서,
    # 그 수의 배수를 모두 소수(False)로 바꿉니다.
    # 최종적으로 True로 남은 수의 개수가 소수의 개수입니다.
    is_prime = [True] * (n+1)
    is_prime[0] = is_prime[1] = False # 0과 1은 소수가 아님
    
    for i in range(2, int(n ** 0.5) +1):
        if is_prime[i]:
            for j in range(i*i, n+1, i):
                is_prime[j] = False
    
    return sum(is_prime)