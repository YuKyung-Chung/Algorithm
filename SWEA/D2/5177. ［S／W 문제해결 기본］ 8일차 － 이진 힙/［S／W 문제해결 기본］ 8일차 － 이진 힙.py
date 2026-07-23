T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N = int(input())
    numbers = list(map(int, input().split()))

    # 0번 인덱스는 사용하지 않음
    heap = [0]

    # 숫자 하나씩 최소 힙에 삽입
    for number in numbers:
        # 완전 이진트리의 마지막 위치에 추가
        heap.append(number)

        # 방금 삽입한 노드의 인덱스
        child = len(heap) - 1

        # 부모보다 값이 작으면 위로 이동
        while child > 1:
            parent = child // 2

            # 최소 힙 조건을 만족하면 종료
            if heap[parent] < heap[child]:
                break

            # 부모와 자식 교환
            heap[parent], heap[child] = heap[child], heap[parent]

            # 교환된 위치에서 다시 부모 확인
            child = parent

    # 마지막 노드의 부모부터 루트까지 합산
    index = N // 2
    answer = 0

    while index >= 1:
        answer += heap[index]
        index //= 2

    print('#'+str(test_case), answer)