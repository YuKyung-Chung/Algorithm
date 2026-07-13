
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    result = ''
    number = float(input())
    cnt = 0
    while number != 0:
        number *= 2
        cnt += 1
        bit = int(number)
        result += str(bit)
        number -= bit

        if cnt == 13:
            break


    if cnt == 13:
        print('#' + str(test_case), "overflow")
    else:
        print('#' + str(test_case), result)