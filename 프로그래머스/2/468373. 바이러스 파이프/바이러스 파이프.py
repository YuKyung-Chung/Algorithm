from itertools import product

def solution(n, infection, edges, k):
    answer = 0
    graph = [[] for _ in range(n+1)]
    
    for x,y,pipe_type in edges:
        graph[x].append((y,pipe_type))
        graph[y].append((x,pipe_type))
    
    for length in range(1, k+1):
        for order in product([1,2,3], repeat=length):
            infected = set()
            infected.add(infection)
            
            for pipe_type in order:
                # 현재 감염된 노드들에서 시작해서 pipe_type과 같은 파이프만 타고 갈 수 있는 노드들을 전부 감염시키기
                stack = list(infected)
                while stack:
                    now = stack.pop()
                    for next_node, next_type in graph[now]:
                        # 지금 연 파이프 타입과 같아야 함 & 아직 감염되지 않은 노드
                        if next_type == pipe_type and next_node not in infected:
                            infected.add(next_node)
                            stack.append(next_node)
            answer = max(answer, len(infected))

    return answer