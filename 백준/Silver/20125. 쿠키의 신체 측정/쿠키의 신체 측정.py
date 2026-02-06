N = int(input())
board = [list(input().strip()) for _ in range(N)]
# 맨 위에 있는게 머리고, 그 바로 아래가 심장
head = (0,0)
heart = (0,0)
left_arm, right_arm, waist, left_leg, right_leg = 0,0,0,0,0
for i in range(N):
    for j in range(N):
        if board[i][j] == '*':
            # 머리가 나왔을때
            # 머리 바로 밑에는 심장
            if head == (0,0):
                head = (i, j)
                heart = (i+1, j)
            if i == heart[0]:
                # 왼쪽 팔과 오른쪽 팔 길이 재기
                if j < heart[1]:
                    left_arm += 1
                elif j > heart[1]:
                    right_arm += 1
            if j == heart[1]:
                # 허리 길이 재기
                if i > heart[0]:
                    waist += 1
            if j == (heart[1]-1) :
                # 왼쪽 다리 길이 재기
                if i > heart[0]:
                    left_leg += 1
            if j == (heart[1]+1):
                # 오른쪽 다리 길이 재기
                if i > heart[0]:
                    right_leg += 1

# 심장의 위치 x,y
# 왼쪽 팔, 오른쪽 팔, 허리, 왼쪽 다리, 오른쪽 다리 길이
print(heart[0]+1, heart[1]+1)
print(left_arm, right_arm, waist, left_leg, right_leg)