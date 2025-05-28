def solution(ingredient):
    answer = 0
    stack = [] # 햄버거 담을 스택
    
    for i in ingredient:
        stack.append(i)
        # 마지막 4개의 재료가 1,2,3,1 인지 확인
        if stack[-4:] == [1,2,3,1]:
            # 햄버거 완성 -> pop 4번
            for _ in range(4):
                stack.pop()
            answer += 1

    return answer