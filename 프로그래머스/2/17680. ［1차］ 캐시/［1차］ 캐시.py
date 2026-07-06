from collections import deque

def solution(cacheSize, cities):
    answer = 0
    # 대소문자 구분X
    cities = [city.lower() for city in cities]
    q = deque()
    
    # 캐시 크기가 0이면 모든 요청은 cache miss
    if cacheSize == 0:
        return len(cities) * 5
    
    for city in cities:
        # cache hit 일 경우
        if city in q:
            answer += 1
            q.remove(city)
            q.append(city)
        
        # cache miss 일 경우
        if city not in q:
            if len(q) == cacheSize:
                q.popleft()
            q.append(city)
            answer += 5
    
    return answer