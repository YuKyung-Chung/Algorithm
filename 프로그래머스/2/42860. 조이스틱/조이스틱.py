def solution(name):
    answer = 0
    N = len(name)
    names = list(name)
    up_down = []
    
    # 상하조작
    for n in names:
        up_down.append(min(ord(n) - ord('A'), 26- (ord(n) - ord('A'))))
        
    # 좌우조작
    move = N-1 # 오른쪽으로만 가는 경우
    for i in range(N):
        j = i+1
        
        # j부터 연속된 A 건너뛰기
        while j < N and name[j] == 'A':
            j += 1
        
        # 2. 오른쪽으로 가다가 되돌아서 왼쪽으로 가기
        move = min(move, i + i + (N-j))
        # 3. 왼쪽으로 먼저 갔다가 오른쪽으로 가기
        move = min(move, (N-j)+(N-j)+i)
        
    return sum(up_down) + move