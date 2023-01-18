import sys

st1 = list(sys.stdin.readline().rstrip())
st2 = []
M = int(sys.stdin.readline())

for _ in range(M):
    order = list(sys.stdin.readline().split())
    if order[0] == "L":
        if st1:
            st2.append(st1.pop())
    elif order[0] == 'D':
        if st2:
            st1.append(st2.pop())
    elif order[0] == 'B':
        if st1:
            st1.pop()
    elif order[0] == 'P':
        st1.append(order[1])
st1.extend(reversed(st2))
print(''.join(st1))