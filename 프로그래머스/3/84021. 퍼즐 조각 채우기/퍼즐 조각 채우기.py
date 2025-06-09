from collections import deque

def solution(game_board, table):
    N = len(game_board)  # 게임 보드의 크기 (정사각형이므로 행 또는 열의 길이)

    # BFS로 도형(빈칸 또는 블록 조각)의 좌표 리스트 추출
    def bfs(start, visited, grid, target):
        q = deque([start])
        visited[start[0]][start[1]] = True
        shape = []  # 도형을 이루는 좌표들을 저장할 리스트

        while q:
            r, c = q.popleft()
            shape.append((r, c))
            for dr, dc in [(-1,0), (1,0), (0,-1), (0,1)]:  # 상하좌우 탐색
                nr, nc = r + dr, c + dc
                # 범위 내이고, 방문하지 않았고, target 값이면 (0 또는 1)
                if 0 <= nr < N and 0 <= nc < N and not visited[nr][nc] and grid[nr][nc] == target:
                    visited[nr][nc] = True
                    q.append((nr, nc))

        # 좌표 정규화: (0, 0) 기준으로 도형을 정렬
        min_r = min(x[0] for x in shape)
        min_c = min(x[1] for x in shape)
        normalized = sorted([(x[0] - min_r, x[1] - min_c) for x in shape])
        return normalized

    # 시계방향으로 90도 회전시키는 함수
    def rotate(shape):
        return sorted([(y, -x) for x, y in shape])

    # 도형들을 추출하는 함수: target = 0 → 빈칸, 1 → 퍼즐 조각
    def extract_shapes(grid, target):
        visited = [[False]*N for _ in range(N)]
        shapes = []
        for r in range(N):
            for c in range(N):
                if not visited[r][c] and grid[r][c] == target:
                    shapes.append(bfs((r, c), visited, grid, target))
        return shapes

    # 게임보드에서 빈칸(0), 테이블에서 블록 조각(1) 추출
    blanks = extract_shapes(game_board, 0)
    blocks = extract_shapes(table, 1)

    used = [False] * len(blocks)  # 각 퍼즐 조각의 사용 여부 기록
    result = 0  # 최종 채운 칸 수

    # 각 빈칸에 대해 사용 가능한 블록 조각 찾기
    for blank in blanks:
        for i, block in enumerate(blocks):
            # 이미 사용한 블록이거나, 모양 크기가 다르면 패스
            if used[i] or len(blank) != len(block):
                continue

            temp = block[:]
            matched = False  # 매칭 여부 플래그

            # 블록을 최대 4번 회전시켜가며 빈칸과 비교
            for _ in range(4):
                temp = rotate(temp)
                # 회전 후 좌표 정규화
                min_r = min(x[0] for x in temp)
                min_c = min(x[1] for x in temp)
                temp_norm = sorted([(x[0] - min_r, x[1] - min_c) for x in temp])

                if temp_norm == blank:  # 모양이 일치하는 경우
                    used[i] = True      # 블록 사용 처리
                    result += len(blank)  # 채운 칸 수 누적
                    matched = True
                    break  # 현재 빈칸에 대한 매칭 완료 → 다음 빈칸 탐색

            if matched:
                break  # 블록 하나가 매칭되면 이 빈칸에 대해 더 이상 탐색 X

    return result
