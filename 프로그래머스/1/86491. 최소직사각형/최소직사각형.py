def solution(sizes):
    answer = 0 # 모든 명함 수납할 수 있는 최소 크기
    min_size, max_size, w, h = 1001, 0, 0, 0
    for size in sizes:
        min_size = (min(size[0], size[1]))
        max_size = (max(size[1], size[0]))
        w = max(w, min_size)
        h = max(h, max_size)
        
    return w*h