def solution(n, costs):
    answer = 0
    costs = sorted(costs, key=lambda x: x[2])
    
    parent = [i for i in range(n)]
    
    def find(parent, x):
        if parent[x] != x:
            return find(parent, parent[x])
        return x
    
    def union(parent, a,b):
        a = find(parent,a)
        b = find(parent,b)
        
        if a != b:
            parent[b] = a
            
    for a,b,c in costs:
        # 두 섬의 대표가 다르면(사이클 아니면)
        if find(parent, a) != find(parent, b):
            union(parent, a,b)
            answer += c
    
    
    return answer