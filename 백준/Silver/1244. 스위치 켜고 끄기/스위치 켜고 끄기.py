N = int(input()) # 스위치 개수
switches = list(map(int, input().split()))
M = int(input()) # 학생 수
for _ in range(M):
    gender, num = map(int, input().split())
    # 남학생인 경우
    if gender == 1:
        for i in range(num, N+1, num):
            switches[i-1] = 0 if switches[i-1] == 1 else 1
    # 여학생인 경우
    else:
        switches[num - 1] = 0 if switches[num - 1] == 1 else 1
        cnt = 1
        # 최대 대칭 스위치 상태 변경
        while (num - 1 - cnt) >= 0 and (num - 1 + cnt) < N:
            # 대칭이면 스위치 바꿔
            if (switches[num - 1 - cnt] == switches[num - 1 + cnt]):
                switches[num - 1 - cnt] = 0 if switches[num - 1 - cnt] == 1 else 1
                switches[num - 1 + cnt] = 0 if switches[num - 1 + cnt] == 1 else 1
                cnt += 1
            else:
                break

for i in range(0,N,20):
    print(*switches[i:i+20])