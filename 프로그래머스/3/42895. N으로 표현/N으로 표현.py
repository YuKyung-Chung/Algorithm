def solution(N, number):
    # N을 i번 사용해서 만들 수 있는 모든 숫자 집합
    dp = [set() for _ in range(9)]
    
    for i in range(1,9):
        # 같은 숫자 추가
        repeated_num = int(str(N)*i)
        dp[i].add(repeated_num)
        print(dp)
        
        # i개를 j개 + i-j 개로 나누어서 조합
        for j in range(1, i):
            for a in dp[j]:
                for b in dp[i-j]:
                    dp[i].add(a+b)
                    dp[i].add(a-b)
                    dp[i].add(a*b)
                    
                    if b != 0:
                        dp[i].add(a//b)
                        
        # N을 i번 사용해서 number를 만들 수 있으면 바로 반환
        if number in dp[i]:
            return i
    
    return -1