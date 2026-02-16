from collections import deque

t = int(input())  # 테스트 케이스 개수

for _ in range(t):
    N = int(input())  # 편의점 개수
    
    points = []
    
    # 0번 인덱스: 집
    hx, hy = map(int, input().split())
    points.append((hx, hy))
    
    # 1 ~ N번 인덱스: 편의점
    for _ in range(N):
        cx, cy = map(int, input().split())
        points.append((cx, cy))
    
    # N+1번 인덱스: 페스티벌
    fx, fy = map(int, input().split())
    points.append((fx, fy))

    # BFS 시작
    q = deque([0])  # 집(0번 인덱스)에서 시작
    visited = [False] * (N + 2)  # 집 + 편의점 N개 + 페스티벌
    visited[0] = True  # 집 방문 처리
    
    ans = "sad"  # 기본값은 sad (도착 못할 경우)

    while q:
        cur = q.popleft()  # 현재 위치 인덱스
        
        # 현재 위치가 페스티벌이면 성공
        if cur == N + 1:
            ans = "happy"
            break
        
        x1, y1 = points[cur]  # 현재 위치 좌표
        
        # 모든 지점(집/편의점/페스티벌)에 대해 이동 가능 여부 검사
        for i in range(N + 2):
            if not visited[i]:
                x2, y2 = points[i]
                
                # 맨해튼 거리 계산
                dist = abs(x1 - x2) + abs(y1 - y2)
                
                # 맥주 20병 → 최대 1000m 이동 가능
                if dist <= 1000:
                    visited[i] = True  # 방문 처리
                    q.append(i)        # 다음 탐색 후보로 추가

    print(ans)
