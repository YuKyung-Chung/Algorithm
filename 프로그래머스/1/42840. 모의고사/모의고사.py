def solution(answers):
    
    students = [
        [1, 2, 3, 4, 5],
        [2, 1, 2, 3, 2, 4, 2, 5],
        [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    ]
    
    scores = [0,0,0] # 맞힌 개수
    
    for i in range(len(students)):
        pattern = students[i]
        
        for j in range(len(answers)):
            # 패턴은 반복되므로 j % len(pattern) 사용
            if pattern[j % len(pattern)] == answers[j]:
                scores[i] += 1
    
    # 가장 높은 점수
    max_score = max(scores)
    # 최고 점수 받은 사람 번호 저장
    answer = []
    
    for i in range(len(scores)):
        if scores[i] == max_score:
            answer.append(i+1)
    
    return answer