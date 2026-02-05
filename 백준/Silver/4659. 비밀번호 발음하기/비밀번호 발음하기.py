# 모음 하나를 반드시 포함해야 한다.
def condition1(str):
    moeum = set("aeiou")
    for s in str:
        if s in moeum:
            return True
    return False

# 모음이 3개 혹은 자음이 3개 연속으로 오면 안된다.
def condition2(str):
    moeum = set("aeiou")
    moeum_cnt = 0
    zaeum_cnt = 0
    for s in str:
        if s in moeum:
            moeum_cnt += 1
            zaeum_cnt = 0
        else:
            zaeum_cnt += 1
            moeum_cnt = 0

        if zaeum_cnt == 3 or moeum_cnt == 3:
            return False
    return True

# 같은 글자가 연속적으로 두번 오면 안되나, ee와 oo는 허용한다.
def condition3(str):
    now = str[0]
    for i in range(1, len(str)):
        if now == str[i]:
            if (now + str[i] == "ee") or (now + str[i] == "oo"):
                now = str[i]
                continue
            else:
                return False
        now = str[i]
    return True

while True:
    str = input()
    if str == 'end':
        break

    str = list(str)
    if(condition1(str) and condition2(str) and condition3(str)):
        print("<"+"".join(str)+"> is acceptable.")
    else:
        print("<"+"".join(str)+"> is not acceptable.")
