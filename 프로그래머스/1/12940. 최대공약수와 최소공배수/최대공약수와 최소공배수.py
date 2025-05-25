def solution(n, m):
    answer = [0,0]
    
    # 유클리드 호제법으로 최대공약수 구하기
    def gcd(a,b):
        while b:
            a,b = b,a%b
        return a
    
    answer[0] = gcd(n,m)
    answer[1] = (n*m) // answer[0]
    
    return answer