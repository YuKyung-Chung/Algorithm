case = int(input())

for _ in range(case):
    student = list(map(int,input().split()))
    stu_avg = sum(student[1:])/student[0]
    cnt = 0
    for score in student[1:]:
        if score > stu_avg:
            cnt += 1
    rate = cnt/student[0]*100
    print(f'{rate:.3f}%')