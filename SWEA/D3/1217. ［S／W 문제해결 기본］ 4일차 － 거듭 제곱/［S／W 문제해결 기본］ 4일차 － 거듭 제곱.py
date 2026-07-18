for test_case in range(1,11):
    T = int(input())
    N, M = map(int, input().split())

    def multiple(N, M):
        if M == 1:
            return N
        return N * multiple(N, M-1)

    print('#'+str(test_case), multiple(N, M))