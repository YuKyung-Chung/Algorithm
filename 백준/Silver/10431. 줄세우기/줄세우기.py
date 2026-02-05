P = int(input()) # 테스트 케이스 개수
for _ in range(P):
    arr = list(map(int, input().split()))
    T = arr[0] # 테스트 케이스 번호
    children = arr[1:] # 줄 서는 순서대로 주어진 20명의 키

    line = [] # 현재까지 줄 선 학생들의 키 (오름차순 유지)
    cnt = 0 # 학생들이 뒤로 물러난 총 횟수

    for h in children:
        idx = 0
        # 현재 줄에서 h보다 작은 학생들은 그냥 지나감
        # (자기 앞에 자기보다 키 큰 학생이 나올 때까지 이동)
        while idx < len(line) and line[idx] < h:
            idx += 1

        # idx 위치부터 뒤에 있는 학생들은
        # h가 들어오면서 한 칸씩 뒤로 밀리게 됨
        cnt += len(line) - idx

        # 가장 앞에 있는 '자기보다 키 큰 학생'의 바로 앞에 삽입
        line.insert(idx, h)

    print(T,cnt)