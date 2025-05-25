def solution(strings, n):
    # 정렬 기준: n번째 문자, 같으면 사전순
    return sorted(strings, key = lambda x: (x[n], x))