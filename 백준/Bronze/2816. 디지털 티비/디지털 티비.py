N = int(input())
channels = []
for _ in range(N):
    channels.append(input())

cursor = 0
answer = ""

def move_cursor_down(K):
    global cursor, answer
    for _ in range(K):
        # 커서가 범위를 넘지 않는 입력만 만든다고 가정
        if cursor + 1 >= len(channels): # 범위 넘어가면 무시
            break
        cursor += 1
        answer += "1"

def swap_up(times):
    global cursor, answer, channels
    for _ in range(times):
        if cursor -1 <0:
            break
        channels[cursor], channels[cursor-1] = channels[cursor-1], channels[cursor]
        cursor -= 1
        answer += "4"

def index_of(target):
    return channels.index(target)

# 1) KBS1을 0번으로
i1 = index_of("KBS1")
move_cursor_down(i1 - cursor) # cursor는 0이라 보통 i1번
swap_up(i1) #KBS1을 맨 위로

# 2) KBS2를 1번으로
i2 = index_of("KBS2")
move_cursor_down(i2 - cursor)
swap_up(i2 -1) # 1번까지 끌어올림

print(answer)