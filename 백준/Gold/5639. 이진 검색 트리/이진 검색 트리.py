import sys
# 1. 재귀 한도 설정 (백준 필수)
sys.setrecursionlimit(10**6)
# 입력을 리스트로 변환
numbers = []
for num in sys.stdin:
    numbers.append(int(num))

if not numbers:
    exit()

tree = {} # 부모: [왼쪽자식, 오른쪽자식]
stack = [numbers[0]]
root = numbers[0]

for i in range(1, len(numbers)):
    node = numbers[i]
    last = stack[-1]

    #1. 현재 노드가 스택의 맨 위보다 작으면 왼쪽 자식
    if node < last:
        if last not in tree:
            tree[last] = [None, None]
        tree[last][0] = node
        stack.append(node)
    #2. 현재 노드가 크면, 이 노드가 누구의 오른쪽 자식인지 찾기 위해 pop
    else:
        while stack and stack[-1] < node:
            last = stack.pop()

        if last not in tree:
            tree[last] = [None, None]
        tree[last][1] = node
        stack.append(node)

# 후위순회
def postorder(node):
    # 자식이 없는 리프 노드이거나 None인 경우 처리
    if node is None:
        return

    # 해당 노드에 자식 정보가 있다면 탐색
    if node in tree:
        postorder(tree[node][0]) # 왼쪽 자식 방문
        postorder(tree[node][1]) # 오른쪽 자식 방문

    # 자식들 다 방문한 뒤 나(루트) 출력
    print(node)

postorder(root)